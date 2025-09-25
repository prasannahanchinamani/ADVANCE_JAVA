package multithreading.threading;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<String> buffer;

    public Producer(BlockingQueue<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        String[] items = {"Burger", "Pizza", "Pasta"};
        try {
            for (String item : items) {
                System.out.println("Producer: Producing " + item);
                buffer.put(item); //thread safety purpose
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
//            throw new RuntimeException(e);
            System.out.println("Producer is interrupted");
        }
    }
}
