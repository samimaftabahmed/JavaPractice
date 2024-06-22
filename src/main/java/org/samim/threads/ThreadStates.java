package org.samim.threads;

/**
 * Program to view Thread states.
 */
public class ThreadStates {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5);
                for (int i = 0; i < 1000000; i++) ;
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
        int j = 0;
        while (true) {
            j++;
            if (j == 5) {
//                thread.interrupt(); // if interrupted then thread state is TERMINATED
            }
            Thread.State state = thread.getState();
            System.out.println(state);
            if (state == Thread.State.TERMINATED) {
                break;
            }
            Thread.sleep(1);
        }
    }

}
