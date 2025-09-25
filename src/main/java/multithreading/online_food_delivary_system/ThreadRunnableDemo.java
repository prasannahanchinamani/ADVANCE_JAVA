package multithreading.online_food_delivary_system;

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
