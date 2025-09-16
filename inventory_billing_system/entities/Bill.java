package inventory_billing_system.entities;

import java.util.Collections;
import java.util.Map;

public class Bill {
    private final Customer customer;
    private final Map<Product, Integer> purchasedItems;
    private final double totalAmount;
    private final double discountApplied;
    private final double finalAmount;

    public Bill(Customer customer, Map<Product, Integer> purchasedItems,
                double totalAmount, double discountApplied, double finalAmount) {
        this.customer = customer;
        this.purchasedItems = Collections.unmodifiableMap(purchasedItems);
        this.totalAmount = totalAmount;
        this.discountApplied = discountApplied;
        this.finalAmount = finalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<Product, Integer> getPurchasedItems() {
        return purchasedItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getDiscountApplied() {
        return discountApplied;
    }

    public double getFinalAmount() {
        return finalAmount;
    }
}
