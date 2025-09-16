package inventory_billing_system.discount;

import inventory_billing_system.exceptions.InvalidDiscountException;

public class PercentageDiscount implements DiscountStrategy {
    private final double percent;

    public PercentageDiscount(double percent) {
        if (percent < 0 || percent > 100) throw new InvalidDiscountException("Invalid percentage");
        this.percent = percent;
    }

    @Override
    public double apply(double total) {
        return total * (percent / 100.0);
    }
}
