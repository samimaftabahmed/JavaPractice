package org.samim.collections.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class WaitNotify<E> {

    private final static int maxExecution = 5;
    private final Object lockObject = new Object();
    private final Queue<E> queue = new LinkedList<>();
    private final int CAPACITY = 1;

    public static void main(String[] args) {
        WaitNotify<Integer> waitNotify = new WaitNotify<>();
        Runnable producer = waitNotify.getProducer();
        Runnable consumer = waitNotify.getConsumer();

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(producer);
        service.submit(consumer);
        service.shutdown();
    }

    private Runnable getConsumer() {
        AtomicInteger consumerCount = new AtomicInteger(0);
        Runnable consumer = () -> {
            while (consumerCount.get() < maxExecution) {
                try {
                    E take = take();
                    System.out.println("- Item Taken %s, iteration %s".formatted(take, consumerCount.get()));
                    consumerCount.getAndAdd(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        return consumer;
    }

    private Runnable getProducer() {
        AtomicInteger producerCount = new AtomicInteger(0);
        Runnable producer = () -> {
            while (producerCount.get() < maxExecution) {
                int i = ThreadLocalRandom.current().nextInt(1, 1000000);
                try {
                    put(i);
                    System.out.println("Inserted item %s, iteration %s".formatted(i, producerCount.get()));
                    producerCount.getAndAdd(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        return producer;
    }

    public void put(Object e) throws InterruptedException {
        synchronized (lockObject) {
            while (queue.size() == CAPACITY) {
                lockObject.wait();
            }

            queue.add((E) e);
            lockObject.notifyAll();
        }
    }

    public E take() throws InterruptedException {
        synchronized (lockObject) {
            while (queue.isEmpty()) {
                lockObject.wait();
            }

            E remove = queue.poll();
            lockObject.notifyAll();
            return remove;
        }
    }

}
