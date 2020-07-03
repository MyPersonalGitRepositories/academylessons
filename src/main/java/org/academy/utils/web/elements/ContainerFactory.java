package org.academy.utils.web.elements;

import org.academy.utils.web.elements.elements.Container;
import org.openqa.selenium.WebElement;

public interface ContainerFactory {
    <C extends Container> C create(Class<C> containerClass, WebElement wrappedElement);

}
