package apache.rocketmq.producer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-19 9:56
 * @modified By:
 */
@Slf4j
public class 批量消息_简单批量消息生产者 {

    public static void main(String[] args) throws Exception {
        try { //初始化一个生成者组
            DefaultMQProducer producer = new DefaultMQProducer("batch_producer_group");
            // 设置name server地址
            producer.setNamesrvAddr("192.168.106.133:9876");
            producer.start();
            String topic = "BatchTest";
            List<Message> messages = new ArrayList<>();
            messages.add(new Message(topic, "Tag", "OrderID001", "Hello world 0".getBytes()));
            messages.add(new Message(topic, "Tag", "OrderID002", "Hello world 1".getBytes()));
            messages.add(new Message(topic, "Tag", "OrderID003", "Hello world 2".getBytes()));
            //发送批量消息
            SendResult send = producer.send(messages);
            log.info("发送消息结果：{}", JSON.toJSONString(send));
            producer.shutdown();

        } catch (Exception e) {
            log.error("产生了异常", e);
        }
    }

}
