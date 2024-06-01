package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.Customers;
import model.util.DatabaseUtil;

public class CustomersDao {

    // Método para crear un nuevo cliente
    public void addCustomer(Customers customer) throws SQLException {
        String sql = "INSERT INTO customers (ADDRESS, BIRTH, ID_CUSTOMER, LAST_NAME_1, LAST_NAME_2, NAME, PHONE) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, customer.getAddress());
            statement.setTimestamp(2, customer.getBirth());
            statement.setInt(3, customer.getIdCustomer());
            statement.setString(4, customer.getLastName1());
            statement.setString(5, customer.getLastName2());
            statement.setString(6, customer.getName());
            statement.setLong(7, customer.getPhone());

            statement.executeUpdate();
        }
    }

    // Método para obtener un cliente por ID
    public Customers getCustomerById(int idCustomer) throws SQLException {
        String sql = "SELECT * FROM customers WHERE ID_CUSTOMER = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idCustomer);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Customers(
                    resultSet.getString("ADDRESS"),
                    resultSet.getTimestamp("BIRTH"),
                    resultSet.getInt("ID_CUSTOMER"),
                    resultSet.getString("LAST_NAME_1"),
                    resultSet.getString("LAST_NAME_2"),
                    resultSet.getString("NAME"),
                    resultSet.getLong("PHONE")
                );
            }
        }

        return null;
    }

    // Método para obtener todos los clientes
    public List<Customers> getAllCustomers() throws SQLException {
        List<Customers> customersList = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Customers customer = new Customers(
                    resultSet.getString("ADDRESS"),
                    resultSet.getTimestamp("BIRTH"),
                    resultSet.getInt("ID_CUSTOMER"),
                    resultSet.getString("LAST_NAME_1"),
                    resultSet.getString("LAST_NAME_2"),
                    resultSet.getString("NAME"),
                    resultSet.getLong("PHONE")
                );
                customersList.add(customer);
            }
        }

        return customersList;
    }

    // Método para obtener clientes por nombre
    public List<Customers> getCustomersByName(String name) throws SQLException {
        List<Customers> customersList = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE NAME = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Customers customer = new Customers(
                    resultSet.getString("ADDRESS"),
                    resultSet.getTimestamp("BIRTH"),
                    resultSet.getInt("ID_CUSTOMER"),
                    resultSet.getString("LAST_NAME_1"),
                    resultSet.getString("LAST_NAME_2"),
                    resultSet.getString("NAME"),
                    resultSet.getLong("PHONE")
                );
                customersList.add(customer);
            }
        }

        return customersList;
    }

    // Método para obtener clientes por primer apellido
    public List<Customers> getCustomersByLastName1(String lastName1) throws SQLException {
        List<Customers> customersList = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE LAST_NAME_1 = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, lastName1);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Customers customer = new Customers(
                    resultSet.getString("ADDRESS"),
                    resultSet.getTimestamp("BIRTH"),
                    resultSet.getInt("ID_CUSTOMER"),
                    resultSet.getString("LAST_NAME_1"),
                    resultSet.getString("LAST_NAME_2"),
                    resultSet.getString("NAME"),
                    resultSet.getLong("PHONE")
                );
                customersList.add(customer);
            }
        }

        return customersList;
    }

    // Método para obtener clientes por segundo apellido
    public List<Customers> getCustomersByLastName2(String lastName2) throws SQLException {
        List<Customers> customersList = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE LAST_NAME_2 = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, lastName2);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Customers customer = new Customers(
                    resultSet.getString("ADDRESS"),
                    resultSet.getTimestamp("BIRTH"),
                    resultSet.getInt("ID_CUSTOMER"),
                    resultSet.getString("LAST_NAME_1"),
                    resultSet.getString("LAST_NAME_2"),
                    resultSet.getString("NAME"),
                    resultSet.getLong("PHONE")
                );
                customersList.add(customer);
            }
        }

        return customersList;
    }

    // Método para actualizar un cliente
    public void updateCustomer(Customers customer) throws SQLException {
        String sql = "UPDATE customers SET ADDRESS = ?, BIRTH = ?, LAST_NAME_1 = ?, LAST_NAME_2 = ?, NAME = ?, PHONE = ? WHERE ID_CUSTOMER = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, customer.getAddress());
            statement.setTimestamp(2, customer.getBirth());
            statement.setString(3, customer.getLastName1());
            statement.setString(4, customer.getLastName2());
            statement.setString(5, customer.getName());
            statement.setLong(6, customer.getPhone());
            statement.setInt(7, customer.getIdCustomer());

            statement.executeUpdate();
        }
    }

    // Método para eliminar un cliente
    public void deleteCustomer(int idCustomer) throws SQLException {
        String sql = "DELETE FROM customers WHERE ID_CUSTOMER = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idCustomer);
            statement.executeUpdate();
        }
    }
}
