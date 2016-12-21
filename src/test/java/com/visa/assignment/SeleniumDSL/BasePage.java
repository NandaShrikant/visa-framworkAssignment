package com.visa.assignment.SeleniumDSL;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.Scenario;
import com.visa.assignment.Utils.Log;

public class BasePage {

	protected WebDriver driver;
	protected static String noData = "<<>>";

	@SuppressWarnings("unchecked")
	public BasePage(WebDriver driver, @SuppressWarnings("rawtypes") Class aClass) {
		this.driver = driver;
		PageFactory.initElements(driver, aClass);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void close() {
		Log.info("closing Browser");
		driver.quit();
	}

	public void checkPageIsReady(int loopCount) {
		Log.info("checking webpage is ready");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			return;
		}

		// This loop will rotate for specified number of times to check if page
		// is ready after every 1 second.
		for (int i = 0; i < loopCount; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}

	}

	public void validatePageTitleEquals(String text) {
		Assert.assertTrue("Text Not Found : " + text, driver.getTitle().equalsIgnoreCase(text));
	}

	public void grabScreenshot(WebDriver driver, Scenario scenario) {

		try {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

			scenario.embed(screenshot, "image/png");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void setTimeout(int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public String getText(WebElement element) {
		Log.info("getting text from a webelement");
		return element.getText();
	}

	public void enterText(WebElement element, String val) {
		Log.info("entering the text = " + val);
		waitElementLocated(element, 60);
		element.sendKeys(val);
	}

	public void click(WebElement element) {
		Log.info("clicking on a element");
		waitElementLocated(element, 60);
		element.click();
	}

	public void click(WebElement element, int waitseconds) {
		Log.info("clicking on a element with wait");
		waitElementLocated(element, 60);
		element.click();
	}

	public void performActionsClick(WebElement parentElement, WebElement childElement) {
		Actions action = new Actions(driver);
		action.moveToElement(parentElement).build().perform();
		click(childElement);
	}

	public void moveActionsElement(WebElement parentElement) {
		Actions action = new Actions(driver);
		action.moveToElement(parentElement).build().perform();
	}

	public WebElement getElementByXpath(String xpath, int currentSize) {
		return driver.findElement(By.xpath(xpath + "[" + (currentSize + 1) + "]"));
	}

	public void validateElementTextContains(WebElement element, String text) {
		Assert.assertTrue("Text Not Found : " + text,
				getText(element).replaceAll("(\\r|\\n)", "").contains(text.replaceAll("(\\r|\\n)", "")));
	}

	public void validateElementTextEquals(WebElement element, String text) {
		Assert.assertTrue("Text Not Found : " + text, getText(element).equalsIgnoreCase(text));
	}

	public void validateElementVisible(WebElement element, String Fieldname) {
		Assert.assertTrue("Field Not Visible : " + Fieldname, element.isDisplayed());
	}

	public void validateElementEnabled(WebElement element, String Fieldname) {
		Assert.assertTrue("Field Not Enabled : " + Fieldname, element.isEnabled());
	}

	public void validateElementExists(List<WebElement> elements, String Fieldname) {
		Assert.assertTrue("Field Does Not Exist : " + Fieldname, elements.size() > 0);
	}

	public void assertFail(String message) {
		Assert.fail(message);
		;
	}

	public boolean waitElementLocated(WebElement element, int timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void waitElementLocated(By locator, int timeOutInSeconds) {
		WebElement myDynamicElement = (new WebDriverWait(driver, timeOutInSeconds))
				.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public void waitPageTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.titleContains(title));
	}

	public Boolean waitTextPresentInElement(WebElement element, String val, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		return wait.until(ExpectedConditions.textToBePresentInElement(element, val));
	}

}
