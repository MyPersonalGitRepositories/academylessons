package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.TestConfigurations;
import org.academy.web.pages.BasePage;
import org.academy.web.pages.CodePage;
import org.academy.utils.web.AbstractWebDriver;
import org.academy.web.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class SearchFileTest extends AbstractWebDriver {
    private LoginPage loginPage;
    private BasePage basePage;
    private CodePage codePage;

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        loginPage = new LoginPage(webDriver, true);
        basePage = loginPage.login();
        log.info("Logged in");
    }

    @Test(description = "Find and read file contents")
    public void fileContentTest() {
        basePage.clickOnRepositoryLink();
        log.info("Click on repository link ");
        codePage = basePage.clickOnFindFile();
        log.info("Click on button 'Find File'");
        codePage.fillNameFile(TestConfigurations.getFile());
        log.info("Enter 'log4j.properties'");
        codePage.clickOnFile();
        log.info("Click on file 'log4j.properties'");
        String text = codePage.getFileContent();
        log.info("Get file content");
        Assert.assertTrue(text.contains("log4j.rootCategory=DEBUG, stdout, file"));
        log.info("File contains 'log4j.rootCategory=DEBUG, stdout, file'");
    }
}