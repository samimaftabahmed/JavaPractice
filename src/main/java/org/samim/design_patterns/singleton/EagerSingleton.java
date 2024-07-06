package org.samim.design_patterns.singleton;

public class EagerSingleton {

    private static final EagerSingleton INSTANCE = null;

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
