package com.example.kafka.demo.config.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Optional;

/**
 * @author : jingling
 * @Date : 2018/4/12
 */
@Slf4j
public class Listener {


    private final static String TEST_TOPIC = "test_topic";


    /**
     * 测试kafka监听
     * @param record
     */
    @KafkaListener(topics = TEST_TOPIC)
    public void listenTestKafka(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("测试kafka监听到message:{}",message);
            // TO DO SOMETHING
        }
    }
}
