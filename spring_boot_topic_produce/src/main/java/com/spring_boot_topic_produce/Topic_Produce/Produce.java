package com.spring_boot_topic_produce.Topic_Produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.jms.Topic;
import java.util.UUID;

/**
 * @ClassName Produce
 * @Author
 * @Date 2020/7/7
 * @description
 */
@Service
public class Produce {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Topic topic;

    @Scheduled(fixedDelay = 3000)
    public void produceMsg(){
        jmsTemplate.convertAndSend(topic,"springboot主题消息"+ UUID.randomUUID().toString().substring(0,6));
    }
}
