package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.TestConfigurations;
import org.academy.utils.web.AbstractWebDriver;
import org.academy.web.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class ActionTest extends AbstractWebDriver {
    private LoginPage loginPage;
    private MainPage mainPage;
    private BasePage basePage;
    private RepositoryPage repositoryPage;
    private ActionPage actionPage;
    private RunActionPage runActionPage;

    public ActionTest() {
        super();
    }

    public void login() {
        loginPage.fillLoginField(TestConfigurations.getLogin());
        loginPage.fillPassField(TestConfigurations.getPassword());
        loginPage.clickOnSubmit();
    }

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        log.info("Start 'ActionTest'");
        mainPage = new MainPage(webDriver, true, TestConfigurations.getUrl());
        loginPage = mainPage.clickOnSignIn();
        login();
        basePage = loginPage.clickOnSignIn();
        repositoryPage = basePage.goToRepositoryLink();
        actionPage = repositoryPage.clickOnActionLink();
        runActionPage = actionPage.goToRunActionPage();
    }

    @Test
    public void getHash() {
        log.info("Hash code " + runActionPage.getActionHashCode());
    }

}
