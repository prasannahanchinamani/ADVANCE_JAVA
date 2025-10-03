package jdbc_demo.e_commerce_management;

import java.sql.Timestamp;

public class Order {
    private int orderId;
    private int customerId;
    private String customerName;
    private Timestamp orderDate;
    private double totalAmount;

    public Order(int orderId, int customerId, String customerName, Timestamp orderDate, double totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
