package com.jpmc.midascore.foundation;

public class TransactionMessage {
    private String senderId;
    private String recipientId;
    private long amount;

    // Getters and Setters
    public String getSenderId() { return senderId; }
    public void setSenderId(String senderId) { this.senderId = senderId; }
    public String getRecipientId() { return recipientId; }
    public void setRecipientId(String recipientId) { this.recipientId = recipientId; }
    public long getAmount() { return amount; }
    public void setAmount(long amount) { this.amount = amount; }
}