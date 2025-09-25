package multithreading.online_food_delivary_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Future;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Online Food Delivery System");

        Food_Menu.showMenu();
        System.out.println("How many items do you want to order");
        int count = sc.nextInt();

        List<Order> selectedOrders = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.print("Enter item number " + (i + 1) + ": ");
            int choice = sc.nextInt();
            Order order = Food_Menu.getOrder(choice - 1);
            if (order != null) {
                selectedOrders.add(order);
            } else {
                System.out.println("Invalid selection Skipping");
            }
        }

        if (selectedOrders.isEmpty()) {
            System.out.println("No valid orders selected Exiting");
            return;
        }

        System.out.println("Adding Orders to Queue");
        Orderqueue orderQueue = new Orderqueue();
        for (Order order : selectedOrders) {
            orderQueue.addOrder(order);
        }

        System.out.println("Calculating Discounts");
        for (Order order : selectedOrders) {
            Calculating_discount.calculatingdiscount(order);
        }

        System.out.println("Cooking Simulation");
        OrderProgress orderProgress = new OrderProgress();
        orderProgress.maintainOrder();

        System.out.println("Price Calculation Using Future and Callable");
        FutureCallable futureCallable = new FutureCallable();
        List<Future<Double>> results = futureCallable.submitOrders(selectedOrders);
        futureCallable.scheduleStatusUpdates();

        for (Future<Double> result : results) {
            System.out.println("Final billed price: " + result.get());
        }
        futureCallable.shutdown();

        System.out.println("Delivery Process");
        DeliverySlots slots = new DeliverySlots();
        List<Thread> deliveryThreads = new ArrayList<>();
        int agentId = 1;
        for (Order order : selectedOrders) {
            Thread deliveryThread = new Thread(new Delivery("Agent-" + agentId++, slots));
            deliveryThreads.add(deliveryThread);
            deliveryThread.start();
        }
        for (Thread t : deliveryThreads) {
            t.join();
        }

        System.out.println("Restaurant Acknowledgement");
        Restaurant restaurant = new Restaurant();
        restaurant.start();
        restaurant.join();

        System.out.println("Order Completed Thank you for using Online Food Delivery System");
    }
}
