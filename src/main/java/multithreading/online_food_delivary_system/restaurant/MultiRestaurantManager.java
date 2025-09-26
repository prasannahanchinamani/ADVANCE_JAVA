package multithreading.online_food_delivary_system.restaurant;

import multithreading.online_food_delivary_system.orders.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class MultiRestaurantManager {
    public static String prepareOrder(List<Order> orders) throws InterruptedException, ExecutionException {
        RestaurantNames.dislay();
        System.out.println("From Which Restrant to You Want order Enter The Number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String resName = RestaurantNames.getRestaurant(n - 1);
        ExecutorService executor = Executors.newFixedThreadPool(RestaurantNames.names.length);
        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
        Runnable statusTask = () -> System.out.println("System Update: Restaurants are cooking...");
        List<Future<String>> futures = new ArrayList<>();
        for (Order order : orders) {
            futures.add(executor.submit(() -> {
                System.out.println(resName + " received order: " + order.getName());
                Thread.sleep(2000);
                return resName + " completed order: " + order.getName();
            }));
        }
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }
        executor.shutdown();
        schedule.shutdown();
        return resName;
    }
}
