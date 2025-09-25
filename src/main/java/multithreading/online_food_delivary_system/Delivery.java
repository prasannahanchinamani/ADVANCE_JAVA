package multithreading.online_food_delivary_system;

class DeliverySlots {
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

public class Delivery implements Runnable {
    private final String agentName;
    private final DeliverySlots slot;


    public Delivery(String agentName, DeliverySlots slot) {
        this.agentName = agentName;
        this.slot = slot;
    }

    @Override
    public void run() {
        System.out.println("Delivery agent is waiting outside");
        try {
            slot.acquireSlot(agentName);
            System.out.println(agentName + " is delivering the food...");
            Thread.sleep(2000);
            System.out.println(agentName + " completed delivery!");
            System.out.println("Feedback....");
            slot.releaseSlot(agentName);
        } catch (InterruptedException e) {
            System.out.println(agentName + " delivery interrupted!");
            Thread.currentThread().interrupt();
        }
    }
}
