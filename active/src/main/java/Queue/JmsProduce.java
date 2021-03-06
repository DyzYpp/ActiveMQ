package Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

/**
 * @ClassName JmsProduce
 * @Author
 * @Date 2020/6/23
 * @description
 */
public class JmsProduce {

    /**
     * mq链接的主机
     */
//    private static final String ACTIVEMQ_URL = "tcp://47.105.63.60:61616";
    private static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    /**
     * 队列名称
     */
    private static final String QUEUE_NAME = "QUEUE_01";

    public static void main(String[] args) throws JMSException {

        // 1.创建链接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        // 2.获取connection链接,并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        // 3.创建session会话
        // 两个参数 事务  签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 4.创建目的地(具体是Queue 还是 topic)
        Queue queue = session.createQueue(QUEUE_NAME);

        // 5.创建消息的生产者
        MessageProducer messageProducer = session.createProducer(queue);
        for (int i = 0; i < 3; i++) {
            // 6.创建消息
            TextMessage textMessage = session.createTextMessage("队列" + QUEUE_NAME + "第" + i + "条消息");
            // 7.发送消息到MQ
            messageProducer.send(textMessage);
        }
        // 8.关闭资源
        messageProducer.close();
        session.close();
        connection.close();
        System.out.println("消息发布完成");
    }
}
