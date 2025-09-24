package multithreading.mutlithreadingop;

class Resource {
    public void use() {
        System.out.println(Thread.currentThread().getName() + " Running");
    }
}

public class DeadLockExample {
    static Resource r1 = new Resource();
    static Resource r2 = new Resource();

    public static void main(String[] args) {
        Thread t1 = new Thread(() ->
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            synchronized (r1) {
                System.out.println(Thread.currentThread().getName() + " Locked r1");
                r1.use();
            synchronized (r2) {
                System.out.println(Thread.currentThread().getName() + " Locked r2");
                r2.use();
            }
        }
        }, "Thread 1");
        Thread t2 = new Thread(() ->
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            synchronized (r2) {
                System.out.println(Thread.currentThread().getName() + "Locked r2");
                r1.use();
                synchronized (r1) {
                    System.out.println(Thread.currentThread().getName() + " Locked r1");
                    r2.use();

                }
            }
        }, "Thread 2");

        t1.start();
        t2.start();
    }

}
