package inventory_billing_system.entities;

public class Clothing extends Product {
    public Clothing(int id, String name, double price, int stockQuantity) {
        super(id, name, price, stockQuantity, "Clothing");
    }
}
