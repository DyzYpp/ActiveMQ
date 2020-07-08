package com.spring_boot_topic_consume.Topic_Consume;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @ClassName Comsume
 * @Author
 * @Date 2020/7/7
 * @description
 */
@Service
public class Consume {

    @JmsListener(destination = "${myTopic}")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("消费者收到订阅的主题:"+ textMessage.getText());
    }
}
