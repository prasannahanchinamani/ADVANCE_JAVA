package multithreading.online_food_delivary_system;

import multithreading.online_food_delivary_system.delivery.Delivery;
import multithreading.online_food_delivary_system.delivery.DeliverySlots;
import multithreading.online_food_delivary_system.discount.Calculating_discount;
import multithreading.online_food_delivary_system.discount.PriceCalculator;
import multithreading.online_food_delivary_system.orders.Order;
import multithreading.online_food_delivary_system.orders.Orderqueue;
import multithreading.online_food_delivary_system.restaurant.Food_Menu;
import multithreading.online_food_delivary_system.restaurant.Restaurant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainAppTest {
    @Test
    void testGetOrderValid() {
        Order order = Food_Menu.getOrder(0);
        assertNotNull(order);
        assertEquals("Burger", order.getName());
    }

    //Negative 1
    @DisplayName("Order Which is Not in Menu")
    @Test
    void testGetOrderInvalidValid() {
        Order order = Food_Menu.getOrder(100);
        assertNull(order);
    }

    @DisplayName("Order Food")
    @Test
    void testaddOrder() throws InterruptedException {
        Order order = Food_Menu.getOrder(0);
        Orderqueue oq = new Orderqueue();
        oq.addOrder(order);
        assertEquals(order, oq.takeOrder());
        testGetOrderInvalidValid();
    }

    //    negatative 2
    @DisplayName("Testing Order with null")
    @Test
    void testAddNullOrder() throws InterruptedException {
        Orderqueue oq = new Orderqueue();
        assertThrows(NullPointerException.class, () -> oq.addOrder(null));
    }


    @DisplayName("Testing the Dicount")
    @Test
    void testDiscount() throws Exception {
        Order order = new Order("SouthMeal", 100, 10);
        PriceCalculator pc = new PriceCalculator(order);
        double finalPrice = pc.call();
        assertEquals(90, finalPrice);
        assertTrue(finalPrice <= 100);
        Order order1 = new Order("Pizza", 100, 0);
        double price = Calculating_discount.calculatingdiscount(order1);
        assertEquals(100, price);
    }

    @DisplayName("Test Delivery")
    @Test
    void testDeliveryAgent() throws InterruptedException {
        DeliverySlots slots = new DeliverySlots();
        Thread deliveryThread = new Thread(new Delivery("Agent-1", slots));
        deliveryThread.start();
        assertTrue(deliveryThread.isAlive());
        deliveryThread.join();
        assertFalse(deliveryThread.isAlive());
    }

    @DisplayName("Restarurant workig")
    @Test
    void testRestaurant() throws InterruptedException {
        Restaurant restaurant = new Restaurant();
        restaurant.start();
        assertTrue(restaurant.isAlive());
        restaurant.join();
        assertFalse(restaurant.isInterrupted());
        assertFalse(restaurant.isAlive());
    }

}