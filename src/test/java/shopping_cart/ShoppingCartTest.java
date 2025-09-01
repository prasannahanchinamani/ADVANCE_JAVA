package shopping_cart;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    ShoppingCart cart;
    Item item1, item2, item3;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart(); 
        item1 = new Item(1, "Laptop", 50000);
        item2 = new Item(2, "Mouse", 1500);
        item3 = new Item(3, "Keyboard", 2500);

    }

    @AfterEach
    void tearDown() {
        cart = null; 
    
    }

    @DisplayName("Test adding items to the cart.")
    @Test
    void testAddingItems() {
        cart.addItems(item1);
        cart.addItems(item2);

        assertEquals(2, cart.numberOfItems());
        assertEquals(51500, cart.getTotalPrice());
        //by id
        assertEquals(1, item1.getId());
        //checking exception
        assertThrows(IllegalArgumentException.class, () -> new Item(3, "Mouse", 0));

        assertThrows(IllegalArgumentException.class, () -> new Item(0, "", 0));
    }

    @DisplayName(" Test viewing items in the cart.")
    @Test
    void testViewingItems() {
        cart.addItems(item1);
        cart.addItems(item2);
        cart.addItems(item3);
        List<Item> itemsInCart = cart.viewItems();
        assertEquals(3, itemsInCart.size());
        //by id
        assertEquals(2, item2.getId());
        assertEquals("Laptop", itemsInCart.get(0).getName());
        assertEquals("Mouse", itemsInCart.get(1).getName());
        assertThrows(IllegalArgumentException.class, () -> new Item(3, "", 0));
        assertThrows(IllegalArgumentException.class, () -> new Item(0, "", 2000));
    }

    @DisplayName(" Test removing items from the cart.")
    @Test
    void testRemovingItems() {
        cart.addItems(item1);
        cart.addItems(item2);
        cart.addItems(item3);

        assertEquals(3, cart.numberOfItems());
        assertEquals(2, item2.getId());
        cart.removeList(2); // remove Mouse
        assertEquals(2, cart.numberOfItems());

        assertFalse(cart.viewItems().contains(item2));
        assertTrue(cart.viewItems().contains(item1));

    }

    @DisplayName("  Removing non-existing item should throw exception.")
    @Test
    void testRemoveNonExistingItem() {
        cart.addItems(item1);
        assertThrows(IllegalArgumentException.class, () -> cart.removeList(99));
    }

    @DisplayName("  Total price of empty cart should be zero.")
    @Test
    void testEmptyCartTotalPrice() {
        assertEquals(0, cart.getTotalPrice());
        assertEquals(0, cart.numberOfItems());
    }

    @DisplayName("  Viewing items in empty cart should return empty list.")
    @Test
    void testViewEmptyCart() {
        List<Item> itemsInCart = cart.viewItems();
        assertTrue(itemsInCart.isEmpty());
    }

    @DisplayName(" Test calculating total price after multiple adds and removes.")
    @Test
    void testTotalPriceWithRemove() {
        cart.addItems(item1); // 50000
        cart.addItems(item2); // 1500
        cart.addItems(item3); // 2500
        assertEquals(54000, cart.getTotalPrice());

        cart.removeList(2); // remove Mouse

        assertEquals(52500, cart.getTotalPrice());
    }
}
