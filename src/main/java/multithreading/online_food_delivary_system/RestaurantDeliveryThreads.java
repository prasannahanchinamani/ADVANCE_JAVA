package multithreading.online_food_delivary_system;

public class RestaurantDeliveryThreads {
    public static void main(String[] args) {
        Thread restaurant = new Thread(() -> {
            System.out.println("Restaurant is preparing food!!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Food is Ready take it.");
        });
        Thread delicaryagent = new Thread(() -> {
            System.out.println("Delivary agent is Waiting outside");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Delivary the Food");
        });
        restaurant.start();
        delicaryagent.start();
    }
}
