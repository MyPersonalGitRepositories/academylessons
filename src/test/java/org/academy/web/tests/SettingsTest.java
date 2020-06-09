package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.TestConfigurations;
import org.academy.utils.web.AbstractWebDriver;
import org.academy.web.pages.BasePage;
import org.academy.web.pages.LoginPage;
import org.academy.web.pages.MainPage;
import org.academy.web.pages.RepositoryPage;
import org.academy.web.pages.SettingsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SettingsTest extends AbstractWebDriver {
    private MainPage mainPage;
    private LoginPage loginPage;
    private BasePage basePage;
    private RepositoryPage repositoryPage;
    private SettingsPage settingsPage;

    public SettingsTest() {
        super();
    }

    @BeforeClass
    public void precondition1() {
        mainPage = new MainPage(webDriver, true, TestConfigurations.getUrl());
        loginPage = mainPage.clickOnSignIn();
        basePage = loginPage.login();
        repositoryPage = basePage.goToRepositoryLink();
        settingsPage = repositoryPage.clickOnSettingsLink();
        settingsPage.goToManageAccess();
    }

    @BeforeMethod(onlyForGroups = {"g2"}, alwaysRun = false)
    public void precondition() {
        settingsPage.inviteCollaborator();
    }

    @DataProvider(name = "collaborator form provider")
    public Object[][] dataProviderAuthUserType() {
        return new Object[][]{
                {"alhonchar"},
                {"with spaces"},
                {"     "},
        };
    }

    @Test(dataProvider = "collaborator form provider", groups = {"g2"})
    public void negativeAddCollaborationTest(String collaborator) {
        settingsPage.searchCollaborator(collaborator);
        String error = settingsPage.getErrorMessage();
        assertThat(error).as("Unfound collaborator").contains("Select a collaborator above");
        settingsPage.inviteCollaborator();
    }

    @Test(groups = {"g2"})
    public void positiveAddCollaborationTest() {
        settingsPage.searchCollaborator(TestConfigurations.getCollaborator());
        settingsPage.clickAddCollaboratorButton();
        String collaboratorLogin = settingsPage.findCollaborator(TestConfigurations.getCollaborator());
        assertThat(collaboratorLogin).as("Collaborator is found").isEqualTo(TestConfigurations.getCollaborator());
    }

    @Test(groups = {"g1"}, priority = 5)
    public void collaborationDeleteTest() {
        settingsPage.deleteCollaborator();
        String noCollaboratorMessage = settingsPage.noInvitedCollaboratorsMessage();
        assertThat(noCollaboratorMessage).contains("You haven't invited any collaborators yet");
    }
}

