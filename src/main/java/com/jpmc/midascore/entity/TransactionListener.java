package com.jpmc.midascore.entity;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.EnableKafka;

@Component
@EnableKafka
public class TransactionListener {

    @KafkaListener(topics = "${topic}", groupId = "transaction-consumer-group")
    public void listenToTransaction(TransactionListener transaction) {
        System.out.println("Received Transaction: " + transaction);
    }
}
