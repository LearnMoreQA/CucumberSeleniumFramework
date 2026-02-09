package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.plaf.PanelUI;

public class LeadPipeline extends BasePage {

     /* Locators */
    @FindBy(xpath = "//div[@class='o_searchview_input_container']/input")
    private WebElement searchLeadField;
    @FindBy(xpath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']/tbody/tr")
    private WebElement searchLeadResult;

     /* Methods */

    public void searchLead(String leadNumber) {
        sendKeys(searchLeadField, leadNumber + Keys.ENTER);
    }

    public void clickSearchLead() {
        click(searchLeadResult);
    }
}
