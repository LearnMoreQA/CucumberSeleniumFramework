package utils;

import DriverFactory.Driver;
import pages.HomePage;
import pages.LeadsPage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class TestContext {
    private final LoginPage loginPage;
    private final HomePage homePage;
    private final LeadsPage leadsPage;

    public TestContext() {
        this.loginPage = new LoginPage();
        this.homePage = new HomePage();
        this.leadsPage = new LeadsPage();
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
