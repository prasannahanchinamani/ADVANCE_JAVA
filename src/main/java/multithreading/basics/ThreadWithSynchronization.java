package multithreading.basics;

public class ThreadWithSynchronization {
    synchronized public void add(int a, int b) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Sum:" + (a + b));
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(
                () -> {
                    for (int i = 1; i <= 3; i++) {
                        System.out.println(" Thread  " + i);
                    }
                });
        Thread addthread = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                try {
                    ThreadWithSynchronization st = new ThreadWithSynchronization();
                    st.add(i, 0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        addthread.start();
        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 7; i++)
                System.out.println("thread 3 is running");
        });

        t1.start();
        t3.start();

    }
}
