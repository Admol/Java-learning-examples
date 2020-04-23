package com.example.kafka.demo.config.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡夫卡消费者配置
 * @author : jingling
 * @Date : 2018/4/12
 */
@Configuration
@EnableKafka
@Slf4j
public class KafkaConsumerConfig {


    @Value("${kafka.bootstrap.servers}")
    private String bootstrapServers;
    @Value("${kafka.enable.auto.commit}")
    private String enableAutoCommit;
    @Value("${kafka.auto.commit.interval.ms}")
    private String autoCommitIntervalMs;
    @Value("${kafka.session.timeout.ms}")
    private String sessionTimeoutMs;
    @Value("${kafka.group.id}")
    private String groupId;
    @Value("${kafka.auto.offset.reset}")
    private String autoOffsetReset;

    public Map<String, Object> consumerConfigs() {
        Map<String, Object> propsMap = new HashMap<>();
        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        //如果为true，消费者的offset将在后台周期性的提交
        propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
        //如果enable.auto.commit设置为true，则消费者偏移量自动提交给Kafka的频率（以毫秒为单位）
        propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitIntervalMs);
        //ZooKeeper会话超时。如果消费者在这段时间内没有对ZooKeeper心跳，那么它被认为是死亡的，并且会发生重新平衡。
        propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeoutMs);
        //key的解析序列化接口实现类
        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        //value的解析序列化接口实现类
        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        //此消费者所属消费者组的唯一标识。
        propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        //当Kafka中没有初始offset或如果当前的offset不存在时（例如，该数据被删除了），该怎么办。
        //earliest：自动将偏移重置为最早的偏移
        //latest：自动将偏移重置为最新偏移
        //none：如果消费者组找到之前的offset，则向消费者抛出异常
        //anything else：抛出异常给消费者。
        propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        return propsMap;
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        //并发
        factory.setConcurrency(3);
        // 设置消费者在等待记录时阻止的最长时间。
        factory.getContainerProperties().setPollTimeout(3000);
        return factory;
    }

    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }
    @Bean
    public Listener listener() {
        return new Listener();
    }

}
