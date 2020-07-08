package spring_boot_acivemq.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.TextMessage;
import java.util.UUID;

/**
 * @ClassName Produce
 * @Author
 * @Date 2020/7/6
 * @description
 */
@Component
public class Consumer {

    @JmsListener(destination = "${myqueue}")
    public void receive(TextMessage textMessage) throws JMSException{
        System.out.println("消费者消费了消息:" + textMessage.getText());
    }
}
