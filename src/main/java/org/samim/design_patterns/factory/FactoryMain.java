package org.samim.design_patterns.factory;

import org.samim.design_patterns.factory.car_factory.CarModel;
import org.samim.design_patterns.factory.car_factory.HondaCarFactory;
import org.samim.design_patterns.factory.car_factory.factories.HondaCar;
import org.samim.design_patterns.factory.os_factory.OS;
import org.samim.design_patterns.factory.os_factory.OperatingSystemFactory;
import org.samim.design_patterns.factory.os_factory.factories.OperatingSystem;

/**
 * Executes the factory design pattern implementations.
 */
public class FactoryMain {

    public static void main(String[] args) {
        executeCarFactory();
        executeFactoryMain();
    }

    private static void executeCarFactory() {
        HondaCar amaze = HondaCarFactory.getInstance(CarModel.AMAZE, "S");
        HondaCar amazeCvt = HondaCarFactory.getInstance(CarModel.AMAZE_CVT, "V");
        HondaCar city = HondaCarFactory.getInstance(CarModel.CITY, "S");
        HondaCar cityCvt = HondaCarFactory.getInstance(CarModel.CITY_CVT, "S");
        HondaCar cityV = HondaCarFactory.getInstance(CarModel.CITY_CVT, "V");
        HondaCar civic = HondaCarFactory.getInstance(CarModel.CIVIC, "S");
        HondaCar civicTurbo = HondaCarFactory.getInstance(CarModel.CIVIC_TURBO, "ST");

        viewCarDetails(amaze);
        viewCarDetails(amazeCvt);
        viewCarDetails(city);
        viewCarDetails(cityCvt);
        viewCarDetails(cityV);
        viewCarDetails(civic);
        viewCarDetails(civicTurbo);
    }

    private static void viewCarDetails(HondaCar hondaCar) {
        System.out.printf("\n--- Honda Car: %s %s ---\n", hondaCar.getModel(), hondaCar.getVersion());
        hondaCar.engine();
        hondaCar.transmission();
    }


    private static void executeFactoryMain() {
        OperatingSystem win8 = OperatingSystemFactory.getInstance(OS.WINDOWS, "8.1", "x86");
        OperatingSystem ubuntu20_04 = OperatingSystemFactory.getInstance(OS.LINUX, "Ubuntu 20.04 LTS", "x64");

        String directory = "office_files";
        viewCommands(win8, directory);
        viewCommands(ubuntu20_04, directory);
    }

    private static void viewCommands(OperatingSystem os, String dir) {
        System.out.printf("\n---%s %s commands---\n", os.getType().getOs(), os.getVersion());
        os.changeDirectory(dir);
        os.createDirectory(dir);
        os.removeDirectory(dir);
    }
}
