package inventory_billing_system.entities;

public class Electronics extends Product {
    public Electronics(int id, String name, double price, int stockQuantity) {
        super(id, name, price, stockQuantity, "Electronics");
    }
}
