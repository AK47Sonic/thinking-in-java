package com.sonic.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * KafkaProducerDemo
 *
 * @author Sonic
 * @since 2019/10/29
 */
public class KafkaProducerDemo {

    public static final String brokerList = "192.168.1.151:9092";
    public static final String topic = "topic-demo";
    public static final String clientID = "producer.client.id";

    public static Properties initConfig() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, clientID);
        return properties;
    }

    public static void main(String[] args) {
        Properties properties = initConfig();

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "Hello World");

        kafkaProducer.send(record);

        kafkaProducer.close();

    }

}
