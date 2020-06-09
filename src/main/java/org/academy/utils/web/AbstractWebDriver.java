package org.academy.utils.web;

import org.academy.tools.TestNgListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(TestNgListener.class)
public abstract class AbstractWebDriver {
    public static WebDriver webDriver;

    @BeforeClass(alwaysRun = true)
    public void openDriver() {
        webDriver = LocalWebDriverManager.getWebDriver();
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        webDriver.quit();
    }
}
