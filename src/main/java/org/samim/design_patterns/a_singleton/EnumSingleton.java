package org.samim.design_patterns.a_singleton;

public enum EnumSingleton {

    INSTANCE;

    private String someValue="abc";

    public String getSomeValue() {
        return someValue;
    }
}
