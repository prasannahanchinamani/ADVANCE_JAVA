package multithreading.online_food_delivary_system.orders;

import java.util.LinkedList;
import java.util.Queue;

public class Orderqueue {
    private static final Queue<Order> queue = new LinkedList<>();
    private static final int max_size = 5;

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
        notifyAll();
        return order;
    }
}
