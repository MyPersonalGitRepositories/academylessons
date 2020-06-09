package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.utils.web.AbstractWebDriver;
import org.academy.web.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

@Slf4j
public class UserTest extends AbstractWebDriver {
    private BasePage basePage;
    private LoginPage loginPage;
    private RepositoryPage repositoryPage;
    private InsightsPage insightsPage;
    private ForksPage forksPage;

    public UserTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        loginPage = new LoginPage(webDriver, true);
        basePage = loginPage.login();
        log.info("Logged in");
    }

    @Test(description = "get forked users and check them in 'Network'")
    public void forkedUsersCheck() {
        List<String> forkedUsers;
        log.info("Launching repository page");
        repositoryPage = basePage.goToRepositoryLink();
        log.info("Launching insights page");
        insightsPage = repositoryPage.clickOnInsights();
        log.info("Launching forks page");
        forksPage = insightsPage.clickOnForks();
        log.info("Getting list of users who fork repository");
        forkedUsers = forksPage.userNames();
        log.info("Forked users: " + forkedUsers);
    }

}
