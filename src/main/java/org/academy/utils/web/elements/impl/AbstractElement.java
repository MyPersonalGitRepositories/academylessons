package org.academy.utils.web.elements.impl;

import org.academy.utils.web.elements.elements.Element;
import org.openqa.selenium.WebElement;

abstract class AbstractElement implements Element {
	protected final WebElement wrappedElement;

	protected AbstractElement(final WebElement wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

	@Override
	public boolean isDisplayed() {
		return wrappedElement.isDisplayed();
	}

	@Override
	public WebElement getElement() {
		return wrappedElement;
	}

	@Override
	public String getAttribute(String attribute) {
		return wrappedElement.getAttribute(attribute);
	}
}
