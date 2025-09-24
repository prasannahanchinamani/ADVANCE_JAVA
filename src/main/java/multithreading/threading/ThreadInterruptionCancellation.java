package multithreading.threading;

public class ThreadInterruptionCancellation {
    public static void main(String[] args) {
        Thread t1 = new Thread(() ->
        {
            for (int i = 1; i <= 7; i++) {
                System.out.println("Thread is running " + i);
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("thread is cancelled");
                }
                if (i > 3) {
                    try {
                        System.out.println("Thread started, going to sleep...");
                        Thread.sleep(5000); // sleeping
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted!");
                        break;
                    }
                }
            }
        });
        t1.start();
        t1.interrupt();
    }
}
