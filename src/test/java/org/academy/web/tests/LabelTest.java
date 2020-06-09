package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.utils.web.AbstractWebDriver;
import org.academy.utils.web.WebHelpers;
import org.academy.web.pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Slf4j
public class LabelTest extends AbstractWebDriver {
    private BasePage basePage;
    private LoginPage loginPage;
    private RepositoryPage repositoryPage;
    private PullPage pullPage;
    private LabelsPage labelsPage;

    @BeforeClass(alwaysRun = true)
    public void precondition() {
        log.info("Start 'LabelTest'");
        loginPage = new LoginPage(webDriver, true);
        basePage = loginPage.login();
        log.info("Logged in");
        log.info("Launching repository page");
        repositoryPage = basePage.goToRepositoryLink();
        pullPage = repositoryPage.clickOnPullRequestsTab();
        labelsPage = pullPage.clickOnLabels();
        log.info("Launched labels page");
    }


    @Test
    public void addAndDeleteTest() {
        int labels;
        labels = labelsPage.getLabelsAmount();
        log.info("Labels amount:" + labels);
        labelsPage.addNewLabel();
        log.info("Added new label");
        WebHelpers.refreshPage(webDriver);
        WebHelpers.refreshPage(webDriver);
        assertThat(labels).isNotEqualTo(labelsPage.getLabelsAmount());
        log.info("Check whether label amount has been changed");
        labelsPage.deleteLabel();
        log.info("Deleted label");
        WebHelpers.refreshPage(webDriver);
        WebHelpers.refreshPage(webDriver);
        assertThat(labels).isEqualTo(labelsPage.getLabelsAmount());
        log.info("Check whether label has been deleted");
        WebHelpers.refreshPage(webDriver);
    }

}
