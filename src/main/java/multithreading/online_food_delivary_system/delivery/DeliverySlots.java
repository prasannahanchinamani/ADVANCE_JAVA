package multithreading.online_food_delivary_system.delivery;

import java.util.concurrent.atomic.AtomicInteger;

public class DeliverySlots {
    private final int maxSlots = 5;
    private int currentSlots = 0;
    private static final AtomicInteger totalDeliveries = new AtomicInteger(0);
    private static volatile boolean systemRunning = true;

    public synchronized void acquireSlot(String agentName) throws InterruptedException {
        while (currentSlots >= maxSlots && systemRunning) {
            wait();
        }
        if (!systemRunning) {
            return;
        }
        currentSlots++;
        System.out.println(agentName + " acquired a slot. (" + currentSlots + ")");
    }

    public synchronized void releaseSlot(String agentName) {
        if (currentSlots > 0) {
            currentSlots--;
            int delivered = totalDeliveries.incrementAndGet();
            System.out.println(agentName + " released a slot. (" + currentSlots + ")");
            System.out.println("Total successful deliveries: " + delivered);
            notifyAll();
        }
    }

    public static void stopSystem() {
        systemRunning = false;
        System.out.println("System is shutting down..");
    }

    public static boolean isSystemRunning() {
        return systemRunning;
    }

    public static void printTotalDeliveries() {
        System.out.println("Total successful deliveries: " + totalDeliveries.get());
    }
}
