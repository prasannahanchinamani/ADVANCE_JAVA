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
        try {
            slot.acquireSlot(agentName);
            Thread.sleep(2000);
            slot.releaseSlot(agentName);
        } catch (InterruptedException e) {
            try {
                Thread.currentThread().interrupt();
                throw new InterruptedException();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
