package org.samim.design_patterns.b_factory.car_factory.factories;

public class AmazeCVT extends HondaCar {

    public AmazeCVT(String model, String version) {
        super(model, version);
    }

    @Override
    public void engine() {
        System.out.println("1.2L SOHC 4-cylinder Petrol");
    }

    @Override
    public void transmission() {
        System.out.println("CVT");
    }
}
