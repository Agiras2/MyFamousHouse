package model.entity;

import java.sql.Timestamp;

public class Customers {
    private int idCustomer;
    private String name;
    private String lastName1;
    private String lastName2;
    private String address;
    private long phone;
    private Timestamp birth;

    public Customers(String address, Timestamp birth, int idCustomer, String lastName1, String lastName2, String name, long phone) {
        this.address = address;
        this.birth = birth;
        this.idCustomer = idCustomer;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.name = name;
        this.phone = phone;
    }

    public Customers() {
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public String getName() {
        return name;
    }

    public String getLastName1() {
        return lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public String getAddress() {
        return address;
    }

    public long getPhone() {
        return phone;
    }

    public Timestamp getBirth() {
        return birth;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }
}
