package org.samim.design_patterns.factory.car_factory.factories;

public abstract class HondaCar {

    private final String model;
    private final String version;

    public HondaCar(String model, String version) {
        this.model = model;
        this.version = version;
    }

    public abstract void engine();

    public abstract void transmission();

    public String getModel() {
        return model;
    }

    public String getVersion() {
        return version;
    }
}
