package org.samim.design_patterns.b_factory.os_factory;

import org.samim.design_patterns.b_factory.os_factory.factories.LinuxOS;
import org.samim.design_patterns.b_factory.os_factory.factories.OperatingSystem;
import org.samim.design_patterns.b_factory.os_factory.factories.WindowsOS;

public class OperatingSystemFactory {

    private OperatingSystemFactory() {
    }

    public static OperatingSystem getInstance(OS type, String version, String architecture) {
        switch (type) {
            case WINDOWS:
                return new WindowsOS(version, architecture);
            case LINUX:
                return new LinuxOS(version, architecture);
            default:
                throw new IllegalArgumentException("Unknown OS");
        }
    }
}
