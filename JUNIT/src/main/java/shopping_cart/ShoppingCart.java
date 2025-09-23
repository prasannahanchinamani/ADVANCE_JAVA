package shopping_cart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {
    private List<Item> items;

    // Constructor
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    //● Test adding items to the cart.
    public void addItems(Item item) {
        items.add(item);
    }

    //Test viewing items in the cart.
    public List<Item> viewItems() {
        return new ArrayList<>(items);
    }

    public int numberOfItems() {
        return items.size();
    }

    //Test removing items from the cart.
    public void removeList(int id) {
        boolean found = false;
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getId() == id) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Item with ID " + id + " not found in the cart.");
        }
    }


    //Test calculating the total price of items in the cart.
    public double getTotalPrice() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
}