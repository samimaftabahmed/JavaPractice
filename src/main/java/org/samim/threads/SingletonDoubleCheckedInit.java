package org.samim.threads;

/**
 * Singleton Thread-safe implementation with Double-Checked Locking.
 */
public class SingletonDoubleCheckedInit {

    private static volatile SingletonDoubleCheckedInit INSTANCE = null;

    private String msg = "Hello";

    private SingletonDoubleCheckedInit() {
    }

    public static SingletonDoubleCheckedInit getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonDoubleCheckedInit.class) { // double-checked locking
                if (INSTANCE == null) {
                    System.out.println("Initialised Instance Double Checked.");
                    INSTANCE = new SingletonDoubleCheckedInit();
                }
            }
        }

        return INSTANCE;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
