package cn.com.utils.rocketMQ;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

/**
 * 消费者
 *
 * @Author:
 * @create: 2018/4/26 17:18
 */
@Service
public class RocketMQConsumer {

    private static Log logger = LogFactory.getLog(RocketMQConsumer.class);
    /**
     * 消费者的组名
     */
    @Value("${apache.rocketmq.consumer.pushConsumer}")
    private String consumerGroup;

    /**
     * NameServer 地址
     */
    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;

    /**
     * Topic队列名称
     */
    @Value("${apache.rocketmq.Topic}")
    private String Topic;

    ///**
    // * 批量消费，一次消费多少条消息
    // */
    //@Value("${apache.rocketmq.MessageBatchMaxSize}")
    //private int MessageBatchMaxSize;

    /**
     * 多少秒拉取一次
     */
    //@Value("${apache.rocketmq.PullInterval}")
    //private int PullInterval;
    @PostConstruct //@PostContruct是spring框架的注解，在方法上加该注解会在项目启动的时候执行该方法，也可以理解为在spring容器初始化的时候执行该方法。
    public void defaultMQPushConsumer() {
        //消费者的组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
        //指定NameServer地址，多个地址以 ; 隔开
        consumer.setNamesrvAddr(namesrvAddr);
        try {
            //订阅PushTopic下Tag为push的消息
            consumer.subscribe(Topic, "*");
            //如果非第一次启动，那么按照上次消费的位置继续消费
            //设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            //批量消费，一次消费多少条消息
            //consumer.setConsumeMessageBatchMaxSize(MessageBatchMaxSize);
            //30秒拉取一次
            //consumer.setPullInterval(PullInterval);
            //线程数
            //consumer.setConsumeThreadMax(1);
            //consumer.setConsumeThreadMin(1);
            //批量拉消息，一次最多拉多少条
            //consumer.setPullBatchSize(MessageBatchMaxSize+1);
            //注册消费的监听
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                /**
                 * 默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
                 */
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext arg1) {
                    String uuid = UUID.randomUUID().toString().replace("-", "");
                    try {
                        String mes = new String(msgs.get(0).getBody());
                        System.out.println("消费"+ mes);
                        //return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                        //return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                        throw  new  Exception("异常"+mes);
                    } catch (Exception e) {
                        logger.error(uuid + " $$$运单派送任务执行任务异常,运单号 : " + e.getMessage(), e);
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    }
                    //return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }

            });
            consumer.start();
        } catch (Exception e) {
            logger.error("MQ运行失败!", e);
        }
    }
}
 