package inventory_billing_system.discount;

import java.util.function.Predicate;

public class SeasonalDiscount implements DiscountStrategy {
    private final double percent;
    private final Predicate<Void> applicability;

    public SeasonalDiscount(double percent, Predicate<Void> applicability) {
        this.percent = percent;
        this.applicability = applicability;
    }

    @Override
    public double apply(double total) {
        return applicability.test(null) ? total * (percent / 100.0) : 0.0;
    }
}
