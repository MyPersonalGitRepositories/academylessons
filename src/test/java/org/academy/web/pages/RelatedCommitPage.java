package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.academy.utils.web.WebWaiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RelatedCommitPage extends AbstractPage {

    public RelatedCommitPage(WebDriver webDriver) {
            super(webDriver, false);
        }
    @FindBy(xpath = "(//div[class='text-right'])[1]")
    private WebElement shortShaLink;

    public CommitPage goToTestFileCommitPage(){
        WebWaiters.waitUntilElementIsClickable(webDriver, shortShaLink);
        shortShaLink.click();
        return new CommitPage(webDriver);
    }
}
