package cn.com.utils;


import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.SendStatus;
import com.alibaba.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.UnsupportedEncodingException;

/**
 * <p>Title: MqProducer </p>
 * <p>@Description: 发送MQ 类
 * NamesrvAddr
 * ProducerGroupName
 * InstanceName
 * SendMsgTimeout
 * 需要在配置文件中设置
 * <p>
 * 日志 建议单独配置 文件夹记录 方便问题排查
 * <p>
 * 备注：  该类是基于SPRING 管理的    请使用  SPRING    BAEN 是单例模式
 * <p>
 * <p>
 * PS: 该类不加入 没有设置注解标签 所有不会主动加入Spring 方法只使用 消费端 不使用  生产端 的环境
 * </p>
 * <p>Company:  zjs </p>
 *
 * @author 李文
 * @date 2016年8月1日 上午10:06:08
 */
@Component
public class MqProducer
{
    private DefaultMQProducer producer = null;

    private static final Logger LOGGER = LoggerFactory.getLogger(MqProducer.class);

    @Value("${Topic}")
    private String Topic;

    @Value("${Tags}")
    private String Tags;

    @Value("${MQ.NamesrvAddr}")
    private String NamesrvAddr;

    @Value("${MQ.ProducerGroupName}")
    private String ProducerGroupName;

    @Value("${MQ.InstanceName}")
    private String InstanceName;

    @Value("${MQ.SendMsgTimeout:20000}")
    private int SendMsgTimeout;

    /**
     * Broker 回查 Producer 事务状态时， 线程池大小
     */
    @Value("${MQ.checkThreadPoolMinSize:1}")
    private int checkThreadPoolMinSize;

    /**
     * Broker 回查 Producer 事务状态时， 线程池大小
     */
    @Value("${MQ.checkThreadPoolMaxSize:1}")
    private int checkThreadPoolMaxSize;

    /**
     * Broker 回查 Producer 事务状态时，Producer 本地缓冲请求队列大小
     */
    @Value("${MQ.checkRequestHoldMax:2000}")
    private int checkRequestHoldMax;

    @PostConstruct
    private void init() throws MQClientException {
        producer = new DefaultMQProducer();
        // Producer 组名， 多个 Producer 如果属于一 个应用，发送同样的消息，则应该将它们 归为同一组
        producer.setProducerGroup(ProducerGroupName);
        // Name Server 地址列表
        producer.setNamesrvAddr(NamesrvAddr);
        // 生产者名称
        producer.setInstanceName(InstanceName);
        // 超时时间
        producer.setSendMsgTimeout(SendMsgTimeout);
        producer.start();
    }

    @PreDestroy
    private void Destroy() {
        if (producer != null) {
            producer.shutdown();
        }
    }

    /**
     * 发送数据到MQ方法    数据编码格式  默认UTF-8
     *
     * @param body 发送的数据  推荐 JSOM 或者 XML 结构
     * @return 响应信息进行了内部处理  确认已经保存到 MQ 并且    日志已经记录  只要值不是NULL 就是成功发送
     * @throws Exception 转换字符集出错  请检查是否可以转换
     */
    public SendResult send(String uuid, String body)
            throws Exception {
        return this.send(uuid, Topic, Tags, body, null);
    }

    /**
     * 发送数据到MQ方法
     *
     * @param Topic    队列名称
     * @param Tags     标签名称
     * @param body     发送的数据  推荐 JSOM 或者 XML 结构
     * @param Encoding 数据编码格式  默认UTF-8
     * @return 响应信息进行了内部处理  确认已经保存到 MQ 并且    日志已经记录  只要值不是NULL 就是成功发送
     * @throws UnsupportedEncodingException 转换字符集出错  请检查是否可以转换
     */
    public SendResult send(String uuid, String Topic, String Tags, String body, String Encoding)
            throws Exception {

        LOGGER.info("{} 将要发送到Mq的数据    Topic={}   Tags={}   body={}  Encoding={} ", uuid, Topic, Tags, body,
                Encoding);

        if (Encoding == null || "".equals(Encoding)) {
            Encoding = "UTF-8";
        }

        if (Tags == null || "".equals(Tags)) {
            Tags = "*";
        }

        Message me = new Message();
        // 标示
        me.setTopic(Topic);
        // 标签
        me.setTags(Tags);
        // 内容
        me.setBody(body.getBytes(Encoding));
        // 发送信息到MQ SendResult 是当前发送的状态 官方说 不出异常 就是成功
        SendResult sendResult = null;
        try {
            sendResult = producer.send(me);
        } catch (Exception e) {
            LOGGER.error(uuid+ " 发送 数据给MQ出现异常  " + body + "  错误信息 ：" + e.getMessage(), e);
            throw new Exception(e);
        }
        // 当消息发送失败时如何处理 getSendStatus 获取发送的状态
        if (sendResult == null || sendResult.getSendStatus() != SendStatus.SEND_OK) {
            LOGGER.info(uuid+" "+body + "发送消息失败" + " MQ状态值  SendResult=" + sendResult);
            sendResult = null;
        }
        LOGGER.info(uuid + " 发送到MQ成功 " + sendResult);
        return sendResult;
    }

    // ---- set -----

    public void setNamesrvAddr(String namesrvAddr) {
        NamesrvAddr = namesrvAddr;
    }

    public void setProducerGroupName(String producerGroupName) {
        ProducerGroupName = producerGroupName;
    }

    public void setInstanceName(String instanceName) {
        InstanceName = instanceName;
    }

    public void setSendMsgTimeout(int sendMsgTimeout) {
        SendMsgTimeout = sendMsgTimeout;
    }

}
