package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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
        testContext.getHomePage().acceptDisclaimerIfPresent();
        testContext.getHomePage().selectDiscuss();
        testContext.getHomePage().clickCrm();
    }
    @When("User starts to create a new lead")
    public void userStartsToCreateANewLead() {
        testContext.getLeadsPage().clickLeads();
        testContext.getLeadsPage().clickCreateButton();
        testContext.getLeadsPage().selectClassOfInsurance();
        testContext.getLeadsPage().selectTypeOfCustomer();
        testContext.getLeadsPage().enterSalesPerson();
        testContext.getLeadsPage().enterExpectedClosingDate();
        testContext.getLeadsPage().enterFollowUpDate();
    }
    @And("User enters the customer information of the lead")
    public void userEntersTheCustomerInformationOfTheLead() {
        testContext.getLeadsPage().selectCustomer();
        testContext.getLeadsPage().selectEmirate();
    }
    @And("User enters the basic information of the lead")
    public void userEntersTheBasicInformationOfTheLead() {
        testContext.getLeadsPage().selectBusinessActivity();
        testContext.getLeadsPage().selectProductType();
        testContext.getLeadsPage().clickSave();
    }

    @And("User uploads the kyc documents in documents tab")
    public void userUploadsTheKycDocumentsInDocumentsTab() {
        testContext.getLeadsPage().clickDocumentsTab();
        testContext.getLeadsPage().clickFetchDocumentListButton();
        testContext.getLeadsPage().waitTillDocumentIsListed();
        testContext.getLeadsPage().clickEditButton();
        testContext.getLeadsPage().uploadKycDocument();
    }

    @And("User imports the census file in census lines tab")
    public void userImportsTheCensusFileInCensusLinesTab() {
        testContext.getLeadsPage().clickCensusLinesTab();
        testContext.getLeadsPage().clickImportButton();
        testContext.getLeadsPage().uploadCensusFile();
    }
}
