package com.jpmc.midascore.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class UserRecord {
    @Id
    private String id; // Changed from Long to String based on your usage

    private Float balance;

    @OneToMany(mappedBy = "sender")
    private List<TransactionRecord> sentTransactions;

    @OneToMany(mappedBy = "recipient")
    private List<TransactionRecord> receivedTransactions;

    // Add this constructor
    public UserRecord(String id, Float balance) {
        this.id = id;
        this.balance = balance;
    }

    // Default constructor required by JPA
    public UserRecord() {
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Float getBalance() { return balance; }
    public void setBalance(Float balance) { this.balance = balance; }
}