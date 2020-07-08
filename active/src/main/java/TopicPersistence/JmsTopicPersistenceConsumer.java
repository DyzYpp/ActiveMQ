package TopicPersistence;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @ClassName JmsConsumer
 * @Author
 * @Date 2020/6/23
 * @description
 */
public class JmsTopicPersistenceConsumer {

    /**
     * mq链接的主机
     */
    private static final String ACTIVEMQ_URL = "tcp://47.105.63.60:61616";
    /**
     * 队列名称
     */
    private static final String TOPIC_NAME = "TOPIC_01";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("消费者张三");
        // 1.创建工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        // 2.创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.setClientID("张三");
        // 3.创建session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 4.创建目的地
        Topic topic = session.createTopic(TOPIC_NAME);
        TopicSubscriber subscriber = session.createDurableSubscriber(topic, "remark");
        connection.start();

        Message message = subscriber.receive();
        // 6.接受消息
        while (null != message) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("消费者接受到消息" + textMessage.getText());
            message = subscriber.receive(2000L);
        }
//         7.关闭资源
        session.close();
        connection.close();

    }
}
