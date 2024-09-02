package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WithdrawPage extends BasePage{

    public WithdrawPage(WebDriver driver){
        super(driver);
        //driver will go to the parent class Base Page
    }

    @FindBy(id= "withdraw-menu-item")
    private WebElement withdrawMenuButton;

    @FindBy(id= "selectedAccount")
    private WebElement accountsDropdown;

    @FindBy(id= "amount")
    private WebElement withdrawAmountTxt;

    @FindBy(xpath= "//button[@class='btn btn-primary btn-sm']")
    private WebElement submitButton;

    public void withdrawPage(String checkingName, String withdrawAmount){
        withdrawMenuButton.click();
        Select accountSelect = new Select(accountsDropdown);
        List<WebElement> options = accountSelect.getOptions();
        for (WebElement option : options) {
            if (option.getText().contains(checkingName)){
                option.click();
            }
        }
        withdrawAmountTxt.sendKeys(withdrawAmount);
        submitButton.click();
    }
}
