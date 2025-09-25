package multithreading.threading;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<String> buffer;

    public Consumer(BlockingQueue<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            String item = buffer.take();
            System.out.println("Consumer: Consuming " + item);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Cosumer is Interrupted");
        }
    }
}
