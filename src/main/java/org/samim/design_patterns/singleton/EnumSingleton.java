package org.samim.design_patterns.singleton;

public enum EnumSingleton {

    INSTANCE;

    private String someValue="abc";

    public String getSomeValue() {
        return someValue;
    }
}
