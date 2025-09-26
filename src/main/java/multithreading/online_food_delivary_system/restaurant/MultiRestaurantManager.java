package multithreading.online_food_delivary_system.restaurant;

import multithreading.online_food_delivary_system.orders.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class MultiRestaurantManager {

    public static String prepareOrder(List<Order> orders) throws InterruptedException, ExecutionException {
        RestaurantNames.dislay();
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            System.out.println("From which restaurant do you want to order? Enter the number:");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n >= 1 && n <= RestaurantNames.names.length) {
                    break;
                }
            } else {
                sc.next();
            }
//            System.out.println("Invalid input. Please enter a number between 1 and " + RestaurantNames.names.length);
        }

        String resName = RestaurantNames.getRestaurant(n - 1);
        ExecutorService executor = Executors.newFixedThreadPool(RestaurantNames.names.length);
        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
        Runnable statusTask = () -> System.out.println("System Update: Restaurants are cooking...");
        schedule.scheduleAtFixedRate(statusTask, 0, 1, TimeUnit.SECONDS);


        List<Future<String>> futures = new ArrayList<>();
        for (Order order : orders) {
            futures.add(executor.submit(() -> {
                Thread.sleep(2000);
                return resName;
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
