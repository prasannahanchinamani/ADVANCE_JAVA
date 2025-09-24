package multithreading.basics;

public class ThreadPriority {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                int su = 10 + 20;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread 1 " + su);
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                int su = 10 - 0;
                System.out.println("Thread 2 " + su);
            }
        };

        Thread t1 = new Thread(r1, "T1");
        Thread t2 = new Thread(r2, "T2");

        t1.setPriority(Thread.MIN_PRIORITY); // 1
        t2.setPriority(Thread.MAX_PRIORITY); // 10

        System.out.println(t1.getName() + " priority: " + t1.getPriority());
        System.out.println(t2.getName() + " priority: " + t2.getPriority());

        t1.start();
        t2.start();
    }
}
