package utils;

import DriverFactory.Driver;
import pages.HomePage;
import pages.LeadsPage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import pages.QuotePage;

public class TestContext {
    private final LoginPage loginPage;
    private final HomePage homePage;
    private final LeadsPage leadsPage;
    private final QuotePage quotePage;

    public TestContext() {
        this.loginPage = new LoginPage();
        this.homePage = new HomePage();
        this.leadsPage = new LeadsPage();
        this.quotePage = new QuotePage();
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

    public QuotePage getQuotePage() {
        return quotePage;
    }
}
