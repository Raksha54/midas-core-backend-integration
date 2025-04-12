package com.jpmc.midascore.service;

import com.jpmc.midascore.entity.TransactionRecord;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.repository.TransactionRecordRepository;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class TransactionService {
    private final UserRepository userRepository;
    private final TransactionRecordRepository transactionRecordRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String INCENTIVE_API_URL = "http://localhost:8080/incentive";

    public TransactionService(UserRepository userRepository,
                              TransactionRecordRepository transactionRecordRepository) {
        this.userRepository = userRepository;
        this.transactionRecordRepository = transactionRecordRepository;
    }

    @Transactional
    public boolean processTransaction(String senderId, String recipientId, long amount) {
        UserRecord sender = userRepository.findById(senderId).orElse(null);
        UserRecord recipient = userRepository.findById(recipientId).orElse(null);

        if (sender == null || recipient == null) return false;
        if (sender.getBalance() < amount) return false;

        // Create transaction object for incentive API
        Transaction transaction = new Transaction();
        transaction.setSenderId(senderId);
        transaction.setRecipientId(recipientId);
        transaction.setAmount(amount);

        // Get incentive from API
        Incentive incentive = restTemplate.postForObject(
                INCENTIVE_API_URL,
                transaction,
                Incentive.class
        );
        long incentiveAmount = incentive.getAmount();

        // Update balances (sender pays only original amount)
        sender.setBalance(sender.getBalance() - amount);
        recipient.setBalance(recipient.getBalance() + amount + incentiveAmount);

        // Save transaction with incentive
        TransactionRecord record = new TransactionRecord();
        record.setAmount(amount);
        record.setIncentive(incentiveAmount);  // Make sure your TransactionRecord has this field
        record.setSender(sender);
        record.setRecipient(recipient);
        record.setTimestamp(LocalDateTime.now());

        userRepository.save(sender);
        userRepository.save(recipient);
        transactionRecordRepository.save(record);

        return true;
    }
}