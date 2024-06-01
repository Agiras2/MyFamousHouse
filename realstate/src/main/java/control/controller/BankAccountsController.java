package control.controller;

import java.sql.SQLException;
import java.util.List;

import control.dao.BankAccountsDao;
import model.entity.BankAccounts;

public class BankAccountsController {

    private final BankAccountsDao bankAccountsService = new BankAccountsDao();

    public void addBankAccount(BankAccounts bankAccount) {
        try {
            bankAccountsService.addBankAccount(bankAccount);
            System.out.println("Bank account added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding bank account: " + e.getMessage());
        }
    }

    public void displayBankAccountById(int accountID) {
        try {
            BankAccounts bankAccount = bankAccountsService.getBankAccountById(accountID);
            if (bankAccount != null) {
                System.out.println(bankAccount);
            } else {
                System.out.println("Bank account not found with ID: " + accountID);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching bank account: " + e.getMessage());
        }
    }

    public void displayBankAccountsByCustomerId(int idCustomer) {
        try {
            List<BankAccounts> bankAccounts = bankAccountsService.getBankAccountsByCustomerId(idCustomer);
            for (BankAccounts bankAccount : bankAccounts) {
                System.out.println(bankAccount);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching bank accounts for customer ID " + idCustomer + ": " + e.getMessage());
        }
    }

    public void updateBankAccount(BankAccounts bankAccount) {
        try {
            bankAccountsService.updateBankAccount(bankAccount);
            System.out.println("Bank account updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating bank account: " + e.getMessage());
        }
    }

    public void deleteBankAccount(long accountID) {
        try {
            bankAccountsService.deleteBankAccount(accountID);
            System.out.println("Bank account deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting bank account: " + e.getMessage());
        }
    }

    public List<BankAccounts> getBankAccountsByCustomerId(int idCustomer) throws SQLException {
        return bankAccountsService.getBankAccountsByCustomerId(idCustomer);
    }


    public BankAccounts getBankAccountById(long accountID) throws SQLException {
        return bankAccountsService.getBankAccountById(accountID);

    }

}    


