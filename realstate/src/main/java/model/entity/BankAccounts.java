package model.entity;

public class BankAccounts {
    private int idCustomer;
    private long accountID;
    private long moneyOnAccount;

    public BankAccounts() {
    }

    public BankAccounts(long accountID, int idCustomer, long moneyOnAccount) {
        this.accountID = accountID;
        this.idCustomer = idCustomer;
        this.moneyOnAccount = moneyOnAccount;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    public long getMoneyOnAccount() {
        return moneyOnAccount;
    }

    public void setMoneyOnAccount(long moneyOnAccount) {
        this.moneyOnAccount = moneyOnAccount;
    }

    


}
