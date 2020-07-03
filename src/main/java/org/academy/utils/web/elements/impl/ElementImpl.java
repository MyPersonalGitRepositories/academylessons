package org.academy.utils.web.elements.impl;

import org.academy.utils.web.elements.elements.Element;
import org.openqa.selenium.WebElement;

public class ElementImpl extends AbstractElement implements Element {
    protected ElementImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
