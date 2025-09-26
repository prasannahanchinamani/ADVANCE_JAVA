package multithreading.online_food_delivary_system.orders;

public class Order {
    private String name;
    private double price;
    private double discount;

    public Order(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return name + " (Price: " + price + ", Discount: " + discount + "%)";
    }
}