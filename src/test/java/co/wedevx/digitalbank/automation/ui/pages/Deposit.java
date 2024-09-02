package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Deposit {
    private WebDriver driver;

    //Constructor to initialize the WebDriver and PageFactory
    //pass constructor driver
    public Deposit(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);  //initialize elements using PageFactory<-- memorize this by hard
    }

    @FindBy(id= "deposit-menu-item")
    private WebElement depositMenu;

    @FindBy(id= "selectedAccount")
    private WebElement accountsDropdown;

    @FindBy(id= "amount")
    private WebElement depositAmountTxt;

    @FindBy(xpath= "//button[@class='btn btn-primary btn-sm']")
    private WebElement submitButton;

    public void makingNewDeposit(String checkingName, String depositAmount){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        depositMenu.click();

        // Wait for the dropdown to be visible and interactable
        wait.until(ExpectedConditions.visibilityOf(accountsDropdown));
        wait.until(ExpectedConditions.elementToBeClickable(accountsDropdown));

        Select accountSelect = new Select(accountsDropdown);
        List<WebElement> options = accountSelect.getOptions();
        for (WebElement option : options) {
            if (option.getText().contains(checkingName)){
                option.click();
            }
        }
        depositAmountTxt.sendKeys(depositAmount);
       submitButton.click();

    }
}
