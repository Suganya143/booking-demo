package com.app.commons;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtils {

	private static WebDriver driver;
	public static String parentWindow = null;

	public static void openPage(String url) {
		driver.get(url);
	}

	public static String getTitle() {
		return driver.getTitle();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setUpDriver(String browser) {
		if (browser == "chrome") {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		}
	}

	public static void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

	public static void explicitWaitTime(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void waitForElementToBeClickable(WebElement locatorElement, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locatorElement));
	}

	public static void switchToChildWindow() {
		parentWindow = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parentWindow.equals(child_window)) {
				driver.switchTo().window(child_window);
			}
		}
	}

	public static void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void enterValueUsingJS(WebElement element, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].value='" + value + "'", element);
		String text = (String) jsExecutor.executeScript("return arguments[0].value", element);  
		System.out.println(text);  
	}
	
	public static void moveToElementAndclick(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	
	public static void switchToIframe(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
}
