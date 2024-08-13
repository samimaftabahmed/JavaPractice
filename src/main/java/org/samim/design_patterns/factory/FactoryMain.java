package org.samim.design_patterns.factory;

import org.samim.design_patterns.factory.os_factory.OS;
import org.samim.design_patterns.factory.os_factory.OperatingSystemFactory;
import org.samim.design_patterns.factory.os_factory.factories.OperatingSystem;

/**
 * Executes the factory design pattern implementations.
 */
public class FactoryMain {

    public static void main(String[] args) {
        executeFactoryMain();
    }

    private static void executeFactoryMain() {
        OperatingSystem win8 = OperatingSystemFactory.getInstance(OS.WINDOWS, "8.1", "x86");
        OperatingSystem ubuntu20_04 = OperatingSystemFactory.getInstance(OS.LINUX, "Ubuntu 20.04 LTS", "x64");
        String directory = "office_files";

        System.out.printf("---%s %s commands---\n", win8.getType().getOs(), win8.getVersion());
        viewCommands(win8, directory);

        System.out.printf("\n---%s %s commands---\n", ubuntu20_04.getType().getOs(), ubuntu20_04.getVersion());
        viewCommands(ubuntu20_04, directory);
    }

    private static void viewCommands(OperatingSystem os, String dir) {
        os.changeDirectory(dir);
        os.createDirectory(dir);
        os.removeDirectory(dir);
    }
}
