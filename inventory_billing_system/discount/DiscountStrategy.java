package inventory_billing_system.discount;

@FunctionalInterface
public interface DiscountStrategy {
    double apply(double total);
}
