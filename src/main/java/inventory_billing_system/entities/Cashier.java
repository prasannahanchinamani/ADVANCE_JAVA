package inventory_billing_system.entities;

import inventory_billing_system.discount.DiscountStrategy;
import inventory_billing_system.BillingService;

import java.util.Map;

public class Cashier {
    private final BillingService billingService;

    public Cashier(BillingService billingService) {
        this.billingService = billingService;
    }

    public Bill checkout(Customer customer, Map<Integer, Integer> productIdToQty, DiscountStrategy discountStrategy) {
        return billingService.generateBill(customer, productIdToQty, discountStrategy);
    }
}
