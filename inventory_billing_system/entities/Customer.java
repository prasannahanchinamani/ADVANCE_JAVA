package inventory_billing_system.entities;

public class Customer {
    private final int id;
    private final String name;
    private int loyaltyPoints;

    public Customer(int id, String name) {
        this(id, name, 0);
    }

    public Customer(int id, String name, int loyaltyPoints) {
        this.id = id;
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }
}
