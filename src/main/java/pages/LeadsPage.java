package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsPage extends BasePage {

    /* Locators */
    @FindBy(linkText = "Leads")
    private WebElement leadsMenu;
    @FindBy(xpath = "//button[@class='btn btn-primary o_list_button_add']")
    private WebElement createButton;
    @FindBy(xpath = "(//select[@class='o_input o_field_widget o_required_modifier'])[1]")
    private WebElement classOfInsuranceDropdown;
    @FindBy(xpath = "//table[@class='o_group o_inner_group']/tbody/tr/td[4]/select[@class='o_input o_field_widget o_required_modifier']")
    private WebElement typeOfCustomerDropdown;
    @FindBy(xpath = "//div[@class='o_field_widget o_field_many2one o_required_modifier']/div/input")
    private WebElement salesPersonField;
    @FindBy(xpath = "//ul[@id='ui-id-2']/li/a")
    private WebElement salesPersonOption;
    @FindBy(xpath = "//input[@class='o_datepicker_input o_input datetimepicker-input']")
    private WebElement expectedClosingDateField;
    @FindBy(xpath = "//button[@class='btn btn-primary o_form_button_save']")
    private WebElement saveButton;
    @FindBy(xpath = "//div[@name='partner_id']/div/input")
    private WebElement customerField;
    @FindBy(xpath = "//a[text()='[C232298] QA Test karthika']")
    private WebElement customerOption;
    @FindBy(xpath = "//input[@name='mobile']")
    private WebElement mobileField;
    @FindBy(xpath = "//div[@name='make_id']/div/input")
    private WebElement makeField;
    @FindBy(xpath = "//a[text()='CADILLAC']")
    private WebElement makeOption;
    @FindBy(xpath = "//li[@class='breadcrumb-item active']")
    private WebElement leadNumberField;


    /* Methods */

    public void clickLeads() {
        click(leadsMenu);
    }

    public void clickCreateButton() {
        jsClick(createButton);
    }

    public void selectClassOfInsurance() {
        selectByIndex(classOfInsuranceDropdown, 1);
    }

    public void selectTypeOfCustomer() {
        selectByIndex(typeOfCustomerDropdown, 1);
    }

    public void enterSalesPerson() {
        click(salesPersonField);
        click(salesPersonOption);
    }

    public void selectExpectedClosing() {
        sendKeys(expectedClosingDateField, "05/02/2026");
    }

    public void clickSave() {
        click(saveButton);
    }

    public void selectCustomer() {
        click(customerField);
        click(customerOption);
        long number = getRandomNumber();
        String vl = String.valueOf(number);
        sendKeys(mobileField, vl);
    }

    public void vehicleMake() {
        click(makeField);
        click(makeOption);
    }

    public String getLeadNumber() {
        fluntWaitForPresenceOfElement("//span[text()='Print']");
        String leadNumber = getText(leadNumberField);
        return leadNumber;
    }

}
