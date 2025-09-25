package multithreading.online_food_delivary_system;

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
        Food_Menu.showMenu();
        System.out.println("Which one you already orderd");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n1 = sc.nextInt();
        Order order1 = Food_Menu.getOrder(n);
        Order order2 = Food_Menu.getOrder(n1);

        // Create cooking threads
        OrderThread t1 = new OrderThread(order1);
        OrderThread t2 = new OrderThread(order2);

        // Delivery setup
        DeliverySlots slots = new DeliverySlots();
        Delivery delivery = new Delivery("Agent-XYZ", slots);
        Thread deliveryThread = new Thread(delivery);

        // NEW state
        System.out.println(t1.getName() + " initial state: " + t1.getState());
        System.out.println(t2.getName() + " initial state: " + t2.getState());

        // Start cooking threads → RUNNABLE
        t1.start();
        t2.start();

        // Interrupt t2
        Thread.sleep(1500);
        t2.interrupt();

        // Wait for threads to finish
        t1.join();
        t2.join();

        // Start delivery
        deliveryThread.start();
        deliveryThread.join();

        // TERMINATED state
        System.out.println(t1.getName() + " final state: " + t1.getState());
        System.out.println(t2.getName() + " final state: " + t2.getState());
    }
}
