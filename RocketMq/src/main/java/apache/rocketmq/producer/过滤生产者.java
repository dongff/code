package apache.rocketmq.producer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.stereotype.Component;

/**
 * @author: dongff
 * @description: 在大多数情况下，可以使用Message的Tag属性来简单快速的过滤信息。这种方式有一个很大的限制，就是一个消息只能有一个TAG，可以使用SQL表达式来对消息进行过滤。
 *
 * SQL92语法：
 *
 *
 *     数值比较，比如：>，>=，<，<=，BETWEEN，=
 *     字符比较，比如：=，<>，IN；
 *     IS NULL** 或者 IS NOT NULL；
 *     逻辑符号 AND****，OR，NOT*；
 *     常量支持类型为：
 *
 *         数值，比如：123，3.1415；
 *         字符，比如：'abc'，必须用单引号包裹起来；
 *         NULL，特殊的常量
 *         布尔值，TRUE 或 FALSE
 *
 *
 * @date: Created in 2022-09-19 10:11
 * @modified By:
 */
@Component
@Slf4j
public class 过滤生产者 {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("filter_producer");
        producer.setNamesrvAddr("192.168.106.133:9876");
        producer.start();
        //消息发送到不同的tag上
        String[] tags = new String[]{"TagA", "TagB", "TagC"};
        for (int i = 0; i < 60; i++) {
            Message msg = new Message("FilterTopic",
                    tags[i % tags.length],
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
            //给消息增加用户附加属性，可以用于sql过滤器
            msg.putUserProperty("a", String.valueOf(i));
            SendResult sendResult = producer.send(msg);
            log.info("发送结果：{}", JSON.toJSONString(sendResult));
        }
        producer.shutdown();
    }

}
