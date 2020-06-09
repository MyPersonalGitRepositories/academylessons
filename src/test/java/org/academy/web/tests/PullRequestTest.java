package org.academy.web.tests;
import lombok.extern.slf4j.Slf4j;
import org.academy.utils.web.AbstractWebDriver;
import org.academy.utils.web.LocalWebDriverManager;
import org.academy.web.pages.LoginPage;
import org.academy.web.pages.PullPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class PullRequestTest extends AbstractWebDriver {
    private LoginPage loginPage;
    private PullPage pullPage;


    public PullRequestTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void goToPullRequestPage(){
        if (webDriver.toString().contains("null")) webDriver = LocalWebDriverManager.getWebDriver();
        loginPage = new LoginPage(webDriver, true);
        loginPage.login();
         pullPage = new PullPage(webDriver, true);
    }

    @AfterMethod (alwaysRun = true)
    public void endTest(){
        webDriver.quit();
    }

    @Test
    public void checkNumberOfRequestsCount(){
        Assert.assertEquals(pullPage.numberOfRequests(), pullPage.requestsInList(),
                "number of requests doesn't match");
    }

    @Test
    public void checkIncorrectRequestSearch(){
        pullPage.searchRequest("incorrect name");
        assert pullPage.isSearchResultEmpty();
    }
}

