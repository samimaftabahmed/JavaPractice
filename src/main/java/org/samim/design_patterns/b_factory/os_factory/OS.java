package org.samim.design_patterns.b_factory.os_factory;

public enum OS {
    LINUX("Linux"), WINDOWS("Windows");

    private final String os;

    OS(String os) {
        this.os = os;
    }

    public String getOs() {
        return os;
    }
}
