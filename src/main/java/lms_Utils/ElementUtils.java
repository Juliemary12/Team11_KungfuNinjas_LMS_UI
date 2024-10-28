package lms_Utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	private WebDriver webDriver;

	public ElementUtils(WebDriver driver) {
		super();
		this.webDriver = driver;
	}

	public WebElement elementWithFluentWaitLocated(By locator, int timeOutInSeconds, int pollingIntervalInMillis) {

		WebElement ele = new FluentWait<WebDriver>(webDriver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingIntervalInMillis)).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return ele;
	}

	public String getAttributeVal(By locator, String attributeName) {
		return elementWithFluentWaitLocated(locator, 10, 100).getAttribute(attributeName);
	}

	public boolean isElementDisplayed(By locator) {
		boolean flag = false;
		try {

			WebElement ele = new WebDriverWait(webDriver, Duration.ofSeconds(30))
					.until(ExpectedConditions.visibilityOf(getElement(locator)));

			if (ele.isDisplayed()) {

				flag = true;
			}

			else {
				throw new Exception("Element is not displayed");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return flag;
	}

	public WebElement getElement(By locator) {
		return webDriver.findElement(locator);
	}

	public void doClick(WebElement ele) {

		try {

			WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(ele));

			if (ele.isDisplayed()) {
				if (ele.isEnabled()) {

					try {

						ele.click();

					} catch (Exception e) {
						// JavascriptExecutor(driver) =
					}

				} else {
					throw new Exception("Element is not enabled");
				}
			} else {
				throw new Exception("Element is not displayed");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void doClick(By locator) {

		try {

			WebElement ele = new WebDriverWait(webDriver, Duration.ofSeconds(30))
					.until(ExpectedConditions.visibilityOf(getElement(locator)));

			if (ele.isDisplayed()) {
				if (ele.isEnabled()) {

					try {

						ele.click();

					} catch (Exception e) {
						// JavascriptExecutor(driver) =
					}

				} else {
					LoggerLoad.error("Element is not enabled");
					throw new Exception("Element is not enabled");
				}
			} else {
				LoggerLoad.error("Element is not displayed");
				throw new Exception("Element is not displayed");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void doSendKeys(By locator, String text) {
		try {

			WebElement ele = new WebDriverWait(webDriver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(getElement(locator)));

			if (ele.isDisplayed()) {
				if (ele.isEnabled()) {

					try {
						ele.click();
						ele.clear();
						clearExistingText(ele);
						ele.sendKeys(text);
					} catch (Exception e) {
					}

				} else {
					throw new Exception("Element is not enabled");
				}
			} else {
				throw new Exception("Element is not displayed");
			}

		} catch (Exception e) {
			// LoggerLoad.error("Exception Happened: "+e.getMessage());
		}

	}

	public void clearExistingText(WebElement ele) {
		ele.sendKeys(Keys.CONTROL);
		ele.sendKeys("A");
		ele.sendKeys(Keys.BACK_SPACE);
	}

	public WebElement elementWithFluentWaitClickable(By locator, int timeOutInSeconds, int pollingIntervalInMillis) {

		WebElement ele = new FluentWait<WebDriver>(webDriver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingIntervalInMillis))
				.ignoring(ElementClickInterceptedException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));

		return ele;
	}

	public List<WebElement> getElements(By locator) {
		return webDriver.findElements(locator);
	}

	public int getElementSize(By locator) {

		int size = 0;
		try {

			List<WebElement> ele = new WebDriverWait(webDriver, Duration.ofSeconds(40))
					.until(ExpectedConditions.visibilityOfAllElements(getElements(locator)));
			size = ele.size();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return size;
	}

	public String getElementText(By locator) {
		elementWithFluentWaitLocated(locator, 10, 100);
		return getElement(locator).getText();
	}
}
