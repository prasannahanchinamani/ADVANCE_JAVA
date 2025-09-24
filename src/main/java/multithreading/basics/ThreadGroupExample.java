package multithreading.basics;

class Calculator extends Thread {
    private String operation;
    private int a, b;

    public Calculator(String operation, int a, int b) {
        this.operation = operation;
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        switch (operation) {
            case "add":
                System.out.println(Thread.currentThread().getName() + " Addition: " + (a + b));
                break;
            case "sub":
                System.out.println(Thread.currentThread().getName() + " Subtraction: " + (a - b));
                break;
        }
    }
}

public class ThreadGroupExample {
    public static void main(String[] args) {
        ThreadGroup additionGroup = new ThreadGroup("add");
        ThreadGroup substaction = new ThreadGroup("sub");
//        Thread t1=new Thread(addition,new Calculator("add",10,20),"Thread add");
        Thread t1 = new Thread(additionGroup, new Calculator("add", 10, 20), "AddThread1");
        Thread t2 = new Thread(substaction, new Calculator("sub", 20, 10), "Sub Thread 1");
        Thread t3 = new Thread(additionGroup, new Calculator("add", 10, 30), "AddThread 2");
        Thread t4 = new Thread(substaction, new Calculator("sub", 20, 0), "Sub Thread 2");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
