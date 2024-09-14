package org.samim.design_patterns.abstract_factory;

import org.samim.design_patterns.abstract_factory.ui_factory.MacUIFactory;
import org.samim.design_patterns.abstract_factory.ui_factory.WindowsUIFactory;

public class MainAbstractFactory {

    public static void main(String[] args) {
        new Application(new MacUIFactory());
        new Application(new WindowsUIFactory());
    }

}
