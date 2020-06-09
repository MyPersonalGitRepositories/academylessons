package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.TestConfigurations;
import org.academy.utils.web.AbstractWebDriver;
import org.academy.web.pages.BasePage;
import org.academy.web.pages.IssuesInRepoPage;
import org.academy.web.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Slf4j
public class IssueTest extends AbstractWebDriver {

    private MainPage mainPage;
    private BasePage basePage;

    public IssueTest() {
        super();
    }

    @BeforeClass
    private void login() {
        mainPage = new MainPage(webDriver, true, TestConfigurations.getUrl());
        log.info("Start 'IssueTest'");
        log.info("trying to login into github account");
        basePage = mainPage
                .clickOnSignIn()
                .login();
        log.info("logged in into github account");
    }

    @Test(priority = 1)
    public void getCommentTest() {
        String commitmentText =
                basePage.clickOnIssuesLink()
                        .clickOnIssue21420()
                        .getLastComment();
        log.info("Comment 21-4-20: " + commitmentText);
    }

    @Test(priority = 2)
    public void checkBoxesTest() {
        IssuesInRepoPage issuesCheckBoxes =
                basePage.clickOnRepositoryLink()
                        .clickOnIssuesInRepo();
        int numberOfCheckBoxes = issuesCheckBoxes.clickOnRandCheckBoxes();

        Assert.assertEquals(issuesCheckBoxes.getClickedCheckBoxes(), numberOfCheckBoxes);
    }

    @Test(priority = 2)
    public void checkNewIssueFunction() {
        IssuesInRepoPage issuesInRepoPage =
                basePage
                        .clickOnRepositoryLink()
                        .clickOnIssuesInRepo()
                        .clickOnNewIssueButton()
                        .fillTheTitle("my_test")
                        .clickOnSubmitNewIssueButton()
                        .clickOnIssuesInRepoLink();

        String testText =
                issuesInRepoPage
                        .getNewIssue()
                        .getText();

        Assert.assertNotNull(testText);

        issuesInRepoPage
                .clickOnNewIssue()
                .clickOnDeleteIssue();
    }

    @AfterMethod
    private void afterMethod() {
        webDriver.get(TestConfigurations.getUrl());
        log.info("returned to the mainPage");
    }
}
