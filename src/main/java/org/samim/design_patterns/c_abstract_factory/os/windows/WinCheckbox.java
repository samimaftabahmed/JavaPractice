package org.samim.design_patterns.c_abstract_factory.os.windows;

import org.samim.design_patterns.c_abstract_factory.component.Checkbox;

public class WinCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.printf("%s printed.\n", this.getClass().getSimpleName());
    }
}