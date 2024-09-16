package org.samim.design_patterns.b_factory.car_factory;

import org.samim.design_patterns.b_factory.car_factory.factories.Amaze;
import org.samim.design_patterns.b_factory.car_factory.factories.AmazeCVT;
import org.samim.design_patterns.b_factory.car_factory.factories.City;
import org.samim.design_patterns.b_factory.car_factory.factories.CityCVT;
import org.samim.design_patterns.b_factory.car_factory.factories.Civic;
import org.samim.design_patterns.b_factory.car_factory.factories.CivicTurbo;
import org.samim.design_patterns.b_factory.car_factory.factories.HondaCar;

public class HondaCarFactory {

    private HondaCarFactory() {
    }

    public static HondaCar getInstance(CarModel carModel, String version) {
        HondaCar hondaCar = new City(carModel.name(), version);

        switch (carModel) {
            case CITY_CVT -> hondaCar = new CityCVT(carModel.name(), version);
            case CIVIC -> hondaCar = new Civic(carModel.name(), version);
            case CIVIC_TURBO -> hondaCar = new CivicTurbo(carModel.name(), version);
            case AMAZE -> hondaCar = new Amaze(carModel.name(), version);
            case AMAZE_CVT -> hondaCar = new AmazeCVT(carModel.name(), version);
        }

        return hondaCar;
    }
}
