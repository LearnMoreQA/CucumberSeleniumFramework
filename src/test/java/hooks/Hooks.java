package hooks;

import DriverFactory.Driver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;

import java.time.Duration;

import static DriverFactory.Driver.getDriver;

public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @Before
    public void setUp() {
        getDriver();
        getDriver().manage().window().maximize();
        String appUrl = ConfigReader.getProperty("app.url");
        getDriver().get(appUrl);
        logger.info("Navigated to Application URL: {}", appUrl);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        logger.info("Driver initialized and configured for scenario");
    }

    @AfterStep
    public void attachScreenshot(Scenario scenario){
            byte[] src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", null);
    }

    @AfterAll
    public static void tearDownAll() {
        Driver.quitDriver();
        logger.info("All scenarios completed");
    }
}

