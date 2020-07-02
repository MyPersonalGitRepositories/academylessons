package org.academy.endToEnd.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.TestConfigurations;
import org.academy.api.requests.ProjectRequests;
import org.academy.utils.web.AbstractWebDriver;
import org.academy.web.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Slf4j
public class ProjectTest extends AbstractWebDriver {

    private ProjectRequests requests;
    private BasePage basePage;
    private LoginPage loginPage;
    private RepositoryPage repositoryPage;
    private ProjectsPage projectsPage;
    private ProjectEditPage projectEditPage;

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        requests = new ProjectRequests();
        loginPage = new LoginPage(webDriver, true);
        basePage = loginPage.login();
        log.info("Logged in");
    }

    @Test
    public void createProjectTest() {
        requests.createProject(TestConfigurations.getApiToken(), 201);
        log.info("Project has been created");

        repositoryPage = basePage.goToRepositoryLink();
        projectsPage = repositoryPage.clickOnProjectsLink();
        log.info("Check whether new project exists");
        assertThat(projectsPage.isExist(TestConfigurations.getProject())).isTrue();
        projectEditPage = projectsPage
                .clickOnDropdown()
                .clickOnEdit();
        projectEditPage.deleteProject();
        log.info("Project has been deleted");
    }

}
