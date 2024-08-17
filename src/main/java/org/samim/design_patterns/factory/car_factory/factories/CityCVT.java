package org.samim.design_patterns.factory.car_factory.factories;

public class CityCVT extends HondaCar {

    public CityCVT(String model, String version) {
        super(model, version);
    }

    @Override
    public void engine() {
        System.out.println("1.5L DOHC 4-cylinder Petrol");
    }

    @Override
    public void transmission() {
        System.out.println("CVT");
    }
}
