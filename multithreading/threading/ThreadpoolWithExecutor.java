package multithreading.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadpoolWithExecutor {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exceutor = Executors.newFixedThreadPool(4);
        for (int i = 1; i <=10; i++) {
            int task_Number = i;
            exceutor.submit(() -> {
                System.out.println("Task " + task_Number + " Thread Running  on ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task " + task_Number + " completed on " + Thread.currentThread().getName());
            });
        }
        exceutor.shutdown();
        if (exceutor.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("All tasks completed!");
        } else {
            System.out.println("Timeout! Some tasks are still running...");
            exceutor.shutdown();
        }
    }

}
