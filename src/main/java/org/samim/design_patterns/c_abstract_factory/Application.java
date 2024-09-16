package org.samim.design_patterns.c_abstract_factory;

import org.samim.design_patterns.c_abstract_factory.component.Button;
import org.samim.design_patterns.c_abstract_factory.component.Checkbox;
import org.samim.design_patterns.c_abstract_factory.ui_factory.UIFactory;

public class Application {

    private final Button button;
    private final Checkbox checkbox;

    public Application(UIFactory uiFactory) {
        this.button = uiFactory.createButton();
        this.checkbox = uiFactory.createCheckbox();
        renderUI();
        assignAction();
    }

    public void renderUI() {
        button.paint();
        checkbox.paint();
    }

    public void assignAction() {
        button.longClick();
    }
}
