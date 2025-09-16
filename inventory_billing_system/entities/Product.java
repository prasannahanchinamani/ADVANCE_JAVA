package inventory_billing_system.entities;

import java.util.Objects;

public class Product {
    private final int id;
    private String name;
    private double price;
    private int stockQuantity;
    private String category;

    public Product(int id, String name, double price, int stockQuantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void reduceStock(int qty) {
        this.stockQuantity -= qty;
    }

    public void increaseStock(int qty) {
        this.stockQuantity += qty;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Product) && ((Product) o).id == id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
