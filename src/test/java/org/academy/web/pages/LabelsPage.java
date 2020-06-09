package org.academy.web.pages;

import org.academy.TestConfigurations;
import org.academy.web.AbstractPage;
import org.academy.utils.web.WebWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LabelsPage extends AbstractPage {
    public LabelsPage(WebDriver webDriver) {
        super(webDriver, false);
    }

    @FindBy(xpath = "//button[contains(@class,'btn btn-primary js-details-target js-details-target-new-label')]")
    private WebElement newLabelBtn;

    @FindBy(xpath = "//input[@id='label-name-']")
    private WebElement labelName;

    @FindBy(xpath = "//input[@id='label-description-']")
    private WebElement labelDescription;

    @FindBy(xpath = "//input[@id='label-color-']")
    private WebElement labelColor;

    @FindBy(xpath = "//button[contains(text(),'Create label')]")
    private WebElement createBtn;

    @FindBy(xpath = "//span[@class='js-labels-count']")
    private WebElement count;

    @FindBy(xpath = "//dd[@id='label--name-error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//button[@class='btn js-details-target js-edit-label-cancel']")
    private WebElement cancelBtn;

    private String label = "//div/a/span[contains(text(),'" + TestConfigurations.getLabel() + "')]/following::*[11]";

    public LabelsPage addNewLabel() {
        newLabelBtn.click();
        labelName.sendKeys(TestConfigurations.getLabel());
//        labelDescription.sendKeys();
//        labelColor.sendKeys();
        createBtn.click();
        return this;
    }

    public LabelsPage deleteLabel() {
        WebElement deleteBtn = webDriver.findElement(By.xpath(label));
        deleteBtn.click();
        webDriver.switchTo().alert().accept();
        return this;
    }

    public int getLabelsAmount() {
        WebWaiters.waitUntilElementIsVisible(count, webDriver, 2);
        return Integer.parseInt(count.getText());
    }

    public String getErrorMessage() {
        WebWaiters.waitUntilElementIsVisible(errorMessage, webDriver, 4);
        return errorMessage.getText();
    }

    public LabelsPage fillLabelTitle(String title) {
        labelName.sendKeys(title);
        return this;
    }

    public LabelsPage fillLabelDesc(String description) {
        labelDescription.sendKeys(description);
        return this;
    }

    public LabelsPage clickOnCreateBtn() {
        createBtn.click();
        return this;
    }

    public LabelsPage clickOnNewLabelBtn() {
        newLabelBtn.click();
        return this;
    }

    public LabelsPage clickOnCancelBtn() {
        cancelBtn.click();
        return this;
    }

}
