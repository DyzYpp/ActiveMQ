package Spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName SpringConsumer
 * @Author
 * @Date 2020/7/6
 * @description
 */
@Service
public class SpringConsumer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringConsumer consumer = (SpringConsumer) ctx.getBean("springConsumer");

        String receiveValue = (String) consumer.jmsTemplate.receiveAndConvert();

        System.out.println("消费者收到的消息" + receiveValue);
    }
}
