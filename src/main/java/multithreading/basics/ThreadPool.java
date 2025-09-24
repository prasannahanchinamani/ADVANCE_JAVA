package multithreading.basics;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
                4, 4, 2, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()
        );
        for (int i = 1; i <= 5; i++) {
//            Executors.newSingleThreadExecutor(); // one by one
            int finalI = i;
            executorService.submit(() ->
                    System.out.println("Taks Number " + finalI));
        }
        executor.shutdownNow();

    }
}
