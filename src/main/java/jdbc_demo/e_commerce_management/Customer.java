package jdbc_demo.e_commerce_management;

import java.sql.Timestamp;
import java.sql.Timestamp;


public class Customer {
    private int customerId;
    private String fullName;
    private String email;
    private String phone;
    private Timestamp creditedAt;

    public Customer(int customerId, String fullName, String email, String phone, Timestamp creditedAt) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.creditedAt = creditedAt;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
