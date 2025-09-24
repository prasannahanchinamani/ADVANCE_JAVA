package multithreading.mutlithreadingop;

public class Singleton {
    private static Singleton instance;
    private static int count;

    private Singleton() {
        count++;
        System.out.println("Singleton object created. Count: " + count);
    }

    private static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {//locking
                if (instance == null) {
                    synchronized (Singleton.class) {
                        instance = new Singleton();
                    }
                }
            }

        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Work on SingleTon");
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Singleton s =
                        Singleton.getInstance();
                s.showMessage();
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }

}
