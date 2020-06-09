package org.academy.web.pages;

import org.academy.TestConfigurations;
import org.academy.web.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends AbstractPage {

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }


    public BasePage(WebDriver webDriver, boolean navigateToPage) {
        super(webDriver, navigateToPage);
    }

    @FindBy(xpath = "//a[contains(text(),'Issues')]")
    private WebElement issuesLink;

    @FindBy(xpath = "//a[@class='js-selected-navigation-item Header-link py-lg-3 d-inline-block'][contains(text(), 'Marketplace')]")
    private WebElement marketplaceBtn;

    @FindBy(xpath = "//a[(@href='/alhonchar/academylessons')]")
    private List<WebElement> repositoryLinks;

    @FindBy(xpath = "//div[@id='dashboard-repos-container']//div[@class='width-full text-bold']")
    private WebElement repositoryLink;

    @FindBy(xpath = "//a[@class='btn btn-sm empty-icon float-right BtnGroup-item']")
    private WebElement findFileButton;

    @FindBy(xpath = "//a[contains(text(),'Explore')]")
    private WebElement exploreLink;


    public IssuesPage clickOnIssuesLink() {
        issuesLink.click();
        return new IssuesPage(webDriver, true, TestConfigurations.getIssuesUrl());
    }

    private WebElement toRepositoryLink = webDriver.findElement(By.xpath("//div[@id='dashboard-repos-container']"
            + "//span[@class='css-truncate css-truncate-target'][contains(text(),'"
            + TestConfigurations.getParam("repository") + "')]"));


    public RepositoryPage clickOnAcademyLessonsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(repositoryLinks.get(0))).click();
        return new RepositoryPage(webDriver);
    }

    public RepositoryPage goToRepositoryLink() {
        toRepositoryLink.click();
        return new RepositoryPage(webDriver);
    }

    public MarketplacePage clickOnMarket() {
        marketplaceBtn.click();
        return new MarketplacePage(webDriver);
    }


    public CodePage clickOnRepositoryLink() {
        repositoryLink.click();
        return new CodePage(webDriver);
    }

    public CodePage clickOnFindFile() {
        findFileButton.click();
        return new CodePage(webDriver);
    }


    public ExplorePage clickOnExploreLink() {
        exploreLink.click();
        return new ExplorePage(webDriver);
    }


}

