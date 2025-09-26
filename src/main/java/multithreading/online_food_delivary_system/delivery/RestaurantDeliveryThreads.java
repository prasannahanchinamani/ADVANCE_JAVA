package multithreading.online_food_delivary_system.delivery;

public class RestaurantDeliveryThreads {

    public RestaurantDeliveryThreads() {
        Thread restaurant = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Thread simulating delivery agent work
        Thread deliveryAgent = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        restaurant.start();
        deliveryAgent.start();
    }
}
