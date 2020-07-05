package org.academy.endToEnd.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.academy.TestConfigurations;
import org.academy.api.pojo.Project;
import org.academy.api.requests.ProjectRequests;
import org.academy.utils.web.AbstractWebDriver;
import org.academy.web.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Slf4j
public class ProjectTest extends AbstractWebDriver {

    private ProjectRequests requests;
    private MainPage mainPage;
    private BasePage basePage;
    private LoginPage loginPage;
    private RepositoryPage repositoryPage;
    private ProjectsPage projectsPage;
    private ProjectEditPage projectEditPage;

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        requests = new ProjectRequests();
        mainPage = new MainPage(webDriver, true, TestConfigurations.getUrl());
        loginPage = mainPage.clickOnSignIn();
        basePage = loginPage.login();
        log.info("Logged in");
    }

    @Test
    public void createProjectTest() {
        String projectName = TestConfigurations.getProject();
        String projectBody = TestConfigurations.getProjectBody();
        Project project = new Project(projectName, projectBody);
        ObjectMapper mapper = new ObjectMapper();
        String body = null;
        try {
            body = mapper.writeValueAsString(project);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        requests.createProject(TestConfigurations.getApiToken(), body, 201);
        log.info("Project has been created");

        repositoryPage = basePage.goToRepositoryLink();
        projectsPage = repositoryPage.clickOnProjectsLink();
        log.info("Check whether new project exists");
        assertThat(projectsPage.isExist(projectName)).isTrue();
        projectEditPage = projectsPage
                .clickOnDropdown()
                .clickOnEdit();
        projectEditPage.deleteProject();
        log.info("Project has been deleted");
    }

}
