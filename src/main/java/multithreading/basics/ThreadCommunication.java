package multithreading.basics;

public class ThreadCommunication {
    private int data;
    private boolean isAvailable = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (isAvailable) {  //data is present true
            System.out.println("Data produce:" + data);
            wait();
        }
        data = value;
        isAvailable = true;
        System.out.println("Waking the Thread!!!!!");
        notifyAll();

    }

    public synchronized void consume() throws InterruptedException {
        while (!isAvailable) {  //data is present true
            System.out.println("Data consume :" + data);
            wait();
        }
        isAvailable = false;
        System.out.println("Waking the Thread!!!!!");
        notify();

    }

    public static void main(String[] args) {
        ThreadCommunication cm = new ThreadCommunication();
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                try {
                    if(i==2)
                    cm.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        producer.start();

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                try {
                    cm.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        consumer.start();
    }
}
