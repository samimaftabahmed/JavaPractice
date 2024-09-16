package org.samim.design_patterns.b_factory.car_factory.factories;

public class City extends HondaCar {

    public City(String model, String version) {
        super(model, version);
    }

    @Override
    public void engine() {
        System.out.println("1.2L DOHC 4-cylinder Petrol");
    }

    @Override
    public void transmission() {
        System.out.println("Manual Transmission");
    }
}
