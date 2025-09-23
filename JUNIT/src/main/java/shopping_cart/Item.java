package shopping_cart;

public class Item {
    private int id;
    private String name;
    private double price;

    //constructor
    public Item(int id, String name, double price) {
        if (price < 1) {
            throw new IllegalArgumentException("Price Can not be Zero");
        }
        if (id < 1) {
            throw new IllegalArgumentException("Id can't be zero or less than that here");
        }
        if (name == null || name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Item Name is Mandatory.");
        }

        this.id = id;
        this.name = name;
        this.price = price;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    //Get Item Details
    public String getDetailsOfItem() {
        return "ID: " + id + ", Name: " + name + ", Price: ₹" + price;
    }

    //to string Method
    @Override
    public String toString() {
        return getDetailsOfItem();
    }
}
