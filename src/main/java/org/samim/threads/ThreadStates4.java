package org.samim.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Practicing some implementations of Runnable and Callable.
 * Created an SO post related ot Thread and ExecutorService:
 * <a href="https://stackoverflow.com/questions/78684206/execute-an-instance-of-thread-in-an-executorservice">SO post</a>
 */
public class ThreadStates4 {

    public static void main(String[] args) throws InterruptedException {
        Callable<Integer> callable = getCallable(getRandomId());
        Callable<Integer> callable2 = getCallable(getRandomId());
        Runnable runnable = getRunnable(getRandomId());
        Runnable runnable2 = getRunnable(getRandomId());

        List<Future<?>> futures = new ArrayList<>();

        ExecutorService service = Executors.newSingleThreadExecutor();
        futures.add(service.submit(runnable)); // service.submit() is non-blocking call
        futures.add(service.submit(runnable2));
        futures.add(service.submit(callable));
        futures.add(service.submit(callable2));

        futures.forEach(future -> {
            try {
                System.out.println("Is Cancelled: " + future.isCancelled());
                System.out.println("Is Done: " + future.isDone());
                System.out.println("Value: " + future.get()); // Blocking call
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

//        ------------------------------------------

        System.out.println("\n---------------\n");

        List<Callable<Integer>> callables = List.of(
                getCallable(getRandomId()),
                getCallable(getRandomId()),
                getCallable(getRandomId())
        );

        List<Future<Integer>> futuresCallables = service.invokeAll(callables); // Blocking call
        futuresCallables.forEach(future -> {
            try {
                System.out.println("Is Cancelled: " + future.isCancelled());
                System.out.println("Is Done: " + future.isDone());
                System.out.println("Value: " + future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

    }

    private static int getRandomId() {
        return ThreadLocalRandom.current().nextInt(1, 10000);
    }

    private static Runnable getRunnable(int id) {
        return () -> {
            try {
                System.out.println("Starting Runnable id: " + id);
                Thread.sleep(4000);
                System.out.println("--Ending Runnable id: " + id);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private static Callable<Integer> getCallable(int id) {
        return () -> {
            try {
                System.out.println("Starting Callable id: " + id);
                Thread.sleep(4000);
                System.out.println("--Ending Callable id: " + id);
                return 0;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return 1;
            }
        };
    }
}
