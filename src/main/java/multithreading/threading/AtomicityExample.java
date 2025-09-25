package multithreading.threading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicityExample {
    AtomicInteger counter = new AtomicInteger(0);//thread safe make isolation thread

    public void increment() {
        counter.incrementAndGet();
    }

    public int getCount() {
         return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicityExample ac = new AtomicityExample();
        Thread t1 = new Thread(() ->
        {
            for (int i = 1; i <= 100; i++) {
                ac.increment();
            }
        });

        Thread t2 = new Thread(() ->
        {
            for (int i = 1; i <= 100; i++) {
                ac.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count:"+ac.getCount());
    }

}
