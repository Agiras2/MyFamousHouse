package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.BankAccounts;
import model.util.DatabaseUtil;

public class BankAccountsDao {

    public void addBankAccount(BankAccounts bankAccount) throws SQLException {
        String sql = "INSERT INTO bankaccounts (ACCOUNT_ID, ID_CUSTOMER, MONEY_ON_ACCOUNT) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, bankAccount.getAccountID());
            statement.setInt(2, bankAccount.getIdCustomer());
            statement.setLong(3, bankAccount.getMoneyOnAccount());

            statement.executeUpdate();
        }
    }

    public BankAccounts getBankAccountById(long accountID) throws SQLException {
        String sql = "SELECT * FROM bankaccounts WHERE ACCOUNT_ID = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, accountID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new BankAccounts(
                        resultSet.getLong("ACCOUNT_ID"),
                        resultSet.getInt("ID_CUSTOMER"),
                        resultSet.getLong("MONEY_ON_ACCOUNT")
                );
            }
        }

        return null;
    }

    public List<BankAccounts> getBankAccountsByCustomerId(int idCustomer) throws SQLException {
        List<BankAccounts> bankAccountsList = new ArrayList<>();
        String sql = "SELECT * FROM bankaccounts WHERE ID_CUSTOMER = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idCustomer);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BankAccounts bankAccount = new BankAccounts(
                        resultSet.getLong("ACCOUNT_ID"),
                        resultSet.getInt("ID_CUSTOMER"),
                        resultSet.getLong("MONEY_ON_ACCOUNT")
                );
                bankAccountsList.add(bankAccount);
            }
        }

        return bankAccountsList;
    }

    public void updateBankAccount(BankAccounts bankAccount) throws SQLException {
        String sql = "UPDATE bankaccounts SET ID_CUSTOMER = ?, MONEY_ON_ACCOUNT = ? WHERE ACCOUNT_ID = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, bankAccount.getIdCustomer());
            statement.setLong(2, bankAccount.getMoneyOnAccount());
            statement.setLong(3, bankAccount.getAccountID());

            statement.executeUpdate();
        }
    }

    public void deleteBankAccount(long accountID) throws SQLException {
        String sql = "DELETE FROM bankaccounts WHERE ACCOUNT_ID = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, accountID);
            statement.executeUpdate();
        }
    }
}

