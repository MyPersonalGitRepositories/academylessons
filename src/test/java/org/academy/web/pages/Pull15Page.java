package org.academy.web.pages;

import org.academy.TestConfigurations;
import org.academy.web.AbstractPage;
import org.academy.utils.web.WebWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Pull15Page extends AbstractPage {
    public Pull15Page(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@href=\"/alhonchar/academylessons/pull/15/commits\"]")
    private WebElement commitsLink;

    String commitName = TestConfigurations.getParam("commit");
    private WebElement commitNameLink = webDriver.findElement(By.xpath("//a[@title='"+commitName+"']"));



    public CommitPage clickOnCommitsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(commitsLink)).click();
        return new CommitPage(webDriver);
    }

    public CommitPage goToCommitPage() {
        WebWaiters.waitUntilElementIsVisible(commitNameLink, webDriver, 10);
        commitNameLink.click();
        return new CommitPage(webDriver);
    }
}
