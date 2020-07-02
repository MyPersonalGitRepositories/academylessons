package org.academy.endToEnd.tests;

import org.academy.TestConfigurations;
import org.academy.api.requests.ProjectRequests;
import org.academy.utils.web.AbstractWebDriver;
import org.academy.web.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

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
    }

    @Test
    public void createProjectTest() {
        requests.createProject(TestConfigurations.getApiToken(), 201);

        repositoryPage = basePage.goToRepositoryLink();
        projectsPage = repositoryPage.clickOnProjectsLink();
        assertThat(projectsPage.getProjectsAmount()).isEqualTo("1 Open");
        projectEditPage = projectsPage.clickOnDropdown().clickOnEdit();
        projectEditPage.deleteProject();

    }

}
