package shopping_cart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    Item items;

    @DisplayName("Test creating an item with valid details.")
    @Test
    void testCreateItemWithValidDetails() {
        items = new Item(1, "Laptop", 55000);
        assertEquals(1, items.getId());
        assertEquals("Laptop", items.getName());
        assertEquals(55000, items.getPrice());
    }

    @DisplayName(" Test getting item details. ")
    @Test
    void validatingGetDetails() {
        items = new Item(2, "Mobile", 15000);
        String result = "ID: " + items.getId() + ", Name: " + items.getName() + ", Price: ₹" + items.getPrice();
        assertEquals(result, items.getDetailsOfItem());
    }

    @DisplayName("Test Price should not be zero or negative")
    @Test
    void testPrice() {
        assertThrows(IllegalArgumentException.class,
                () -> new Item(3, "Mouse", -1));
    }
//    @Disabled
    @DisplayName("Test Id should not be zero or negative")
    @Test
    void testId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Item(1, "Mouse", 7));
    }
//    @Disabled
    @DisplayName("Testing Item Name")
    @Test
    void testItemName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Item(1, " ", 7));
    }
}