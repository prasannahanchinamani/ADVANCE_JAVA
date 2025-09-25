package multithreading.threading;

public class VolatileExample {
    public volatile boolean flag = false;

    public void setTrue() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Made the flag True");
        flag = true;
    }

    public void printIfTrue() {
        while (!flag) {
            System.out.println("Flag is false");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Flag is True!!!!!");
    }

    public static void main(String[] args) {
        VolatileExample vc = new VolatileExample();

        Thread t1 = new Thread(vc::printIfTrue);

        Thread t2 = new Thread(vc::setTrue);

        t1.start();
        t2.start();
    }
}
