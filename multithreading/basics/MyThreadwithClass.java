package multithreading.basics;

public class MyThreadwithClass extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("With Thread class");
            printTask();
        }
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printTask() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread will continue...!");
        }
        printTask1();
    }

    public void printTask1() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Task 2 will Continue......!");
        }
    }

    public static void main(String[] args) {
        MyThreadwithClass t1 = new MyThreadwithClass();
        MyThreadwithClass t2 = new MyThreadwithClass();
        t1.start();
        t2.start();
    }
}
