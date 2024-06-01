package control.controller;

import java.sql.SQLException;
import java.util.List;

import control.dao.TransactionsDao;
import model.entity.Transactions;

public class TransactionsController {

    private final TransactionsDao transactionsService = new TransactionsDao();

    public void addTransaction(Transactions transaction) {
        try {
            transactionsService.addTransaction(transaction);
            System.out.println("Transaction added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding transaction: " + e.getMessage());
        }
    }

    public void displayTransactionById(int transactionalId) {
        try {
            Transactions transaction = transactionsService.getTransactionById(transactionalId);
            if (transaction != null) {
                System.out.println(transaction);
            } else {
                System.out.println("Transaction not found with ID: " + transactionalId);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching transaction: " + e.getMessage());
        }
    }

    public void displayAllTransactions() {
        try {
            List<Transactions> transactions = transactionsService.getAllTransactions();
            for (Transactions transaction : transactions) {
                System.out.println(transaction);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching transactions: " + e.getMessage());
        }
    }

    public void updateTransaction(Transactions transaction) {
        try {
            transactionsService.updateTransaction(transaction);
            System.out.println("Transaction updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating transaction: " + e.getMessage());
        }
    }

    public void deleteTransactionById(int transactionalId) {
        try {
            transactionsService.deleteTransactionById(transactionalId);
            System.out.println("Transaction deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting transaction: " + e.getMessage());
        }
    }
}