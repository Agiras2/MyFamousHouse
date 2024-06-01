package control.controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import control.dao.CustomersDao;
import model.entity.Customers;

public class CustomersController {

    private final CustomersDao customersService = new CustomersDao();

    public void addCustomer(String address, Timestamp birth, int idCustomer, String lastName1, String lastName2, String name, long phone) {
        try {
            Customers customer = new Customers(address, birth, idCustomer, lastName1, lastName2, name, phone);
            customersService.addCustomer(customer);
            System.out.println("Customer added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding customer: " + e.getMessage());
        }
    }

    public void displayAllCustomers() {
        try {
            List<Customers> customers = customersService.getAllCustomers();
            for (Customers customer : customers) {
                System.out.println(customer);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching customers: " + e.getMessage());
        }
    }

    public void displayCustomerById(int idCustomer) {
        try {
            Customers customer = customersService.getCustomerById(idCustomer);
            if (customer != null) {
                System.out.println(customer);
            } else {
                System.out.println("Customer not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error fetching customer: " + e.getMessage());
        }
    }

    public void updateCustomer(String address, Timestamp birth, int idCustomer, String lastName1, String lastName2, String name, long phone) {
        try {
            Customers customer = new Customers(address, birth, idCustomer, lastName1, lastName2, name, phone);
            customersService.updateCustomer(customer);
            System.out.println("Customer updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating customer: " + e.getMessage());
        }
    }

    public void deleteCustomerById(int idCustomer) {
        try {
            customersService.deleteCustomer(idCustomer);
            System.out.println("Customer deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting customer: " + e.getMessage());
        }
    }

    public Customers getCustomerById(int idCustomer) {
        try {
            return customersService.getCustomerById(idCustomer);
        } catch (SQLException e) {
            System.err.println("Error fetching customer by ID: " + e.getMessage());
            return null;
        }
    }
    
}
