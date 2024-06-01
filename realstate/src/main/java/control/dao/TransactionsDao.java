package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Transactions;
import model.util.DatabaseUtil;

public class TransactionsDao {

   
    public void addTransaction(Transactions transaction) throws SQLException {
        String sql = "INSERT INTO transactions (TRANSACTIONAL_ID, CLIENT_ID_BUYER, CLIENT_ID_SELLER, ENROLLMENT_ID, TRANSACTION_DATE, AMOUNT, COMMISSION, TRANSACTION_STATUS, PAYMENT_METHOD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, transaction.getTransactionalId()); 
            statement.setInt(2, transaction.getClientIdBuyer());
            statement.setInt(3, transaction.getClientIdSeller());
            statement.setInt(4, transaction.getEnrollmentId());
            statement.setTimestamp(5, transaction.getTransactionDate());
            statement.setDouble(6, transaction.getAmount());
            statement.setDouble(7, transaction.getCommission());
            statement.setBoolean(8, transaction.isTransactionStatus());
            statement.setString(9, transaction.getPaymentMethod());

            statement.executeUpdate();
        }
    }


  
    public Transactions getTransactionById(int transactionalId) throws SQLException {
        String sql = "SELECT * FROM transactions WHERE TRANSACTIONAL_ID = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, transactionalId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Transactions(
                    resultSet.getDouble("AMOUNT"),
                    resultSet.getInt("CLIENT_ID_BUYER"),
                    resultSet.getInt("CLIENT_ID_SELLER"),
                    resultSet.getDouble("COMMISSION"),
                    resultSet.getInt("ENROLLMENT_ID"),
                    resultSet.getString("PAYMENT_METHOD"),
                    resultSet.getTimestamp("TRANSACTION_DATE"),
                    resultSet.getBoolean("TRANSACTION_STATUS"),
                    resultSet.getInt("TRANSACTIONAL_ID")
                );
            }
        }

        return null;
    }

 
    public List<Transactions> getAllTransactions() throws SQLException {
        String sql = "SELECT * FROM transactions";
        List<Transactions> transactionsList = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Transactions transaction = new Transactions(
                    resultSet.getDouble("AMOUNT"),
                    resultSet.getInt("CLIENT_ID_BUYER"),
                    resultSet.getInt("CLIENT_ID_SELLER"),
                    resultSet.getDouble("COMMISSION"),
                    resultSet.getInt("ENROLLMENT_ID"),
                    resultSet.getString("PAYMENT_METHOD"),
                    resultSet.getTimestamp("TRANSACTION_DATE"),
                    resultSet.getBoolean("TRANSACTION_STATUS"),
                    resultSet.getInt("TRANSACTIONAL_ID")
                );
                transactionsList.add(transaction);
            }
        }

        return transactionsList;
    }


    public void updateTransaction(Transactions transaction) throws SQLException {
        String sql = "UPDATE transactions SET CLIENT_ID_BUYER = ?, CLIENT_ID_SELLER = ?, ENROLLMENT_ID = ?, TRANSACTION_DATE = ?, AMOUNT = ?, COMMISSION = ?, TRANSACTION_STATUS = ?, PAYMENT_METHOD = ? WHERE TRANSACTIONAL_ID = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, transaction.getClientIdBuyer());
            statement.setInt(2, transaction.getClientIdSeller());
            statement.setInt(3, transaction.getEnrollmentId());
            statement.setTimestamp(4, transaction.getTransactionDate());
            statement.setDouble(5, transaction.getAmount());
            statement.setDouble(6, transaction.getCommission());
            statement.setBoolean(7, transaction.isTransactionStatus());
            statement.setString(8, transaction.getPaymentMethod());
            statement.setInt(9, transaction.getTransactionalId());

            statement.executeUpdate();
        }
    }

    public void deleteTransactionById(int transactionalId) throws SQLException {
        String sql = "DELETE FROM transactions WHERE TRANSACTIONAL_ID = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, transactionalId);
            statement.executeUpdate();
        }
    }
}
