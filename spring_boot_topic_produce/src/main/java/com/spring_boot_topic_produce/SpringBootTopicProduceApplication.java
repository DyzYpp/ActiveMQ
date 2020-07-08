package com.spring_boot_topic_produce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBootTopicProduceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTopicProduceApplication.class, args);
	}

}
