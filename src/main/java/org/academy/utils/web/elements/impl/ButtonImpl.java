package org.academy.utils.web.elements.impl;

import org.academy.utils.web.elements.elements.Button;
import org.openqa.selenium.WebElement;

class ButtonImpl extends AbstractElement implements Button {
    protected ButtonImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        wrappedElement.click();
    }
}
