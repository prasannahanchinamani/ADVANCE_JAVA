package multithreading.threading;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolWithTheadPoolExecutor {
    public static void main(String[] args) throws InterruptedException {
        // Create ThreadPoolExecutor
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, 2, 1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()
        );
        for (int i = 1; i <= 8; i++) {
            int task_Number = i;
            executor.submit(() -> {
                System.out.println("Task Is Executing " + task_Number);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task is Completed:" + task_Number);
            });
        }
        executor.shutdown();
        if(executor.awaitTermination(2,TimeUnit.SECONDS)){
            executor.shutdown();
            System.out.println("Task is Complited");
        }else{
            System.out.println("Task is not Completed......... still some are Running");
        }
    }
}
