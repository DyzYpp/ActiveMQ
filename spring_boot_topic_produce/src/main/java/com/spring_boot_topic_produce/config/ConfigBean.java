package com.spring_boot_topic_produce.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

/**
 * @ClassName ConfigBean
 * @Author
 * @Date 2020/7/7
 * @description
 */
@Component
public class ConfigBean {

    @Value("${myTopic}")
    private String topicName;

    @Bean
    public Topic topic(){
        return new ActiveMQTopic(topicName);
    }
}
