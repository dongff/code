package cn.com.utils.rocketMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 *
 * @Author: Lic
 * @create: 2018/4/26 17:17
 */
@RestController
public class TestController {
    @Autowired
    RocketMQProducer mqProducer;

    @Autowired
    RocketMQConsumer rocketMQConsumer;

    @RequestMapping("/MQprovider")
    public String provider() throws Exception{
        List<String> list = new ArrayList<>(10);
        for (int i = 1; i <= 3; i++) {
            list.add("消息" + i + "！");
            mqProducer.send("发送"+i,"消息"+i);
        }
        return "发送MQ成功";
    }

    @RequestMapping("/MQconsumer")
    public String consumer() {
        rocketMQConsumer.defaultMQPushConsumer();
        return "消费MQ成功";
    }

}