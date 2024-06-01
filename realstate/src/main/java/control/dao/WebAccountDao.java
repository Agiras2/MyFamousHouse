package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.WebAccount;
import model.util.DatabaseUtil;

public class WebAccountDao {

    
    public void addWebAccount(WebAccount webAccount) throws SQLException {
        String sql = "INSERT INTO webaccount (ID_CUSTOMER, USERNAME, PASSWORD, EMAIL) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, webAccount.getIdCustomer());
            statement.setString(2, webAccount.getUsername());
            statement.setString(3, webAccount.getPassword());
            statement.setString(4, webAccount.getEmail());

            statement.executeUpdate();
        }
    }

    
    public WebAccount getWebAccountByIdCustomer(int idCustomer) throws SQLException {
        String sql = "SELECT * FROM webaccount WHERE ID_CUSTOMER = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idCustomer);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new WebAccount(
                    resultSet.getInt("ID_CUSTOMER"),
                    resultSet.getString("USERNAME"),
                    resultSet.getString("PASSWORD"),
                    resultSet.getString("EMAIL")
                );
            }
        }

        return null;
    }


   
    public void updateWebAccount(WebAccount webAccount) throws SQLException {
        String sql = "UPDATE webaccount SET USERNAME = ?, PASSWORD = ?, EMAIL = ? WHERE ID_CUSTOMER = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, webAccount.getUsername());
            statement.setString(2, webAccount.getPassword());
            statement.setString(3, webAccount.getEmail());
            statement.setInt(4, webAccount.getIdCustomer());

            statement.executeUpdate();
        }
    }

   
    public void deleteWebAccountByCustomerId(int idCustomer) throws SQLException {
        String sql = "DELETE FROM webaccount WHERE ID_CUSTOMER = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idCustomer);
            statement.executeUpdate();
        }
    }

   
    public WebAccount getWebAccountByEmailAndPassword(String email, String password) throws SQLException {
        String sql = "SELECT * FROM webaccount WHERE EMAIL = ? AND PASSWORD = ?";

        try (Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new WebAccount(
                    resultSet.getInt("ID_CUSTOMER"),
                    resultSet.getString("USERNAME"),
                    resultSet.getString("PASSWORD"),
                    resultSet.getString("EMAIL")
                );
            }
        }

        return null;
    }

   
    public boolean verifyUser(String email, String password) throws SQLException {
        String sql = "SELECT * FROM webaccount WHERE EMAIL = ? AND PASSWORD = ?";

        try (Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        }
    }

    public int getCustomerIdByEmail(String email) throws SQLException {
        String sql = "SELECT ID_CUSTOMER FROM webaccount WHERE EMAIL = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("ID_CUSTOMER");
                } else {
                    throw new SQLException("No customer found with the provided email.");
                }
            }
        }
    }
}

