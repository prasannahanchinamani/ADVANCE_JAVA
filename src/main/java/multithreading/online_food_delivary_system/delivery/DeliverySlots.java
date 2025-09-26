package multithreading.online_food_delivary_system.delivery;

import java.util.concurrent.atomic.AtomicInteger;

public class DeliverySlots {
    private final int maxSlots = 5;
    public int currentSlots = 0;
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
    }

    public synchronized void releaseSlot(String agentName) {
        if (currentSlots > 0) {
            currentSlots--;
            int delivered = totalDeliveries.incrementAndGet();
            notifyAll();
        }
    }

    public static void stopSystem() {
        systemRunning = false;
    }

    public static boolean isSystemRunning() {
        return systemRunning;
    }

    public static int printTotalDeliveries() {
        return totalDeliveries.get();
    }
}
