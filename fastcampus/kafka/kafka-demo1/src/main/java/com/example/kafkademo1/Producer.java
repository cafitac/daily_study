package com.example.kafkademo1;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer {

    private final static String BOOTSTRAP_SERVER = "localhost:9092";
    private final static String TOPIC_NAME = "topic5";

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.ACKS_CONFIG, "all");
        configs.put(ProducerConfig.RETRIES_CONFIG, "100");

        final KafkaProducer<String, String> producer = new KafkaProducer<>(configs);

        final String message = "First Message";

        final ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, message);

        final RecordMetadata metadata = producer.send(record).get();

        System.out.printf(">>> %s, %d, %d", message, metadata.partition(), metadata.offset());

        producer.flush();
        producer.close();
    }
}
