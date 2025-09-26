package multithreading.online_food_delivary_system.orders;

import multithreading.online_food_delivary_system.delivery.Delivery;
import multithreading.online_food_delivary_system.delivery.DeliverySlots;
import multithreading.online_food_delivary_system.restaurant.Food_Menu;

import java.util.Scanner;

class OrderThread extends Thread {
    private final Order order;

    public OrderThread(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        try {
            System.out.println(order.getName() + " state inside run: " + getState());
            for (int i = 1; i <= 2; i++) {
                System.out.println(order.getName() + " cooking step " + i + "  state: " + getState());
                Thread.sleep(1000);  // simulate cooking delay
            }
            System.out.println(order.getName() + " preparation done!");
        } catch (InterruptedException e) {
            System.out.println(order.getName() + " order is  cancelled");
            Thread.currentThread().interrupt();
        }
    }
}

public class OrderProgress {

    public void maintainOrder() throws InterruptedException {
        // Select orders from menu
//        Food_Menu.showMenu();
      Order order1=Food_Menu.getOrder(Food_Menu.index);
        // Create cooking threads
        OrderThread t1 = new OrderThread(order1);

        // Delivery setup
//        DeliverySlots slots = new DeliverySlots();
//        Delivery delivery = new Delivery("Agent-XYZ", slots);
//        Thread deliveryThread = new Thread(delivery);

        // NEW state
        System.out.println(t1.getName() + " initial state: " + t1.getState());


        // Start cooking threads → RUNNABLE
        t1.start();


        // Interrupt t2
        Thread.sleep(1500);


        // Wait for threads to finish
        t1.join();


        // Start delivery
//        deliveryThread.start();
//        deliveryThread.join();

        // TERMINATED state
        System.out.println(t1.getName() + " final state: " + t1.getState());

    }
}
