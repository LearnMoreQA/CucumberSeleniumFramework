package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utils.ConfigReader;
import utils.TestContext;

public class CreateLeadSteps {
    private TestContext testContext;


    public CreateLeadSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("User logs in to the application")
    public void userLogsInToTheApplication() {
        testContext.getLoginPage().enterUsername(ConfigReader.getProperty("username"));
        testContext.getLoginPage().enterPassword(ConfigReader.getProperty("password"));
        testContext.getLoginPage().clickLogin();
    }

    @And("user clicks CRM link in home page")
    public void userClicksOnCrmLink() {
        testContext.getHomePage().selectDiscuss();
        testContext.getHomePage().clickCrm();
    }

    @And("user creates a lead in leads page")
    public void userCreatesALead() {
        testContext.getLeadsPage().clickLeads();
        testContext.getLeadsPage().clickCreateButton();
        testContext.getLeadsPage().selectClassOfInsurance();
        testContext.getLeadsPage().enterSalesPerson();
        testContext.getLeadsPage().selectTypeOfCustomer();
        testContext.getLeadsPage().selectExpectedClosing();
        testContext.getLeadsPage().selectCustomer();
        testContext.getLeadsPage().vehicleMake();
        testContext.getLeadsPage().clickSave();
        String leadNumber = testContext.getLeadsPage().getLeadNumber();
        testContext.getLeadsPage().clickLeads();
        testContext.getLeadPiple().searchLead(leadNumber);
        testContext.getLeadPiple().clickSearchLead();
    }


}
