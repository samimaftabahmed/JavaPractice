package org.samim.design_patterns.c_abstract_factory.component;

public interface Button extends Draw {

    default void longClick() {
        System.out.printf("%s Long Click action.\n", this.getClass().getSimpleName());
    }
}
