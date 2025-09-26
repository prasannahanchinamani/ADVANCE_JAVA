package multithreading.online_food_delivary_system.delivery;

public class DeliverySlots {
    private final int maxSlots = 5;
    private int currentSlots = 0;
    public static int count = 0;

    public synchronized void acquireSlot(String agentName) throws InterruptedException {
        while (currentSlots >= maxSlots) {
            wait();
        }
        currentSlots++;
        count++;
        System.out.println(agentName + " acquired a slot. (" + currentSlots + ")");
    }

    public synchronized void releaseSlot(String agentName) {
        currentSlots--;
        System.out.println(agentName + " released a slot. (" + currentSlots + ")");
        notifyAll();
    }

    public  static void totalDelevary() {
        System.out.println(count + " number of delivery");
    }
}
