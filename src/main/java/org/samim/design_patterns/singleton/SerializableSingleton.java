package org.samim.design_patterns.singleton;

import java.io.Serial;
import java.io.Serializable;

public class SerializableSingleton implements Serializable {

    private static SerializableSingleton instance = null;

    private SerializableSingleton() {
    }

    public static SerializableSingleton getInstance() {
        if (instance == null) {
            instance = new SerializableSingleton();
        }
        return instance;
    }

    /**
     * Method used by JVM to check whether an instance is present or not during deserialization.
     */
    @Serial
    protected Object readResolve() {
        return instance;
    }
}
