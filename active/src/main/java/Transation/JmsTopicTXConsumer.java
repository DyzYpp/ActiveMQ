package Transation;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @ClassName JmsConsumer
 * @Author
 * @Date 2020/6/23
 * @description
 */
public class JmsTopicTXConsumer {

    /**
     * mq链接的主机
     */
    private static final String ACTIVEMQ_URL = "tcp://192.168.138.132:61616";
    /**
     * 队列名称
     */
    private static final String TOPIC_NAME = "TOPIC_01";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("我是3号消费者");
        // 1.创建工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        // 2.创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        // 3.创建session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 4.创建目的地
        Topic topic = session.createTopic(TOPIC_NAME);

        // 5.创建消费者
        MessageConsumer messageConsumer = session.createConsumer(topic);

        // 6.接受消息
//        while (true) {
//            TextMessage textMessage = (TextMessage) messageConsumer.receive(4000L);
//            if (textMessage != null){
//                System.out.println("消费者接受到消息"+textMessage.getText());
//            }else{
//                break;
//            }
//        }

        // 7.关闭资源
//        messageConsumer.close();
//        session.close();
//        connection.close();

        // 通过监听的方式来消费消息
        messageConsumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                if (null != message && message instanceof TextMessage){
                   TextMessage textMessage =  (TextMessage)message;
                    try {
                        System.out.println("消费者接受到消息"+textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.in.read();
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
