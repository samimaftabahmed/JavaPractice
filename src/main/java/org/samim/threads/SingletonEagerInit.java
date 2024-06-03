package org.samim.threads;

/**
 * Singleton Thread-safe implementation without Double-Checked Locking.
 * This eagerly initialises the singleton instance.
 * Also, static fields and blocks are initialised one after the another by the JVM.
 */
public class SingletonEagerInit {

    private static final SingletonEagerInit INSTANCE = new SingletonEagerInit();

    private String msg = "Hello";

    private SingletonEagerInit() {
    }

    public static SingletonEagerInit getInstance() {
        return INSTANCE;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
