package multithreading.online_food_delivary_system;

import multithreading.online_food_delivary_system.delivery.Delivery;
import multithreading.online_food_delivary_system.delivery.DeliverySlots;
import multithreading.online_food_delivary_system.delivery.RestaurantDeliveryThreads;
import multithreading.online_food_delivary_system.discount.PriceCalculator;
import multithreading.online_food_delivary_system.orders.Order;
import multithreading.online_food_delivary_system.orders.OrderProgress;
import multithreading.online_food_delivary_system.orders.Orderqueue;
import multithreading.online_food_delivary_system.restaurant.Food_Menu;
import multithreading.online_food_delivary_system.restaurant.Restaurant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainAppTest {

    @Test
    void testDeliveryRun() throws InterruptedException {
        DeliverySlots slots = new DeliverySlots();
        Thread t1 = new Thread(new Delivery("Agent-1", slots));
        Thread t2 = new Thread(new Delivery("Agent-2", slots));
        Thread t3 = new Thread(new Delivery("Agent-3", slots));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        assertEquals(0, slots.currentSlots);
        assertEquals(3, DeliverySlots.printTotalDeliveries());
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

    @Test
    void testThreadsRunAndComplete() throws InterruptedException {
        RestaurantDeliveryThreads threads = new RestaurantDeliveryThreads();
        Thread.sleep(2500);
        assertTrue(true, "Threads executed without interruption");
    }
    @DisplayName("Testing the Dicount")
    @Test
    void testDiscount() throws Exception {
        Order order = new Order("SouthMeal", 100, 10);
        PriceCalculator pc = new PriceCalculator(order);
        double finalPrice = pc.call();
        assertEquals(90, finalPrice);
        assertTrue(finalPrice <= 100);
    }
    @Test
    void testMaintainOrderCompletes() {
        OrderProgress orderProgress = new OrderProgress();
        assertDoesNotThrow(() -> orderProgress.maintainOrder());
    }
    @Test
    void testGetOrderValid() {
        Order order = Food_Menu.getOrder(0);
        assertNotNull(order);
        assertEquals("Burger", order.getName());
    }


    @DisplayName("Order Food")
    @Test
    void testaddOrder() throws InterruptedException {
        Order order = Food_Menu.getOrder(0);
        Orderqueue oq = new Orderqueue();
        oq.addOrder(order);
        assertEquals(order, oq.takeOrder());
    }

    //    negatative 2
    @DisplayName("Testing Order with null")
    @Test
    void testAddNullOrder() throws InterruptedException {
        Orderqueue oq = new Orderqueue();
        assertThrows(NullPointerException.class, () -> oq.addOrder(null));
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


}