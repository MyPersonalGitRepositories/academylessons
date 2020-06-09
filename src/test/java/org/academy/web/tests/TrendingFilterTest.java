package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.TestConfigurations;
import org.academy.utils.web.AbstractWebDriver;
import org.academy.utils.web.WebHelpers;
import org.academy.web.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class TrendingFilterTest extends AbstractWebDriver {
    private BasePage basePage;
    private ExplorePage explorePage;
    private TrendingPage trendingPage;


    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        MainPage mainPage = new MainPage(webDriver, true, TestConfigurations.getUrl());
        basePage = mainPage.clickOnSignIn().login();
        log.info("Logged in");
    }

    @AfterMethod(alwaysRun = true)
    public void clearPrecondition() {
        WebHelpers.deleteCookieByName(TestConfigurations.getUserCookie(), webDriver);
        WebHelpers.refreshPage(webDriver);
    }

    @Test
    public void filterTrending() {
        explorePage = basePage.clickOnExploreLink();
        log.info("Click on explore link");
        trendingPage = explorePage.clickOnTrendingLink();
        log.info("Click on trending link");
        trendingPage.clickOndropDownLanguage();
        log.info("Click on drop down 'Language'");
        trendingPage.clickOnJavaLanguage();
        log.info("Click on 'Java'");
        trendingPage.clickOndropDownDateRange();
        log.info("Click on drop down 'Date Range'");
        trendingPage.clickOnThisMonth();
        log.info("Click on 'This Month'");
    }

    @Test
    public void matchTrendsTest() {
        trendingPage = new TrendingPage(webDriver, true, TestConfigurations.getTrendingUrl());
        trendingPage.clickOnSpokenLanguageTab()
                .selectEnglishLanguage()
                .clickOnLanguageTab()
                .clickOnJavaLanguage()
                .getTenRepos().forEach(log::info);
        log.info("Count of rus repos = ".concat(String.valueOf(trendingPage.clickOnSpokenLanguageTab()
                .insertInSpokeInput("Russian")
                .selectRussianLanguage()
                .countRusRepos())));
        log.info("Count of arab repos = ".concat(String.valueOf(trendingPage.clickOnSpokenLanguageTab()
                .insertInSpokeInput("Arabic")
                .selectArabianLanguage()
                .clickOnDateRangeTab()
                .selectMonthDateRange()
                .countArabRepos())));
    }
}