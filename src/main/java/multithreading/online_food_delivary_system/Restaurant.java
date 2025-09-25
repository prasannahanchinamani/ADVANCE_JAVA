package multithreading.online_food_delivary_system;

public class Restaurant extends Thread {
    @Override
    public void run() {
        System.out.println("WELCOME");
        System.out.println("Restaurant got the order");
        System.out.println("Restaurant Preparing for food.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Food is Ready..");
    }


}
