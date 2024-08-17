package org.samim.design_patterns.factory.car_factory.factories;

public class Amaze extends HondaCar {

    public Amaze(String model, String version) {
        super(model, version);
    }

    @Override
    public void engine() {
        System.out.println("1L SOHC 3-cylinder Petrol");
    }

    @Override
    public void transmission() {
        System.out.println("Manual Gearbox");
    }
}
