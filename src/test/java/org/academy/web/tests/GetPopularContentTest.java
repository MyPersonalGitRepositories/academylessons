package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.utils.web.AbstractWebDriver;
import org.academy.web.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Collections.max;

@Slf4j
public class GetPopularContentTest extends AbstractWebDriver {
    private BasePage basePage;
    private LoginPage loginPage;
    private RepositoryPage repositoryPage;
    private InsightsPage insightsPage;
    private TrafficPage trafficPage;

    public GetPopularContentTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        loginPage = new LoginPage(webDriver, true);
        basePage = loginPage.login();
        log.info("Logged in");
    }

    @Test
    public void filterTrending() {
        List<Integer> allContentViews;
        List<Integer> firstContentViews;
        log.info("Launching repository page");
        repositoryPage = basePage.goToRepositoryLink();
        log.info("Launching insights page");
        insightsPage = repositoryPage.clickOnInsights();
        log.info("Launching traffic page");
        trafficPage = insightsPage.clickOnTraffic();
        log.info("Getting list of views");

        allContentViews = trafficPage.getAllContentViews();
        log.info("All popular content Views: " + allContentViews);

        firstContentViews=trafficPage.getFirstContentViews();
        log.info("First content Views: " + firstContentViews);

        log.info("MAX amount of views from popular content: " + max(allContentViews));
        log.info("'alhonchar/academylessons' is has views: " + firstContentViews.get(0));

        Assert.assertEquals(max(allContentViews), firstContentViews.get(0));
        log.info("'alhonchar/academylessons' has MAX amount of views!");
    }
}
