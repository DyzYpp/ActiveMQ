package Spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

/**
 * @ClassName SpringProduce
 * @Author
 * @Date 2020/7/6
 * @description
 */
@Service
public class SpringProduce {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringProduce produce = (SpringProduce) ctx.getBean("springProduce");

        produce.jmsTemplate.send(session -> {
            TextMessage textMessage = session.createTextMessage("spring和Active的整合case333333");
            return textMessage;
        });
        System.out.println("------send task over");
    }
}
