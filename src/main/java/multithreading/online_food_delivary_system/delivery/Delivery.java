package multithreading.online_food_delivary_system.delivery;

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
