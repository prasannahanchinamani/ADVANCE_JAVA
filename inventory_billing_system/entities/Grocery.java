package inventory_billing_system.entities;

public class Grocery extends Product {
    public Grocery(int id, String name, double price, int stockQuantity) {
        super(id, name, price, stockQuantity, "Grocery");
    }
}
