package org.samim.design_patterns.abstract_factory.ui_factory;

import org.samim.design_patterns.abstract_factory.component.Button;
import org.samim.design_patterns.abstract_factory.component.Checkbox;

public interface UIFactory {

    Button createButton();

    Checkbox createCheckbox();
}
