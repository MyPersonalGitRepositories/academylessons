package org.academy.utils.web.elements.impl;

import org.academy.utils.web.elements.elements.TextField;
import org.openqa.selenium.WebElement;

class TextFieldImpl extends AbstractElement implements TextField {
    protected TextFieldImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void type(final String text) {
        wrappedElement.sendKeys(text);
    }

    @Override
    public void clear() {
        wrappedElement.clear();
    }

    @Override
    public void clearAndType(final String text) {
        clear();
        type(text);
    }

    @Override
    public void sendKeys(String text) {
        wrappedElement.sendKeys(text);
    }
}
