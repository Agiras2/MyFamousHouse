package model.entity;

import java.sql.Timestamp;

public class Transactions {
    private int transactionalId;
    private int clientIdBuyer;
    private int clientIdSeller;
    private int enrollmentId;
    private Timestamp transactionDate;
    private double amount;
    private double commission;
    private boolean transactionStatus;
    private String paymentMethod;

    public Transactions() {
    }

    public Transactions(double amount, int clientIdBuyer, int clientIdSeller, double commission, int enrollmentId, String paymentMethod, Timestamp transactionDate, boolean transactionStatus, int transactionalId) {
        this.amount = amount;
        this.clientIdBuyer = clientIdBuyer;
        this.clientIdSeller = clientIdSeller;
        this.commission = commission;
        this.enrollmentId = enrollmentId;
        this.paymentMethod = paymentMethod;
        this.transactionDate = transactionDate;
        this.transactionStatus = transactionStatus;
        this.transactionalId = transactionalId;
    }

    public int getTransactionalId() {
        return transactionalId;
    }

    public void setTransactionalId(int transactionalId) {
        this.transactionalId = transactionalId;
    }

    public int getClientIdBuyer() {
        return clientIdBuyer;
    }

    public void setClientIdBuyer(int clientIdBuyer) {
        this.clientIdBuyer = clientIdBuyer;
    }

    public int getClientIdSeller() {
        return clientIdSeller;
    }

    public void setClientIdSeller(int clientIdSeller) {
        this.clientIdSeller = clientIdSeller;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public boolean isTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(boolean transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }





    
}
