package model.entity;

public class WebAccount {
    private int idCustomer;
    private String username;
    private String password;
    private String email;

    public WebAccount() {
    }

    public WebAccount(int idCustomer, String username, String password, String email) {
        this.idCustomer = idCustomer;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    
}
