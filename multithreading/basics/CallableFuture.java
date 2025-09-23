package multithreading.basics;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture {
    public static void main(String[] args) throws Exception {
        ExecutorService exceutor = Executors.newFixedThreadPool(3);

        Callable<Integer> callable = () -> {
            System.out.println("callable 1");
            return 10;
        };
        Callable<Integer> callable1 = () -> {
            System.out.println("Callable 2");
            return 100;
        };
        //submitting task
        Future<Integer> future = exceutor.submit(callable);
        Thread.sleep(1000);
        Future<Integer> future1 = exceutor.submit(callable1);
        if (future1.cancel(true)) {
            System.out.println("Future1 cancelled " + future1.isCancelled());
            System.out.println("Main thread is working...");
            System.out.println("Result from Callable 1 = " + future.get());
        }
        try{
            System.out.println("Future 1"+future1.get());
        }catch (Exception e){
            System.out.println("Callable 2 was cancelled!");;
        }


        System.out.println("Main thread is working...");

        // Get results (this will block until task is complete)
        System.out.println("Result from Callable 1 = " + future.get());
//        System.out.println("Result from Callable 2 = " + future1.get());

        exceutor.shutdown();
        System.out.println("finished");
    }
}
