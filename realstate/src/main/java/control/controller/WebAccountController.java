package control.controller;

import java.sql.SQLException;

import control.dao.WebAccountDao;
import model.entity.WebAccount;

public class WebAccountController {

    private final WebAccountDao webAccountDao = new WebAccountDao();

    public void addWebAccount(WebAccount webAccount) {
        try {
            webAccountDao.addWebAccount(webAccount);
            System.out.println("Web account added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding web account: " + e.getMessage());
        }
    }

    public void displayWebAccountById(int idCustomer) {
        try {
            WebAccount webAccount = webAccountDao.getWebAccountByIdCustomer(idCustomer);
            if (webAccount != null) {
                System.out.println(webAccount);
            } else {
                System.out.println("Web account not found with ID: " + idCustomer);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching web account: " + e.getMessage());
        }
    }

    public void updateWebAccount(WebAccount webAccount) {
        try {
            webAccountDao.updateWebAccount(webAccount);
            System.out.println("Web account updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating web account: " + e.getMessage());
        }
    }

    public void deleteWebAccount(int idCustomer) {
        try {
            webAccountDao.deleteWebAccountByCustomerId(idCustomer);
            System.out.println("Web account deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting web account: " + e.getMessage());
        }
    }

    public void displayWebAccountByEmailAndPassword(String email, String password) {
        try {
            WebAccount webAccount = webAccountDao.getWebAccountByEmailAndPassword(email, password);
            if (webAccount != null) {
                System.out.println(webAccount);
            } else {
                System.out.println("Web account not found with email: " + email + " and password: " + password);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching web account: " + e.getMessage());
        }
    }

    public boolean verifyUser(String email, String password) {
        try {
            boolean isValid = webAccountDao.verifyUser(email, password);
            if (isValid) {
                System.out.println("User verified successfully.");
                return true;
            } else {
                System.out.println("Invalid email or password.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error verifying user: " + e.getMessage());
            return false;
        }
    }

     public int getCustomerIdByEmail(String email) {
        try {
            return webAccountDao.getCustomerIdByEmail(email);
        } catch (SQLException e) {
            System.err.println("Error fetching customer ID: " + e.getMessage());
            return -1; 
        }
    }
}