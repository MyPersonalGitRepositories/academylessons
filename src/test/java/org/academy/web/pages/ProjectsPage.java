package org.academy.web.pages;

import org.academy.TestConfigurations;
import org.academy.web.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends AbstractPage {
    public ProjectsPage(WebDriver webDriver) {
        super(webDriver, false);
    }

    @FindBy(xpath = "//a[@class='btn-link selected']")
    private WebElement projectAmount;

    private WebElement projectDropDown = webDriver.findElement(
            By.xpath("//div[@id='projects-results']//div[@data-filter-value='"
                    + TestConfigurations.getProject() + "']//details[1]//summary[1]//*[local-name()='svg']"));
    private WebElement closeButton = webDriver.findElement(
            By.xpath("//div[@id='projects-results']//div[@data-filter-value='"
                    + TestConfigurations.getProject() + "']//details[1]//button[@name='state']"));
    private WebElement editButton = webDriver.findElement(
            By.xpath("//div[@id='projects-results']//div[@data-filter-value='"
                    + TestConfigurations.getProject() + "']//details[1]//a[@class='btn-link dropdown-item']"));

    public ProjectsPage clickOnDropdown() {
        projectDropDown.click();
        return this;
    }

    public ProjectsPage closeProject() {
        closeButton.click();
        return this;
    }

    public ProjectEditPage clickOnEdit() {
        editButton.click();
        return new ProjectEditPage(webDriver);
    }

    public String getProjectsAmount() {
        return projectAmount.getText();
    }

}
