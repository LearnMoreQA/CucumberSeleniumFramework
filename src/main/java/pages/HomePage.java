package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

     /* Locators */
    @FindBy(css = ".o_menu_apps")
    private WebElement discussMenu;

    @FindBy(partialLinkText = "CRM")
    private WebElement crmMenu;

     /* Methods */
    public void selectDiscuss() {
        click(discussMenu);
    }
    public void clickCrm() {
        waitForVisibilityOfElement(crmMenu);
        click(crmMenu);
    }
}
