package multithreading.online_food_delivary_system.discount;

import multithreading.online_food_delivary_system.orders.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureCallable {
    private final ExecutorService executor = Executors.newFixedThreadPool(2);


    public List<Future<Double>> submitOrders(List<Order> orders) {
        List<Future<Double>> futures = new ArrayList<>();
        for (Order order : orders) {
            PriceCalculator priceCalculator = new PriceCalculator(order);
            futures.add(executor.submit(priceCalculator));
        }
        return futures;
    }

    public void scheduleStatusUpdates() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable statusTask = () -> System.out.println(" Orders are being prepared...");

        // Runs every 5 seconds
        scheduler.scheduleAtFixedRate(statusTask, 0, 5, TimeUnit.SECONDS);

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        scheduler.shutdown();
    }

    public void shutdown() {
        executor.shutdown();
    }


}