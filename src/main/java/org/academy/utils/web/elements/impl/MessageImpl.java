package org.academy.utils.web.elements.impl;

import org.academy.utils.web.elements.elements.Message;
import org.openqa.selenium.WebElement;

public class MessageImpl extends AbstractElement implements Message {
    protected MessageImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public String getMessageText() {
        return wrappedElement.getText();
    }
}
