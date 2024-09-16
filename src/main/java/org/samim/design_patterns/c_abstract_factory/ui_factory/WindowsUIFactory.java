package org.samim.design_patterns.c_abstract_factory.ui_factory;

import org.samim.design_patterns.c_abstract_factory.component.Button;
import org.samim.design_patterns.c_abstract_factory.component.Checkbox;
import org.samim.design_patterns.c_abstract_factory.os.windows.WinButton;
import org.samim.design_patterns.c_abstract_factory.os.windows.WinCheckbox;

public class WindowsUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}
