package pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    private WebElement kycUploadFile;
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
    @FindBy(xpath = "//span[text()='Convert to Opportunity']/parent::button")
    private WebElement convertToOpportunityButton;
    @FindBy(xpath = "//span[text()='New Quotation']/parent::button")
    private WebElement newQuotationButton;
    @FindBy(xpath = "//input[@name='expected_premium']")
    private WebElement expectedPremiumField;
    @FindBy(xpath = "//input[@name='expected_revenue']")
    private WebElement expectedRevenueField;
    @FindBy(xpath = "//div[@name='underwriter_id']/child::div/input")
    private WebElement underwriterField;
    @FindBy(xpath = "//input[@name='policy_expiry_date']")
    private WebElement policyExpiryDateField;
    @FindBy(name = "payment_type")
    private WebElement paymentTypeDropdown;
    @FindBy(xpath = "//div[@name='payment_term_id']/child::div/input")
    private WebElement paymentTermField;
    @FindBy(name = "quote_from_ai")
    private WebElement quoteFromAIDropdown;
    @FindBy(xpath = "//a[text()='Add a section']/preceding-sibling::a[text()='Add a product']")
    private WebElement addProductButton;
    @FindBy(xpath = "//div[@name='insurer_id']/child::div/input")
    private WebElement insurerField;
    @FindBy(xpath = "//div[@name='product_id']/child::div/input")
    private WebElement productField;
    @FindBy(xpath = "//div[@name='category_id']/child::div/input")
    private WebElement categoryField;
    @FindBy(xpath = "//span[text()='Save & Close']/parent::button")
    private WebElement saveAndCloseButton;
    @FindBy(xpath = "//span[text()='Confirm Quotation']/parent::button")
    private WebElement confirmQuotationButton;
    @FindBy(xpath = "//button[@name='do_confirm_sale_order']")
    private WebElement confirmOrderButton;
    @FindBy(xpath = "//label[text()='Operation Type']")
    private WebElement operationTypeLabel;
    @FindBy(xpath = "//h4[text()='Confirmation']")
    private WebElement confirmationPopupHeader;
    @FindBy(xpath = "//span[text()='Ok']/parent::button")
    private WebElement confirmationPopupOkButton;
    @FindBy(xpath = "//a[text()='Other Info']")
    private WebElement otherInfoTab;
    @FindBy(xpath = "//a[text()='Order Lines']")
    private WebElement orderLinesTab;
    @FindBy(xpath = "//span[text()='Direct']/parent::button")
    private WebElement directButton;
    @FindBy(xpath = "//div[@name='attachment_type_id']/child::div/input")
    private WebElement attachmentTypeDropdown;
    @FindBy(xpath = "//div[text()='Direct Payment Details']")
    private WebElement directPaymentDetailsSection;
    @FindBy(xpath = "//div[text()='Direct Payment Details']/following::span[text()='Confirm']/parent::button")
    private WebElement confirmDirectPaymentButton;
    @FindBy(xpath = "(//a[text()='Add a line'])[4]")
    private WebElement addPaymentLineButton;
    @FindBy(xpath = "//div[@name='document_id']/child::div/input")
    private WebElement documentDropdown;
    @FindBy(xpath = "//li[@class='breadcrumb-item active']")
    private WebElement breadcrumb;
    @FindBy(xpath = "//span[text()='Policy']/parent::div")
    private WebElement policyMenu;
    @FindBy(xpath = "//span[text()='Issue Policy']/parent::button")
    private WebElement issuePolicyButton;
    @FindBy(xpath = "//span[text()='Reconcile']/parent::button")
    private WebElement reconcileButton;
    @FindBy(name = "policy_number")
    private WebElement policyNumberField;
    @FindBy(name = "start_date")
    private WebElement policyStartDateField;
    @FindBy(name = "end_date")
    private WebElement policyEndDateField;
    @FindBy(name = "invoice_number")
    private WebElement invoiceNumberField;
    @FindBy(name = "invoice_date")
    private WebElement invoiceDateField;
    @FindBy(xpath = "//div[@name='sale_support_uw_id']/child::div/input")
    private WebElement saleSupportUnderwriterField;
    @FindBy(xpath = "//div[@name='closing_document_ids']/preceding::a[text()='Add a line']")
    private WebElement policyDocAddButton;
    @FindBy(xpath = "//button[contains(@class,'o_upload_button')]/following-sibling::input")
    private WebElement policyDocUploadFileButton;
    @FindBy(xpath = "//span[text()='Invoice']/parent::button")
    private WebElement invoiceButton;
    @FindBy(xpath = "//span[text()='Send']/parent::button")
    private WebElement sendButton;

    /* Methods */
    public void clickLeads() {
        click(leadsMenu);
        waitForVisibilityOfElement(leadsTextHeader);
    }

    public void clickCreateButton() {
        click(createButton);
        waitForVisibilityOfElement(newTextHeader);
        waitForLoadingToDisappear(loadingIndicator);
    }

    public void selectClassOfInsurance() {
        waitForLoadingToDisappear(loadingIndicator);
        selectDropdown(classOfInsuranceDropdown, "Medical");
    }

    public void selectTypeOfCustomer() {
        selectDropdown(typeOfCustomerDropdown, "Company");
    }

    public void enterSalesPerson() {
        enterAndSelectTheText(salesPersonField, "Karthika Lakshmi B");
    }

    public void enterExpectedClosingDate() {
        selectDate(expectedClosingDateField, 0);
    }

    public void clickSave() {
        waitForLoadingToDisappear(loadingIndicator);
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
        uploadFileUsingJs(kycUploadFile, "pdf_testdata.pdf");
        waitForInvisibilityOfElement(kycUploadFile);
    }

    public void clickEditButton() {
        click(editButton);
        waitForLoadingToDisappear(loadingIndicator);
    }

    public void clickCensusLinesTab() {
        click(censusLinesTab);
    }

    public void uploadCensusFile() {
        click(importCensusLinesButton);
        waitForVisibilityOfElement(importButton);
        click(uploadYourFileButton);
        uploadFileUsingRobot("census_testdata.xlsx");
        waitForVisibilityOfElement(importButton);
        click(importButton);
        waitForInvisibilityOfElement(importButton);
    }

    public void selectUnderwriter() {
        enterAndSelectTheText(underwriterField, "ADHIL SHAFI");
    }

    public void enterPolicyExpiryDate() {
        selectDate(policyExpiryDateField, 30);
    }
    public void enterExpectedPremium() {
        clearText(expectedPremiumField);
        sendKeys(expectedPremiumField, "1.00");
    }
    public void enterExpectedRevenue() {
        clearText(expectedRevenueField);
        sendKeys(expectedRevenueField, "1.00");
    }
    public void clickConvertToOpportunity() {
        click(convertToOpportunityButton);
    }
    public void clickNewQuotation() {
        waitForLoadingToDisappear(loadingIndicator);
        click(newQuotationButton);
    }
    public void clickAddProduct() {
        click(addProductButton);
    }
    public void selectPaymentType(String value) {
        selectDropdown(paymentTypeDropdown, value);
    }
    public void enterPaymentTerm(String value) {
        enterAndSelectTheText(paymentTermField, value);
    }
    public void selectQuoteFromAI(String value) {
        selectDropdown(quoteFromAIDropdown, value);
    }
    public void selectInsurer(String insurer) {
        enterAndSelectTheText(insurerField, insurer);
    }
    public void selectProduct(String product) {
        enterAndSelectTheText(productField, product);
    }
    public void selectCategory(String category) {
        selectOptionFromCustomDropdown(categoryField, category);
    }
    public void clickOtherInfoTab() {
        click(otherInfoTab);
    }
    public void clickSaveAndCloseButton() {
        click(saveAndCloseButton);
        waitForInvisibilityOfElement(saveAndCloseButton);
        waitForLoadingToDisappear(loadingIndicator);
    }
    public void completeQuotation() {
        waitForLoadingToDisappear(loadingIndicator);
        selectPaymentType("Direct");
        enterPaymentTerm("Immediate Payment");
        waitForLoadingToDisappear(loadingIndicator);
        selectQuoteFromAI("No");
    }
    public void completeOrderLineDetails() {
        click(orderLinesTab);
        waitForVisibilityOfElement(addProductButton);
        clickAddProduct();
        selectInsurer("INSURANCE HOUSE PSC");
        waitForLoadingToDisappear(loadingIndicator);
        selectProduct("Group Medical");
        selectCategory("A");
        clickSaveAndCloseButton();
        clickOtherInfoTab();
        enterAndSelectTheText(underwriterField, "Karthika Lakshmi B");
        click(saveButton);
        waitForLoadingToDisappear(loadingIndicator);
    }
    public void clickConfirmQuotation() {
        click(confirmQuotationButton);
        waitForLoadingToDisappear(loadingIndicator);
    }
    public void clickConfirmOrder() {
        waitForVisibilityOfElement(operationTypeLabel);
        click(confirmOrderButton);
    }
    public void confirmTheOrderInPopup() {
        waitForVisibilityOfElement(confirmationPopupHeader);
        click(confirmationPopupOkButton);
        waitForLoadingToDisappear(loadingIndicator);
        waitForInvisibilityOfElement(confirmationPopupOkButton);
    }
    public void completeQuotationProcess() {
        clickConfirmQuotation();
        clickConfirmOrder();
        confirmTheOrderInPopup();
    }
    public void uploadPaymentReceipt() {
        click(addPaymentLineButton);
        enterAndSelectTheText(documentDropdown, "Payment Receipt");
        click(breadcrumb);
        By uploadFileInputLocator = By.xpath("//td[@title='Payment Receipt']/following-sibling::td/child::div[@name='document_file_id']//button/following-sibling::input");
        WebElement elePaymentUploadFile = Driver.getDriver().findElement(uploadFileInputLocator);
        waitForPresenceOfElement(uploadFileInputLocator);
        uploadFileUsingJs(elePaymentUploadFile, "pdf_testdata.pdf");
        waitForInvisibilityOfElement(elePaymentUploadFile);
    }
    public void clickDirectButton() {
        click(directButton);
        waitForVisibilityOfElement(directPaymentDetailsSection);
    }
    public void clickConfirmDirectPaymentButton() {
        click(confirmDirectPaymentButton);
        waitForInvisibilityOfElement(confirmDirectPaymentButton);
        waitForLoadingToDisappear(loadingIndicator);
    }
    public void selectAttachmentType(String attachmentType) {
        enterAndSelectTheText(attachmentTypeDropdown, attachmentType);
    }
    public void completeDirectPayment() {
        clickDirectButton();
        selectAttachmentType("payment proof");
        click(uploadYourFileButton);
        uploadFileUsingRobot("pdf_testdata.pdf");
        waitForVisibilityOfElement(confirmDirectPaymentButton);
        clickConfirmDirectPaymentButton();
    }
    public void clickPolicyMenu() {
        click(policyMenu);
        waitForLoadingToDisappear(loadingIndicator);
    }
    public void clickIssuePolicyButton() {
        click(issuePolicyButton);
        waitForLoadingToDisappear(loadingIndicator);
    }
    public void clickReconcileButton() {
        click(reconcileButton);
        waitForLoadingToDisappear(loadingIndicator);
    }
    public void completePolicyDetails() {
        sendKeys(policyNumberField, generateRandomNumber(7));
        scrollToElement(policyNumberField);
        sendKeys(invoiceNumberField, generateRandomNumber(7));
        enterSaleSupportUnderwriter();
        selectCustomDate(policyStartDateField, 1);
        waitForLoadingToDisappear(loadingIndicator);
        if (policyEndDateField.getText() == null) {
            selectCustomDate(policyEndDateField, 365);
        }
        selectCustomDate(invoiceDateField, 0);
    }
    public void enterSaleSupportUnderwriter() {
        enterAndSelectTheText(saleSupportUnderwriterField,"Karthika Lakshmi B");
    }
    public void uploadPolicyDocument() {
        click(policyDocAddButton);
        enterAndSelectTheText(documentDropdown, "Loss report");
        waitForLoadingToDisappear(loadingIndicator);
        uploadFileUsingJs(policyDocUploadFileButton,"pdf_testdata.pdf");
        waitForInvisibilityOfElement(policyDocUploadFileButton);
        waitForLoadingToDisappear(loadingIndicator);
    }
    public void clickInvoiceButton() {
        click(invoiceButton);
        waitForLoadingToDisappear(loadingIndicator);
    }
    public void clickSendButton() {
        click(sendButton);
        waitForLoadingToDisappear(loadingIndicator);
        waitForInvisibilityOfElement(sendButton);
    }
}
