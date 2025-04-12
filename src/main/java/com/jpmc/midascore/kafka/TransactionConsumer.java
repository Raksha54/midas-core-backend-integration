package com.jpmc.midascore.kafka;

import com.jpmc.midascore.foundation.TransactionMessage;
import com.jpmc.midascore.service.TransactionService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumer {
    private final TransactionService transactionService;

    public TransactionConsumer(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @KafkaListener(
            topics = "transactions",
            groupId = "midas-core-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeTransaction(TransactionMessage transaction) {
        try {
            boolean success = transactionService.processTransaction(
                    transaction.getSenderId(),
                    transaction.getRecipientId(),
                    transaction.getAmount()
            );

            if (!success) {
                System.err.println("Failed to process transaction: " + transaction);
            }
        } catch (Exception e) {
            System.err.println("Error processing transaction: " + e.getMessage());
            e.printStackTrace();
        }
    }
}