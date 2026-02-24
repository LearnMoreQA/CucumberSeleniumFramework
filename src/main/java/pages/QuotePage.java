package pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuotePage extends BasePage {

    public QuotePage(){
        super();
    }

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
    @FindBy(xpath = "//div[text()='Loading...']")
    private WebElement loadingIndicator;
    @FindBy(xpath = "//div[@name='underwriter_id']/child::div/input")
    private WebElement underwriterField;
    @FindBy(xpath = "//button[@class='btn btn-primary o_form_button_save']")
    private WebElement saveButton;
    @FindBy(xpath = "//button[text()='Upload your file']")
    private WebElement uploadYourFileButton;

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

}
