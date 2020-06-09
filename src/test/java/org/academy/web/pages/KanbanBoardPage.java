package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.academy.utils.web.WebHelpers;
import org.academy.utils.web.WebWaiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KanbanBoardPage extends AbstractPage {
    public KanbanBoardPage(WebDriver webDriver) {
        super(webDriver, false);
    }

    @FindBy(xpath = "//article[@id='card-38121666']//div[@class='d-flex flex-justify-between flex-items-center']")
    WebElement issueCardShowDetails;


    @FindBy(xpath = "//article[@id='card-38121666']//a[@data-content-label='pull request']")
    WebElement issueCardRelatedLink;


    @FindBy(xpath = "//span[@class='text-bold js-issue-title']")
    WebElement detailsExternalLink;

    public KanbanBoardPage expandCardDetails(){
        WebWaiters.waitUntilElementIsClickable(webDriver, issueCardShowDetails);
        issueCardShowDetails.click();
        return this;
    }

    public KanbanBoardPage showDetailsFrame(){
        WebWaiters.waitUntilElementIsClickable(webDriver, issueCardRelatedLink);
        issueCardRelatedLink.click();
        return this;
    }

    public Pull15Page goToPull15Page(){
        WebWaiters.waitUntilElementIsClickable(webDriver, detailsExternalLink);
        detailsExternalLink.click();
        WebHelpers.switchToLastOpenedTab(webDriver);
        return new Pull15Page(webDriver);
    }
}
