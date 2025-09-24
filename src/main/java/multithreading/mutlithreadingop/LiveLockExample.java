package multithreading.mutlithreadingop;

class Resources {
    public void useResouce(String threadName) {
        System.out.println(Thread.currentThread().getName() + threadName);
    }
}

public class LiveLockExample {
    static Resources r1 = new Resources();
    static Resources r2 = new Resources();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread running");
            int i = 0;
            while (i < 3) {
                System.out.println(Thread.currentThread().getName() + "Is Runnig");
                System.out.println(Thread.currentThread().getName() + "Is Realsing Resource");
                i++;
            }
            synchronized (r2) {
                synchronized (r1) {
                    r1.useResouce("Thread 1");
                    r2.useResouce("Thread 2");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println("Thread running");
            int i = 0;
            while (i < 3) {
                System.out.println(Thread.currentThread().getName() + "Is Runnig");
                System.out.println(Thread.currentThread().getName() + "Is Realsing Resource");
                i++;
            }
            synchronized (r1) {
                synchronized (r2) {
                    r1.useResouce("Thread 1");
                    r2.useResouce("Thread 2");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
