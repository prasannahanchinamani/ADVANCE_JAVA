package jdbc_demo.e_commerce_management;

import java.sql.Timestamp;

public class OrderDetail {
    private int orderId;
    private String customerName;
    private Timestamp orderDate;
    private String productName;
    private int quantity;
    private double price;
    private double total;

    public OrderDetail(int orderId, String customerName, Timestamp orderDate, String productName, int quantity, double price, double total) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return total;
    }
}