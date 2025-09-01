package shopping_cart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart(); // initialize before each test
    }

    @DisplayName("Test adding items to the cart.")
    @Test
    void testAddingItems() {
        Item item1 = new Item(1, "Home Decorator", 1500);
        Item item2 = new Item(2, "WildCraft Bag", 3000);
        cart.addItems(item1);
        cart.addItems(item2);
        assertEquals(2, cart.numberOfItems());
        assertEquals(4500, cart.getTotalPrice());
    }

    @DisplayName("Test viewing items in the cart.")
    @Test
    void testViewingItems() {
        Item item1 = new Item(1, "Iron Box", 1500);
        Item item2 = new Item(2, "Charger", 3000);

        cart.addItems(item1);
        cart.addItems(item2);

        List<Item> itemsInCart = cart.viewItems();

        assertEquals(2, itemsInCart.size());
        assertEquals("Iron Box", itemsInCart.get(0).getName());
        assertEquals("Charger", itemsInCart.get(1).getName());
    }

    @DisplayName("Test removing items from the cart. ")
    @Test
    void testRemovedOrNotFromList() {
        cart = new ShoppingCart();
        Item item1 = new Item(1, "Laptop", 50000);
        Item item2 = new Item(2, "Mouse", 1500);
        Item item3 = new Item(3, "Keyboard", 2500);

        cart.addItems(item1);
        cart.addItems(item2);
        cart.addItems(item3);
        assertEquals(3, cart.numberOfItems());
        cart.removeList(2);
        assertEquals(2, cart.numberOfItems());
        //removed already to check present or not
        assertFalse(cart.viewItems().contains(item2));
        assertTrue(cart.viewItems().contains(item1));
        // if not founf the id
        assertThrows(IllegalArgumentException.class, () -> cart.removeList(99));

    }

    @DisplayName("Test calculating the total price of items in the cart.")
    @Test
    void testTotalPrice() {
        Item item1 = new Item(101, "Remote car", 1200);
        Item item2 = new Item(102, "Cricket Bat", 800);
        cart.addItems(item1);
        assertEquals(1200, cart.getTotalPrice());
        cart.addItems((item2));
        assertEquals(2000, cart.getTotalPrice());
    }
}
