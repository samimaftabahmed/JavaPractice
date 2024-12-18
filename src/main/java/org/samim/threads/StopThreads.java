package org.samim.threads;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class StopThreads {

    public static void main(String[] args) {
        TaskA taskA = new TaskA(UUID.randomUUID().toString().substring(0, 6));
        TaskB taskB = new TaskB(UUID.randomUUID().toString().substring(0, 8));

        taskA.start();
        taskB.start();

        try {
            Thread.sleep(2000L);
            taskA.stopThread();
            taskB.interrupt();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("MAIN THREAD INTERRUPTED.", e);
        }
    }

    /**
     * A task executed on a separate Thread which is stopped by monitoring a specific flag.
     */
    private static class TaskA extends Thread {

        private final AtomicBoolean isInterrupted = new AtomicBoolean(false);
        private final String threadId;

        public TaskA(String threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while (!this.isInterrupted.get()) {
                try {
                    // OTHER IMPORTANT TASKS
                    Thread.sleep(500L);
                    System.out.println("Thread '%s' is under execution.".formatted(this.threadId));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException("CHILD THREAD TaskA INTERRUPTED.", e);
                }
            }
            System.out.println("Thread '%s' interrupted.".formatted(this.threadId));
        }

        public void stopThread() {
            this.isInterrupted.set(true);
        }
    }

    /**
     * A task executed on a separate Thread which is stopped by monitoring the interrupt flag.
     */
    private static class TaskB extends Thread {

        private final String threadId;

        public TaskB(String threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    // OTHER IMPORTANT TASKS
                    Thread.sleep(500L);
                    System.out.println("Thread '%s' is under execution.".formatted(this.threadId));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread '%s' interrupted.".formatted(this.threadId));
        }
    }
}
