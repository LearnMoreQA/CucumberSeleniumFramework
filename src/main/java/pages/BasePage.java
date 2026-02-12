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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
            waitForVisibilityOfElement(element);
            waitForClickable(element);
            element.click();
            logger.info("Clicked on element: {}", element);
        } catch (Exception e) {
            logger.error("Failed to click on element: {}", element, e);
            throw new RuntimeException("Unable to clicking element: " + e);
        }
    }

    private void setFocus(WebElement element){
        try {
            waitForVisibilityOfElement(element);
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].focus();", element);
            logger.info("Set focus on element using JavaScript: {}", element);
        } catch (Exception e) {
            logger.error("Failed to set focus on element using JavaScript: {}", element, e);
            throw new RuntimeException("Unable to set focus on element using JavaScript: " + e);
        }
    }

    protected void jsClick(WebElement element) {
        try {
            setFocus(element);
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

    protected void selectByIndex(WebElement element, String value) {
        try {
            waitForVisibilityOfElement(element);
            Select select = new org.openqa.selenium.support.ui.Select(element);
            select.selectByVisibleText(value);
            logger.info("Selected option '{}' from dropdown: {}", value, element);
        } catch (Exception e) {
            throw new RuntimeException("Unable to select option from dropdown: " + e);
        }
    }

    protected long getRandomNumber() {
        return (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    }

    protected void enterAndSelectTheText(WebElement element, String text){
        try{
            waitForVisibilityOfElement(element);
            sendKeys(element, text);
            WebElement ele = Driver.getDriver().findElement(By.xpath("//a[contains(text(),'" + text + "')]"));
            waitForVisibilityOfElement(ele);
            click(ele);
            logger.info("Entered text and selected the expected option '{}'", text);
        } catch (Exception e) {
            throw new RuntimeException("Unable to enter and select the text: " + e);
        }
    }

    protected void waitForLoadingToDisappear(WebElement loadingIndicator) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.invisibilityOf(loadingIndicator));
            logger.info("Loading spinner has disappeared.");
        } catch (Exception e) {
            logger.error("Loading spinner did not disappear within the timeout.", e);
            throw new RuntimeException("Loading spinner is still visible after waiting: " + e);
        }
    }

    protected void selectDate(WebElement datePicker, int daysToAdd) {
        LocalDate date;
        scrollToElement(datePicker);
        try {
            if(daysToAdd > 0) {
                 date = LocalDate.now().plusDays(daysToAdd);
            } else {
                date = LocalDate.now();
            }
            String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            click(datePicker);
            datePicker.clear();
            sendKeys(datePicker, formattedDate);
            logger.info("Selected date: {}", formattedDate);
        } catch (Exception e) {
            logger.error("Failed to select date in the date picker.", e);
            throw new RuntimeException("Error while selecting date: " + e);
        }
    }

    protected void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
            logger.info("Scrolled to element: {}", element);
        } catch (Exception e) {
            logger.error("Failed to scroll to element: {}", element, e);
            throw new RuntimeException("Unable to scroll to element: " + e);
        }
    }
}
