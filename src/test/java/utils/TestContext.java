package utils;

import DriverFactory.Driver;
import pages.HomePage;
import pages.LeadPipeline;
import pages.LeadsPage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class TestContext {
    private final WebDriver driver;
    private final LoginPage loginPage;
    private final HomePage homePage;
    private final LeadsPage leadsPage;

    private final LeadPipeline leadPipeline;

    public TestContext() {
        this.driver = Driver.getDriver();
        this.loginPage = new LoginPage();
        this.homePage = new HomePage();
        this.leadsPage = new LeadsPage();
        this.leadPipeline = new LeadPipeline();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public LeadsPage getLeadsPage() {
        return leadsPage;
    }
}
