package multithreading.threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> sharedBuffer = new ArrayBlockingQueue<>(3);

        Thread producerThread = new Thread(new Producer(sharedBuffer));
        Thread consumerThread = new Thread(new Consumer(sharedBuffer));
        producerThread.start();
        consumerThread.start();
    }
}
