package pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class LeadsPage extends BasePage {

    /* Locators */
    @FindBy(linkText = "Leads")
    private WebElement leadsMenu;
    @FindBy(xpath = "//button[@class='btn btn-primary o_list_button_add']")
    private WebElement createButton;
    @FindBy(name = "insurance_type")
    private WebElement classOfInsuranceDropdown;
    @FindBy(xpath = "//table[@class='o_group o_inner_group']/tbody/tr/td[4]/select[@class='o_input o_field_widget o_required_modifier']")
    private WebElement typeOfCustomerDropdown;
    @FindBy(xpath = "//div[@class='o_field_widget o_field_many2one o_required_modifier']/div/input")
    private WebElement salesPersonField;
    @FindBy(xpath = "//input[@class='o_datepicker_input o_input datetimepicker-input']")
    private WebElement expectedClosingDateField;
    @FindBy(xpath = "//button[@class='btn btn-primary o_form_button_save']")
    private WebElement saveButton;
    @FindBy(xpath = "//div[@name='partner_id']/div/input")
    private WebElement customerField;
    @FindBy(xpath = "//div[@name='emirate_id']/div/input")
    private WebElement emirateField;
    @FindBy(xpath = "//input[@name='mobile']")
    private WebElement mobileField;
    @FindBy(xpath = "(//div[@name='business_activity_id']/div/input)[last()]")
    private WebElement businessActivityField;
    @FindBy(xpath = "//div[@name='medical_product_type_id']/div/input")
    private WebElement productTypeField;
    @FindBy(xpath = "//a[text()='Documents']")
    private WebElement documentsTab;
    @FindBy(xpath = "//input[@name='next_activity_date']")
    private WebElement followUpDateField;
    @FindBy(name = "fetch_document_list")
    private WebElement fetchDocumentListButton;
    @FindBy(xpath = "(//td[@class='o_list_record_selector']/parent::tr)[1]")
    private WebElement firstDocumentInList;
    @FindBy(xpath = "//td[text()='KYC Documents']")
    private WebElement kycDocumentsRow;
    @FindBy(xpath = "//td[@title='KYC Documents']/following-sibling::td/child::div[@name='document_file_id']//button/following-sibling::input")
    private WebElement uploadFile;
    @FindBy(xpath = "//span[@class='o_attachment_name']")
    private WebElement uploadedFileName;
    @FindBy(xpath = "//a[text()='Census Lines']")
    private WebElement censusLinesTab;
    @FindBy(xpath = "//button[@name='import_medical_census_wizard']")
    private WebElement importCensusLinesButton;
    @FindBy(xpath = "//span[text()='Import']/parent::button")
    private WebElement importButton;
    @FindBy(xpath = "//button[text()='Upload your file']")
    private WebElement uploadYourFileButton;
    @FindBy(xpath = "//span[text()='Import']/parent::button")
    private WebElement importButtonInUploadDialog;
    @FindBy(xpath = "//div[text()='Loading...']")
    private WebElement loadingIndicator;
    @FindBy(xpath = "//td[@title='KYC Documents']/following-sibling::td/child::div[@name='document_file_id']/parent::td")
    private WebElement uploadButtonColumn;
    @FindBy(xpath = "//li[text()='New']")
    private WebElement newTextHeader;
    @FindBy(xpath = "//button[contains(@class,'o_form_button_edit')]")
    private WebElement editButton;
    @FindBy(xpath = "//li[text()='Leads']")
    private WebElement leadsTextHeader;

    /* Methods */
    public void clickLeads() {
        click(leadsMenu);
        waitForVisibilityOfElement(leadsTextHeader);
    }

    public void clickCreateButton() {
        click(createButton);
        waitForVisibilityOfElement(newTextHeader);
    }

    public void selectClassOfInsurance() {
        selectByIndex(classOfInsuranceDropdown, "Medical");
    }

    public void selectTypeOfCustomer() {
        selectByIndex(typeOfCustomerDropdown, "Company");
    }

    public void enterSalesPerson() {
        enterAndSelectTheText(salesPersonField, "Karthika Lakshmi B");
    }

    public void enterExpectedClosingDate() {
        selectDate(expectedClosingDateField, 0);
    }

    public void clickSave() {
        click(saveButton);
        waitForLoadingToDisappear(loadingIndicator);
    }

    public void selectCustomer() {
        enterAndSelectTheText(customerField, "QA Test karthika");
        enterMobileNumber();
    }

    public void enterMobileNumber() {
        if (mobileField.getText() == null) {
            long number = getRandomNumber();
            String vl = String.valueOf(number);
            sendKeys(mobileField, vl);
        }
    }

    public void selectEmirate() {
        enterAndSelectTheText(emirateField, "DUBAI");
    }

    public void selectBusinessActivity() {
        enterAndSelectTheText(businessActivityField, "Construction And Contracting");
    }

    public void selectProductType() {
        enterAndSelectTheText(productTypeField, "SME (HSB & LSB)");
    }

    public void clickDocumentsTab() {
        click(documentsTab);
    }

    public void enterFollowUpDate() {
        selectDate(followUpDateField, 1);
    }

    public void clickFetchDocumentListButton() {
        click(fetchDocumentListButton);
    }

    public void waitTillDocumentIsListed() {
        for (int i = 0; i < 5; i++) {
            try {
                waitForVisibilityOfElement(fetchDocumentListButton);
                click(fetchDocumentListButton);
                waitForVisibilityOfElement(firstDocumentInList);
                scrollToElement(firstDocumentInList);
                if (firstDocumentInList.isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
                throw new RuntimeException("Document is not listed yet: " + e);
            }
        }
    }

    public void uploadKycDocument() {
        scrollToElement(kycDocumentsRow);
        click(uploadButtonColumn);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].style.display='block';", uploadFile);
        sendKeys(uploadFile, System.getProperty("user.dir") + "/src/test/resources/testdata/pdf_testdata.pdf");
        waitForInvisibilityOfElement(uploadFile);
    }

    public void clickEditButton() {
        click(editButton);
    }

    public void clickCensusLinesTab() {
        click(censusLinesTab);
    }

    public void uploadCensusFile() {
        click(importCensusLinesButton);
        waitForVisibilityOfElement(importButton);
        click(uploadYourFileButton);
        uploadFileUsingRobot();
        jsClick(importButton);
    }
}
