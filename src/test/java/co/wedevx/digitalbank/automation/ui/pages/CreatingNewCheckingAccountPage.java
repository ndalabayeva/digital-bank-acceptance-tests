package co.wedevx.digitalbank.automation.ui.pages;
//Mine method for exercises

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class CreatingNewCheckingAccountPage {
    private WebDriver driver;

    //Constructor to initialize the WebDriver and PageFactory
    //pass constructor driver
    public CreatingNewCheckingAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);  //initialize elements using PageFactory<-- memorize this by hard
    }

    @FindBy(id= "checking-menu")
    private WebElement checkingMenuButton;

    @FindBy(id= "new-checking-menu-item")
    private WebElement createNewCheckingButton;

    //Account types
    @FindBy(xpath = "//label[@for='Standard Checking']//input")
    private WebElement standardCheckingRadio;

    @FindBy(xpath = "//label[@for='Interest Checking']//input")
    private WebElement interestCheckingRadio;

    //Ownership types
    @FindBy(xpath = "//label[@for='Individual']//input")
    private WebElement individualRadio;

    @FindBy(xpath = "//label[@for='Joint']//input")
    private WebElement jointRadio;
    ///////////////////////////

    @FindBy(id = "name")
    private WebElement accountNameTxt;

    @FindBy(id = "openingBalance")
    private WebElement initialDepositTxt;

    @FindBy(id= "newCheckingSubmit")
    private WebElement submitButton;

    public void creatingNewChecking(List<Map<String,String>> checkingAccountInfo){
        Map<String,String> firstRow = checkingAccountInfo.get(0);//getting first line
        checkingMenuButton.click();
        createNewCheckingButton.click();
        if (firstRow.get("checkingAccountType").equalsIgnoreCase("Standard Checking")){
            standardCheckingRadio.click();
        }else if(firstRow.get("checkingAccountType").equalsIgnoreCase("Interest Checking")){
            interestCheckingRadio.click();
        }else {
            System.out.println("Wrong account checking type.");
        }

        if (firstRow.get("accountOwnership").equalsIgnoreCase("Individual")){
            individualRadio.click();
        }else if(firstRow.get("accountOwnership").equalsIgnoreCase("Joint")){
            jointRadio.click();
        }else {
            System.out.println("Wrong account ownership type.");
        }

        accountNameTxt.sendKeys(firstRow.get("accountName"));
        initialDepositTxt.sendKeys(firstRow.get("initialDepositAmount"));
        submitButton.click();
    }

}
