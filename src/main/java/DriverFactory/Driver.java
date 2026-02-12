package DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

public class Driver {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(Driver.class);

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
          String browser = ConfigReader.getProperty("browser");
            if(browser.equalsIgnoreCase("Chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-application-cache");
                options.addArguments("--incognito");
               System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                logger.info("ChromeDriver initialized successfully");
            } else if (browser.equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                logger.info("FirefoxDriver initialized successfully");
            } else if(browser.equalsIgnoreCase("Edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                logger.info("EdgeDriver initialized successfully");
            }else {
                logger.error("Unsupported browser specified: {}", browser);
                throw new RuntimeException("Unsupported browser: " + browser);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            logger.info("WebDriver quit successfully");
        }
    }
}
