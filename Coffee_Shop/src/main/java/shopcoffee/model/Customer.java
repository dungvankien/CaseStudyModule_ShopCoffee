package shopcoffee.model;

import java.util.Date;

public class Customer {
    private int idCustomer;
    private String nameCustomer;
    private String email;
    private String phone;
    private String address;

    public Customer() {
    }

    public Customer(String nameCustomer, String email, String phone, String address) {
        this.nameCustomer = nameCustomer;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer(int idCustomer, String nameCustomer, String email, String phone, String address) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
