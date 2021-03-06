package com.kafka.app.message.produce;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Value("${spring.kafka.topic.first}")
    protected String destinationTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String payload){
        logger.info("Message: "+payload+" sent to topic: "+destinationTopic);
        Date date = new Date();
        long timeMilli = date.getTime();
        System.out.println("Time in milliseconds using Date class: " + timeMilli);
        kafkaTemplate.send(destinationTopic, payload);
    }

}