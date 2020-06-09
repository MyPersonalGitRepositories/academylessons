package org.academy.web.tests;

import org.academy.TestConfigurations;
import org.academy.utils.web.AbstractWebDriver;
import org.academy.web.pages.LoginPage;
import org.academy.web.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends AbstractWebDriver {
    private LoginPage loginPage;
    private MainPage mainPage;

    public LoginTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        mainPage = new MainPage(webDriver, true, TestConfigurations.getUrl());
        loginPage = mainPage.clickOnSignIn();
    }

    @DataProvider(name = "login form provider")
    public Object[][] dataProviderAuthUserType() {
        return new Object[][]{
                {"", ""},
                {"alhonchar", ""},
                {"", "Alex123456&*"},
                {"alhonchar", "alhonchar"},
                {"Alex123456&*", "Alex123456&*"},
                {"login with spaces", "Alex123456&*"},
        };
    }

    @Test
    public void positiveLoginTest() {
        loginPage.fillLoginField(TestConfigurations.getLogin());
        loginPage.fillPassField(TestConfigurations.getPassword());
        loginPage.clickOnSubmit();
    }

    @Test(dataProvider = "login form provider")
    public void negativeLoginTest(String login, String pass) {
        loginPage.fillLoginField(login);
        loginPage.fillPassField(pass);
        loginPage.clickOnSubmit();
        String error = loginPage.getErrorMessage();
        assertThat(error).as("Got incorrect verification message").isEqualTo("Incorrect username or password.");
    }


}
