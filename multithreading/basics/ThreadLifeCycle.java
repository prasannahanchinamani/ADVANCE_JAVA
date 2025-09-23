package multithreading.basics;

public class ThreadLifeCycle extends Thread {
    private int a, b;

    public ThreadLifeCycle(int a, int b) {
        super(); // thread is in NEW state
        this.a = a;
        this.b = b;
        System.out.println("Thread created: " + this.getName() + " (NEW state)");
    }

    synchronized public void run() {
        System.out.println("Thread is Running: " + this.getName() + " (Runnig State)");
        int sum = a + b;
        for (int i = 1; i <= 3; i++) {
            System.out.println("Checking .......");
            if (i == 2) {
                System.out.println("Thrad" + this.getName() + "(Yielding)");
                Thread.yield();
            }
            if (i == 3) {
                System.out.println("thred  " + this.getName() + "Interuuped");
                Thread.interrupted();
            }

        }
        System.out.println("Sum by " + this.getName() + " = " + sum);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLifeCycle t1 = new ThreadLifeCycle(10, 20);
        ThreadLifeCycle t2 = new ThreadLifeCycle(20, 40);
        t1.start();
        t2.start();
//         join

        try {
            Thread tx = new Thread(() -> {
                for (int i = 1; i <= 3; i++)
                    System.out.println("Join Checking........");
            });
            tx.start();
            tx.join();
        } catch (InterruptedException e) {
            System.out.println("Interuptted thread");
        }
    }
}
