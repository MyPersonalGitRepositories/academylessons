package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.academy.utils.web.WebWaiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends AbstractPage {
    public SettingsPage(WebDriver webDriver) {
        super(webDriver, false, "");
    }

    @FindBy(xpath = "//a[contains(text(),'Manage access')]")
    private WebElement manageAccess;

    @FindBy(xpath = "//summary[@class='btn btn-primary mt-3']")
    private WebElement inviteCollaborator;

    @FindBy(xpath = "//input[@id='repo-add-access-search-member']")
    private WebElement searchCollaborator;

    @FindBy(xpath = "//ul[@id='repo-add-access-search-results']")
    private WebElement search;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block css-truncate css-truncate-overflow']")
    private WebElement button;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block disabled']")
    private WebElement errorMessage;

    @FindBy(xpath = "//input[@placeholder='Find a collaborator…']")
    private WebElement findCollaborator;

    @FindBy(xpath = "//div[@class='d-flex flex-column flex-auto col-6']//a")
    private WebElement collaboratorLogin;

    @FindBy(xpath = "//summary[@class='close-button btn-octicon-danger']")
    private WebElement deleteCollaborator;

    @FindBy(xpath = "//button[@class='btn btn-danger btn-block css-truncate css-truncate-overflow']")
    private WebElement deleteCollaboratorButton;

    @FindBy(xpath = "//h3[@class='mb-3']")
    private WebElement noCollaborators;

    public SettingsPage goToManageAccess() {
        manageAccess.click();
        return this;
    }

    public SettingsPage inviteCollaborator() {
        WebWaiters.waitUntilElementIsClickable(webDriver, inviteCollaborator);
        inviteCollaborator.click();
        return this;
    }

    public SettingsPage searchCollaborator(String collaborator) {
        searchCollaborator.sendKeys(collaborator);
        return this;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public SettingsPage clickAddCollaboratorButton() {
        search.click();
        button.click();
        return this;
    }

    public String findCollaborator(String collaborator) {
        findCollaborator.sendKeys(collaborator);
        return collaboratorLogin.getText();
    }

    public SettingsPage deleteCollaborator() {
        deleteCollaborator.click();
        deleteCollaboratorButton.click();
        return this;
    }

    public String noInvitedCollaboratorsMessage() {
        return noCollaborators.getText();
    }

}
