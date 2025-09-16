package inventory_billing_system;

import inventory_billing_system.discount.DiscountStrategy;

public class DiscountService {
    private DiscountStrategy strategy;

    public DiscountService(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double compute(double total) {
        return strategy.apply(total);
    }

    public void setStrategy(DiscountStrategy s) {
        this.strategy = s;
    }
}
