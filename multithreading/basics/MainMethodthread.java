package multithreading.basics;

public class MainMethodthread {
    public static void main(String[] args) {
        System.out.println("main Thread:"+Thread.currentThread().getName());
        Thread thread=new Thread(()->
                System.out.println("anothre thread:"+Thread.currentThread().getName()));
        thread.start();
        Runnable rn=()-> System.out.println("Runnable Thread!");
        rn.run();
    }
}
