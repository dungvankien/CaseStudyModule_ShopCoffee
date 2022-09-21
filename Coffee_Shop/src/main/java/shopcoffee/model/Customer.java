package shopcoffee.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

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
    @Length(min=2, max = 45, message = "Customer name is between 2 and 16 characters")
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
    @Pattern(regexp = "^[0][1-9][0-9]{8}$", message = "Phone number start 0 and have 10 character")
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
