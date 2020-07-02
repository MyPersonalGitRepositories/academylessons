package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectEditPage extends AbstractPage {
    public ProjectEditPage(WebDriver webDriver) {
        super(webDriver, false);
    }

    @FindBy(xpath = "//button[@class='btn btn-danger flex-auto']")
    WebElement deleteBtn;

    public void deleteProject() {
        deleteBtn.click();
        webDriver.switchTo().alert().accept();
    }
}
