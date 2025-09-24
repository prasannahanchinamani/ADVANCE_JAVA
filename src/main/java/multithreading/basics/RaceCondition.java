package multithreading.basics;

//in case of critical section mean one resource shared by  two threads
public class RaceCondition {
    static int count = 0;

    public  void increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        RaceCondition r = new RaceCondition();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                r.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                r.increment();
            }
        });
        System.out.println("Count" + RaceCondition.count);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count" + RaceCondition.count);

    }
}
