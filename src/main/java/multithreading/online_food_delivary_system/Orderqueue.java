package multithreading.online_food_delivary_system;

import java.util.LinkedList;
import java.util.Queue;

public class Orderqueue {
    private final Queue<Order> queue = new LinkedList<>();
    private final int max_size = 5;

    public synchronized void addOrder(Order order) throws InterruptedException {
        while (queue.size() >= max_size) {
            wait();
        }
        queue.add(order);
        System.out.println("Order added to queue: " + order.getName());
        notifyAll();
    }

    public synchronized Order takeOrder() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // wait if queue is empty
        }
        Order order = queue.poll();
        System.out.println("Order taken from queue: " + order.getName());
        notifyAll(); // notify producers
        return order;
    }
}
