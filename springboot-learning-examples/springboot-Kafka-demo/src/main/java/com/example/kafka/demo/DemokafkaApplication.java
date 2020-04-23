package com.example.kafka.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class DemokafkaApplication {

	public static void main(String[] args) throws InterruptedException{
		ApplicationContext app = SpringApplication.run(DemokafkaApplication.class, args);
		for (int i = 0 ; i < 10 ; i++){
			KafkaTemplate sender = app.getBean(KafkaTemplate.class);
			sender.send("test_topic","this is test message " + i);
			Thread.sleep(500);
		}
	}
}
