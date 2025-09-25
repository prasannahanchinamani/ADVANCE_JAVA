package multithreading.basics;

public class DaemonThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("Noraml Thread");
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread:" + Thread.currentThread().getName()+i);
            }
        });
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        daemonThread.setDaemon(true);
        t1.start();
        daemonThread.start();
        t1.join();
        System.out.println("Main thread finish");
    }

}
