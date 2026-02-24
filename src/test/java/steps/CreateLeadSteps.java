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
        testContext.getLeadsPage().enterExpectedPremium();
        testContext.getLeadsPage().enterExpectedRevenue();
        testContext.getLeadsPage().selectUnderwriter();
        testContext.getLeadsPage().enterPolicyExpiryDate();
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
        testContext.getLeadsPage().uploadPaymentReceipt();
    }

    @And("User imports the census file in census lines tab")
    public void userImportsTheCensusFileInCensusLinesTab() {
        testContext.getLeadsPage().clickCensusLinesTab();
        testContext.getLeadsPage().uploadCensusFile();
    }

    @And("User starts the quotation process")
    public void userStartsTheQuotationProcess() {
        testContext.getLeadsPage().clickConvertToOpportunity();
        testContext.getLeadsPage().clickNewQuotation();
        testContext.getQuotePage().completeQuotation();
        testContext.getQuotePage().completeOrderLineDetails();
        testContext.getQuotePage().completeQuotationProcess();
    }

    @And("user proceeds to the direct payment")
    public void userProceedsToTheDirectPayment() {
        testContext.getQuotePage().completeDirectPayment();
    }

    @And("user proceeds the Issue Policy")
    public void userProceedsTheIssuePolicy() {
        testContext.getLeadsPage().clickPolicyMenu();
        testContext.getLeadsPage().clickIssuePolicyButton();
        testContext.getLeadsPage().clickEditButton();
        testContext.getLeadsPage().completePolicyDetails();
        testContext.getLeadsPage().uploadPolicyDocument();
        testContext.getLeadsPage().clickSave();
        testContext.getLeadsPage().clickReconcileButton();
        testContext.getLeadsPage().clickInvoiceButton();
        testContext.getLeadsPage().clickSendButton();
    }
}
