package multithreading.basics;

public class MythreadWithRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("With Runnable interface!!!");
        }
        printTrack();
        printTrack2();
    }

    public void printTrack() {
        System.out.println("Track one with Runnable..");
    }

    public void printTrack2() {
        System.out.println("Track2 one with Runnable..");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new MythreadWithRunnable());
        t.start();
        Thread t1=new Thread(new MythreadWithRunnable());
        t1.start();
    }
}
