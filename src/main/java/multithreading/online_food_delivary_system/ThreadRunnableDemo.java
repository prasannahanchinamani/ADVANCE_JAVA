package multithreading.online_food_delivary_system;

import multithreading.online_food_delivary_system.delivery.Delivery;
import multithreading.online_food_delivary_system.delivery.DeliverySlots;
import multithreading.online_food_delivary_system.restaurant.Restaurant;

public class ThreadRunnableDemo {
    public static void main(String[] args) throws InterruptedException {
        // Using Thread subclass
        Thread restaurant = new Restaurant();

        // Using Runnable implementation
        DeliverySlots slots = new DeliverySlots();
        Thread delivery = new Thread(new Delivery("abc", slots));

        restaurant.start();
        delivery.start();

        restaurant.join();
        delivery.join();

        System.out.println("All tasks completed!");
    }
}
