package org.academy.utils.web.elements.elements;

public interface SelectElement extends Element {
    void selectByValue(String value);

    void selectByIndex(int index);

    void selectByVisibleText(String text);
}
