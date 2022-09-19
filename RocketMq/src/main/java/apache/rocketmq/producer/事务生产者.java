package apache.rocketmq.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: dongff
 * @description: 这个事务消息是RocketMQ提供的一个非常有特色的功能。
 * 事务消息是在分布式系统中保证最终一致性的两阶段提交的消息实现。
 * 他可以保证本地事务执行与消息发送两个操作的原子性，也就是这两个操作一起成功或者一起失败。
 *
 * 事务消息只保证消息发送者的本地事务与发消息这两个操作的原子性，
 * 因此，事务消息的示例只涉及到消息发送者，对于消息消费者来说，并没有什么特别的
 *
 * 事务限制：
 *
 *
 *     事务消息不支持延迟消息和批量消息
 *     为了避免单个消息被检查太多次而导致半队列消息累积，我们默认将单个消息的检查次数限制为15 次，但是用户可以通过 Broker 配置文件的 transactionCheckMax 参数来修改此限制
 *     事务消息将在 Broker 配置文件中的参数 transactionMsgTimeout 这样的特定时间长度之后被检查。当发送事务消息时，用户还可以通过设置用户属性 CHECK_IMMUNITY_TIME_IN_SECONDS 来改变这个限制，该参数优先于 transactionMsgTimeout 参数。
 *     事务性消息可能不止一次被检查或消费。
 *     提交给用户的目标主题消息可能会失败，目前这依日志的记录而定。
 *     事务消息的生产者 ID 不能与其他类型消息的生产者 ID 共享

 * @date: Created in 2022-09-19 10:19
 * @modified By:
 */
@Component
@Slf4j
@SpringBootTest
public class 事务生产者 {

    @Test
    public  void main1() throws Exception {
        TransactionMQProducer producer = new TransactionMQProducer("transaction_producer_group");
        //线程池
        ExecutorService executorService =  Executors.newFixedThreadPool(5);
        //事务监听器
        TransactionListener transactionListener = new TransactionListenerImpl();
        producer.setExecutorService(executorService);
        producer.setTransactionListener(transactionListener);
        producer.setNamesrvAddr("172.115.247.4:554");
        String[] tags = new String[]{"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 10; i++) {
            try {
                Message msg =
                        new Message("TopicTest1234", tags[i % tags.length], "KEY" + i,
                                ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult sendResult = producer.sendMessageInTransaction(msg, null);
                System.out.printf("%s%n", sendResult);
                Thread.sleep(10);
            } catch (MQClientException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 100000; i++) {
            Thread.sleep(1000);
        }
        producer.shutdown();
        producer.start();
    }


    public class TransactionListenerImpl implements TransactionListener {
        private AtomicInteger transactionIndex = new AtomicInteger(0);
        private ConcurrentHashMap<String, Integer> localTrans = new ConcurrentHashMap<>();

        @Override
        public LocalTransactionState executeLocalTransaction(Message message, Object o) {
            int value = transactionIndex.getAndIncrement();
            int status = value % 3;
            localTrans.put(message.getTransactionId(), status);
            return LocalTransactionState.UNKNOW;
        }

        @Override
        public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
            Integer status = localTrans.get(messageExt.getTransactionId());
            if (null != status) {
                switch (status) {
                    case 0:
                        return LocalTransactionState.UNKNOW;
                    case 1:
                        return LocalTransactionState.COMMIT_MESSAGE;
                    case 2:
                        return LocalTransactionState.ROLLBACK_MESSAGE;
                    default:
                        return LocalTransactionState.COMMIT_MESSAGE;
                }
            }
            return LocalTransactionState.COMMIT_MESSAGE;
        }

    }
}
