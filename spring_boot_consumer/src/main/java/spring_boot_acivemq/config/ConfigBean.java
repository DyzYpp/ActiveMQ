package spring_boot_acivemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @ClassName ConfigBean
 * @Author
 * @Date 2020/7/6
 * @description
 */
@Component
@EnableJms
public class ConfigBean {

    @Value("${myqueue}")
    private String myQueueName;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(myQueueName);
    }
}
