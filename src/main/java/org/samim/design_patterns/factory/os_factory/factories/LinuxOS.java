package org.samim.design_patterns.factory.os_factory.factories;

import org.samim.design_patterns.factory.os_factory.OS;

public class LinuxOS extends OperatingSystem {

    public LinuxOS(String version, String architecture) {
        super(version, architecture);
    }

    @Override
    public void changeDirectory(String dir) {
        System.out.println("cd " + dir);
    }

    @Override
    public void removeDirectory(String dir) {
        System.out.println("rm " + dir);
    }

    @Override
    public void createDirectory(String dir) {
        System.out.println("mkdir " + dir);
    }

    @Override
    public OS getType() {
        return OS.LINUX;
    }
}
