package apache.rocketmq.producer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-19 9:58
 * @modified By:
 */
@Slf4j
@Component
@SpringBootTest
public class 批量消息_批量消息迭代器 {

    @Test
    public  void test() throws Exception {
        try {
            //初始化一个生成者组
            DefaultMQProducer producer = new DefaultMQProducer("split_producer_group");
            //设置name server地址
            producer.setNamesrvAddr("192.168.106.133:9876");
            producer.start();
            String topic = "splitBatchTest";
            List<Message> messages = new ArrayList<>();
            messages.add(new Message(topic, "Tag", "OrderID001", "Hello world 0".getBytes()));
            messages.add(new Message(topic, "Tag", "OrderID002", "Hello world 1".getBytes()));
            messages.add(new Message(topic, "Tag", "OrderID003", "Hello world 2".getBytes()));
            //使用自定迭代一，每次发送一定数量数据
            ListSplitter splitter = new ListSplitter(messages);
            while (splitter.hasNext()) {
                List<Message> listItem = splitter.next();
                //发送批量消息
                SendResult send = producer.send(listItem);
                log.info("发送消息结果：{}", JSON.toJSONString(send));
            }
            producer.shutdown();
        } catch (Exception e) {
            log.error("产生了异常", e);
        }
    }


    public class ListSplitter implements Iterator<List<Message>> {
        private int sizeLimit = 1000 * 1000;
        private final List<Message> messages;
        private int currIndex;

        public ListSplitter(List<Message> messages) {
            this.messages = messages;
        }

        @Override
        public boolean hasNext() {
            return currIndex < messages.size();
        }

        @Override
        public List<Message> next() {
            int nextIndex = currIndex;
            int totalSize = 0;
            for (; nextIndex < messages.size(); nextIndex++) {
                Message message = messages.get(nextIndex);
                int tmpSize = message.getTopic().length() + message.getBody().length;
                Map<String, String> properties = message.getProperties();
                for (Map.Entry<String, String> entry : properties.entrySet()) {
                    tmpSize += entry.getKey().length() + entry.getValue().length();
                }
                tmpSize = tmpSize + 20;
                //for log overhead
                if (tmpSize > sizeLimit) {
                    //it is unexpected that single message exceeds the sizeLimit
                    // here just let it go, otherwise it will block the splitting process
                    if (nextIndex - currIndex == 0) {
                        // if the next sublist has no element, add this one and then break, otherwise just break
                        nextIndex++;
                    }
                    break;
                }
                if (tmpSize + totalSize > sizeLimit) {
                    break;
                } else {
                    totalSize += tmpSize;
                }
            }
            List<Message> subList = messages.subList(currIndex, nextIndex);
            currIndex = nextIndex;
            return subList;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not allowed to remove");
        }
    }
}



