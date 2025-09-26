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
            for (int i = 1; i <= 2; i++) {
                Thread.sleep(1000);  // simulate cooking delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class OrderProgress {

    public void maintainOrder() throws InterruptedException {
      Order order1=Food_Menu.getOrder(Food_Menu.index);
        OrderThread t1 = new OrderThread(order1);
        t1.start();
        Thread.sleep(1500);
        t1.join();

    }
}
