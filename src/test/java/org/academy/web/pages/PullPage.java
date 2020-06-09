package org.academy.web.pages;

import org.academy.TestConfigurations;
import org.academy.web.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

public class PullPage extends AbstractPage {
    public PullPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PullPage (WebDriver webDriver, boolean navigateToPage){super(webDriver, navigateToPage);}

    @FindBy(xpath = "//a[@id='issue_15_link']")
    private WebElement testFileCommitLink;

    @FindBy(xpath = "//a[@href=\"/alhonchar/academylessons/labels\"]")
    private WebElement labelsLink;

    @FindBy(xpath = "//input[@id='js-issues-search']")
    private WebElement SearchBox;

    @FindBy(xpath = "//div[contains(@class,'flex-auto d-none d-lg-block no-wrap')]//a[contains (@href, 'open')]")
    private WebElement OpenRequestsButton;

    @FindAll(@FindBy(xpath = "//div[@role='group']//a[@data-hovercard-type='pull_request']"))
    private List<WebElement> pullRequestList;

    @FindBy(xpath = "//h3[contains(text(),'No results matched your search.')]")
    private WebElement noResult;

    public void searchRequest(String searchText){
        SearchBox.clear();
        SearchBox.sendKeys(searchText);
        SearchBox.sendKeys(Keys.ENTER);
    }

    public String requestsInList(){
        return String.valueOf(pullRequestList.size());

    }

    String commitName = TestConfigurations.getParam("commit");
    private WebElement commitNameLink = webDriver.findElement(By.linkText(commitName));
    public String numberOfRequests(){
        return OpenRequestsButton.getText().replace(" Open", "");
    }

    public boolean isSearchResultEmpty(){
        try{WebElement element = noResult;
            return true;}catch (NoSuchElementException e){
            return false;
        }
    }

    public Pull15Page clickOnTestFileCommitLink() {
        wait.until(ExpectedConditions.elementToBeClickable(testFileCommitLink)).click();
        return new Pull15Page(webDriver);
    }

    public LabelsPage clickOnLabels() {
        labelsLink.click();
        return new LabelsPage(webDriver);
    }
}
