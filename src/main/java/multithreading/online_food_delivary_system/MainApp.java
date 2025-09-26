package multithreading.online_food_delivary_system;

import multithreading.online_food_delivary_system.delivery.Delivery;
import multithreading.online_food_delivary_system.delivery.DeliverySlots;
import multithreading.online_food_delivary_system.discount.Calculating_discount;
import multithreading.online_food_delivary_system.discount.FutureCallable;
import multithreading.online_food_delivary_system.orders.Order;
import multithreading.online_food_delivary_system.orders.OrderProgress;
import multithreading.online_food_delivary_system.orders.Orderqueue;
import multithreading.online_food_delivary_system.orders.UrgentOrder;
import multithreading.online_food_delivary_system.restaurant.Food_Menu;
import multithreading.online_food_delivary_system.restaurant.MultiRestaurantManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Future;

public class MainApp {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Online Food Delivery System");

        // Show menu and select orders
        Food_Menu.showMenu();
        System.out.print("How many items do you want to order: ");
        int count = sc.nextInt();

        List<Order> selectedOrders = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.print("Enter item number " + (i + 1) + ": ");
            int choice = sc.nextInt();
            Order order = Food_Menu.getOrder(choice - 1);

            if (order != null) {
                boolean urgent = UrgentOrder.checkUrgency(order, sc);
                order.setUrgent(urgent);
                selectedOrders.add(order);
            } else {
                System.out.println("Invalid selection, skipping");
            }
        }



        if (selectedOrders.isEmpty()) {
            System.out.println("No valid orders selected. Exiting.");
            return;
        }

        // Add orders to queue
        Orderqueue orderQueue = new Orderqueue();
        for (Order order : selectedOrders) {
            orderQueue.addOrder(order);
        }

        // Apply discounts
        System.out.println("Calculating Discounts...");
        for (Order order : selectedOrders) {
            Calculating_discount.calculatingdiscount(order);
        }

        // Cooking simulation using threads
        System.out.println("Cooking Simulation...");
        OrderProgress orderProgress = new OrderProgress();
        orderProgress.maintainOrder();

        // Price calculation using Future and Callable
        System.out.println("Calculating Final Prices...");
        FutureCallable futureCallable = new FutureCallable();
        List<Future<Double>> results = futureCallable.submitOrders(selectedOrders);
        futureCallable.scheduleStatusUpdates();

        for (Future<Double> result : results) {
            System.out.println("Final billed price: " + result.get());
        }
        futureCallable.shutdown();

        // Multi-restaurant preparation using ExecutorService
        System.out.println("Multi-Restaurant Preparation...");
        MultiRestaurantManager.prepareOrder(selectedOrders);

        // Delivery using threads and DeliverySlots
        System.out.println("Delivery Process...");
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

        System.out.println("Order Completed. Thank you for using Online Food Delivery System");
    }
}
