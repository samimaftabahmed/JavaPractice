package org.samim.design_patterns.factory.os_factory.factories;

import org.samim.design_patterns.factory.os_factory.OS;

public abstract class OperatingSystem {

    private final String version;
    private final String architecture;

    public OperatingSystem(String version, String architecture) {
        this.version = version;
        this.architecture = architecture;
    }

    public abstract void changeDirectory(String dir);

    public abstract void removeDirectory(String dir);

    public abstract void createDirectory(String dir);

    public abstract OS getType();

    public String getVersion() {
        return version;
    }

    public String getArchitecture() {
        return architecture;
    }

}
