package org.academy.utils.web;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@Slf4j
public class WebWaiters {
	private static Integer timeForWaiting = 30;


	public static void waitUntilElementIsVisible(WebElement webElement, WebDriver webDriver, int timeOutInSeconds) {
		new WebDriverWait(webDriver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(webElement));
	}

	public static void waitUntilElementIsInvisible(WebElement webElement, WebDriver webDriver) {
		new WebDriverWait(webDriver, timeForWaiting).until(ExpectedConditions.invisibilityOf(webElement));
	}

	public static void waitUntilElementIsPresent(String xpath, WebDriver webDriver, int timeOutInSeconds) {
		new WebDriverWait(webDriver, timeOutInSeconds).until(presenceOfElementLocated(By.xpath(xpath)));
	}

	public static void waitUntilElementIsNotPresent(String xpath, WebDriver webDriver) {
		new WebDriverWait(webDriver, timeForWaiting).until(ExpectedConditions.numberOfElementsToBe(By.xpath(xpath), 0));
	}

	public static void waitUntilAlertPresent(WebDriver driver){
		new WebDriverWait(driver, timeForWaiting).until(ExpectedConditions.alertIsPresent());
	}

	public static void waitUntilElementIsClickable(WebDriver webDriver, WebElement element){
		new WebDriverWait(webDriver, timeForWaiting).until(ExpectedConditions.elementToBeClickable(element));
	}
}
