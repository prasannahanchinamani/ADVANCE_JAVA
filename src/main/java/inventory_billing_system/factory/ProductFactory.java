package inventory_billing_system.factory;

import inventory_billing_system.entities.*;

public class ProductFactory {
    public static Product createProduct(String type, int id, String name, double price, int qty) {
        switch (type.toLowerCase()) {
            case "grocery":
                return new Grocery(id, name, price, qty);
            case "electronics":
                return new Electronics(id, name, price, qty);
            case "clothing":
                return new Clothing(id, name, price, qty);
            default:
                return new Product(id, name, price, qty, type);
        }
    }
}
