package inventory_billing_system.discount;

import inventory_billing_system.exceptions.InvalidDiscountException;

public class FixedDiscount implements DiscountStrategy {
    private final double amount;

    public FixedDiscount(double amount) {
        if (amount < 0) throw new InvalidDiscountException("Invalid fixed discount");
        this.amount = amount;
    }

    @Override
    public double apply(double total) {
        return Math.min(amount, total);
    }
}
