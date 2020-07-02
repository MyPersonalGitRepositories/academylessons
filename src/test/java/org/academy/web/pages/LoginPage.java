package org.academy.web.pages;

import org.academy.TestConfigurations;
import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Base64;

public class LoginPage extends AbstractPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver, false, "");
    }

    public LoginPage(WebDriver webDriver, boolean navigateToPage) {
        super(webDriver, navigateToPage);
    }


    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passField;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement submitForm;

    @FindBy(xpath = "//div[@class='container-lg px-2']")
    private WebElement errorMessage;

    public LoginPage fillLoginField(String login) {
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage fillPassField(String pass) {
        passField.sendKeys(pass);
        return this;
    }

    public LoginPage clickOnSubmit() {
        submitForm.click();
        return new LoginPage(webDriver);
    }

    public BasePage clickOnSignIn() {
        return new BasePage(webDriver);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public BasePage login() {
        loginField.sendKeys(new String(Base64.getDecoder().decode(TestConfigurations.getLogin())));
        passField.sendKeys(new String(Base64.getDecoder().decode(TestConfigurations.getPassword())));
        submitForm.click();
        return new BasePage(webDriver, false);
    }


}