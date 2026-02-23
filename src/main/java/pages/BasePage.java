package pages;

import DriverFactory.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
        wait = new WebDriverWait(DriverFactory.Driver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForVisibilityOfElement(WebElement element) {
        wait = new WebDriverWait(DriverFactory.Driver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForInvisibilityOfElement(WebElement element) {
        wait = new WebDriverWait(DriverFactory.Driver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void click(WebElement element) {
        scrollToElement(element);
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

    protected void setFocus(WebElement element) {
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

    protected void selectDropdown(WebElement element, String value) {
        try {
            waitForVisibilityOfElement(element);
            Select select = new Select(element);
            select.selectByVisibleText(value);
            logger.info("Selected option '{}' from dropdown: {}", value, element);
        } catch (StaleElementReferenceException sere) {
            logger.warn("StaleElementReferenceException caught while selecting dropdown. Retrying...", sere);
            WebElement refreshedElement = Driver.getDriver().findElement(By.xpath(getElementXPath(element)));
            waitForVisibilityOfElement(refreshedElement);
            Select select = new Select(refreshedElement);
            select.selectByVisibleText(value);
            logger.info("Selected option '{}' from dropdown after retry: {}", value, refreshedElement);
        } catch (Exception e) {
            throw new RuntimeException("Unable to select option from dropdown: " + e);
        }
    }

    protected long getRandomNumber() {
        return (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    }

    protected void enterAndSelectTheText(WebElement element, String text) {
        try {
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
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));
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
        String formattedDate = null;
        try {
            if (daysToAdd > 0) {
                date = LocalDate.now().plusDays(daysToAdd);
            } else {
                date = LocalDate.now();
            }
            formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

    protected void uploadFileUsingRobot(String fileName) {
        try {
            Robot robot = new Robot();
            robot.delay(5000);

            StringSelection filePath = new StringSelection(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\" + fileName);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException("Failed to upload file using Robot: " + e);
        }
    }

    protected void clearText(WebElement element) {
        try {
            waitForVisibilityOfElement(element);
            element.clear();
            logger.info("Cleared text from element: {}", element);
        } catch (Exception e) {
            throw new RuntimeException("Unable to clear text from element: " + e);
        }
    }

    public void waitForPresenceOfElement(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            logger.info("Element located by {} is present in the DOM.", locator);
        } catch (Exception e) {
            logger.error("Element located by {} was not found within the timeout.", locator, e);
            throw new RuntimeException("Element not found: " + e);
        }
    }

    protected void uploadFileUsingJs(WebElement element, String fileName) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].style.display='block';", element);
            element.sendKeys(System.getProperty("user.dir") + "/src/test/resources/testdata/" + fileName);
            logger.info("Uploaded file '{}' using element: {}", fileName, element);
        } catch (Exception e) {
            logger.error("Failed to upload file '{}' using element: {}", fileName, element, e);
            throw new RuntimeException("Unable to upload file: " + e);
        }
    }

    private String getElementXPath(WebElement element) {
        String jsCode = "function getElementXPath(elt){" +
                "var path = '';" +
                "while(elt.nodeType === Node.ELEMENT_NODE){" +
                "var siblingIndex = 1;" +
                "var sibling = elt.previousSibling;" +
                "while(sibling){" +
                "if(sibling.nodeType === Node.ELEMENT_NODE && sibling.tagName === elt.tagName){" +
                "siblingIndex++;" +
                "}" +
                "sibling = sibling.previousSibling;" +
                "}" +
                "path = '/' + elt.tagName + '[' + siblingIndex + ']' + path;" +
                "elt = elt.parentNode;" +
                "}" +
                "return path.toLowerCase();" +
                "} return getElementXPath(arguments[0]);";
        return (String) ((JavascriptExecutor) Driver.getDriver()).executeScript(jsCode, element);
    }

    public String generateRandomNumber(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            randomString.append(characters.charAt(index));
        }
        logger.info("Generated random string '{}'", randomString);
        return randomString.toString();
    }

    public void selectOptionFromCustomDropdown(WebElement dropdown, String optionText) {
        try {
            click(dropdown);
            WebElement option = Driver.getDriver().findElement(By.xpath("//a[text()='" + optionText + "']"));
            waitForVisibilityOfElement(option);
            click(option);
            logger.info("Selected option '{}' from custom dropdown.", optionText);
        } catch (Exception e) {
            logger.error("Failed to select option '{}' from custom dropdown.", optionText, e);
            throw new RuntimeException("Unable to select option from custom dropdown: " + e);
        }
    }

    protected void selectCustomDate(WebElement datePicker, int daysToAdd) {
        try {
            LocalDate date = daysToAdd > 0 ? LocalDate.now().plusDays(daysToAdd) : LocalDate.now();
            String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            scrollToElement(datePicker);
            click(datePicker);

            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(datePicker)
                    .click()
                    .sendKeys(formattedDate)
                    .perform();

            logger.info("Selected date: {}", formattedDate);
        } catch (Exception e) {
            logger.error("Failed to select date in the date picker.", e);
            throw new RuntimeException("Error while selecting date: " + e);
        }
    }
}
