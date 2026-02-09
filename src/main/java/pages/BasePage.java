package pages;

import DriverFactory.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(BasePage.class);

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    protected void waitForClickable(WebElement element) {
        wait = new WebDriverWait(DriverFactory.Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForVisibilityOfElement(WebElement element) {
        wait = new WebDriverWait(DriverFactory.Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(WebElement element) {
        try {
            waitForClickable(element);
            element.click();
            logger.info("Clicked on element: {}", element);
        } catch (Exception e) {
            logger.error("Failed to click on element: {}", element, e);
            throw new RuntimeException("Unable to clicking element: " + e);
        }
    }

    protected void jsClick(WebElement element) {
        try {
            waitForClickable(element);
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].click();", element);
            logger.info("Clicked on element using JavaScript: {}", element);
        } catch (Exception e) {
            logger.error("Failed to click on element using JavaScript: {}", element, e);
            throw new RuntimeException("Unable to clicking element using JavaScript: " + e);
        }
    }

    protected void sendKeys(WebElement element, String text) {
        try {
            waitForVisibilityOfElement(element);
            element.sendKeys(text);
            logger.info("Sent keys '{}' to element: {}", text, element);
        } catch (Exception e) {
            throw new RuntimeException("Unable to send keys to element: " + e);
        }
    }

    protected String getText(WebElement element) {
        try {
            waitForVisibilityOfElement(element);
            String text = element.getText();
            logger.info("Retrieved text '{}' from element: {}", text, element);
            return text;
        } catch (Exception e) {
            throw new RuntimeException("Unable to get text from element: " + e);
        }
    }

    protected void selectByIndex(WebElement element, int index) {
        try {
            waitForVisibilityOfElement(element);
            Select select = new org.openqa.selenium.support.ui.Select(element);
            select.selectByIndex(index);
            logger.info("Selected option at index {} from dropdown: {}", index, element);
        } catch (Exception e) {
            throw new RuntimeException("Unable to select option by index from dropdown: " + e);
        }
    }

    protected long getRandomNumber() {
        return (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    }

    protected void fluntWaitForPresenceOfElement(String locator) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        wait.ignoring(NoSuchElementException.class);
    }
}
