package org.samim.design_patterns.abstract_factory.ui_factory;

import org.samim.design_patterns.abstract_factory.component.Button;
import org.samim.design_patterns.abstract_factory.component.Checkbox;
import org.samim.design_patterns.abstract_factory.os.mac.MacButton;
import org.samim.design_patterns.abstract_factory.os.mac.MacCheckbox;

public class MacUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
