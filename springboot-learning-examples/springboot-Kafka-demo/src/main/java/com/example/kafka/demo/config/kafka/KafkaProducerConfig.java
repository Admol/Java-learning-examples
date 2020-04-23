package com.example.kafka.demo.config.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡夫卡生产者
 * @author : jingling
 * @Date : 2018/4/12
 */

@Configuration
@EnableKafka
@Slf4j
public class KafkaProducerConfig {

    @Value("${kafka.bootstrap.servers}")
    private String bootstrapServers;
    @Value("${kafka.retries}")
    private String retries;
    @Value("${kafka.batch.size}")
    private String batchSize;
    @Value("${kafka.linger.ms}")
    private String lingerMs;
    @Value("${kafka.buffer.memory}")
    private String bufferMemory;

    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        //无需添加所有的集群地址，kafka会根据提供的地址发现其他的地址
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        //请求失败自动重试, 大于0可能会有重复消息
        props.put(ProducerConfig.RETRIES_CONFIG, retries);
        //缓冲大小,当多个消息要发送到相同分区的时，生产者尝试将消息批量打包在一起，以减少请求交互。
        //这样有助于客户端和服务端的性能提升。该配置的默认批次大小（以字节为单位）
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        //不是立即发出一个消息，生产者将等待一个给定的延迟，以便和其他的消息可以组合成一个批次。
        props.put(ProducerConfig.LINGER_MS_CONFIG, lingerMs);
        //生产者用来缓存等待发送到服务器的消息的内存总字节数。
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    public ProducerFactory<Object, Object> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<Object, Object> kafkaTemplate() {
        return new KafkaTemplate<Object, Object>(producerFactory());
    }
}
