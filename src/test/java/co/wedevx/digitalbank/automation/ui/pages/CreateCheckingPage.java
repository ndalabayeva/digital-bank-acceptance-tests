package co.wedevx.digitalbank.automation.ui.pages;
//Askar's method
//Class 19.3 Create New Checking Account Cucumber Step Def Clean Up According to Best Practices

import co.wedevx.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateCheckingPage extends BaseMenuPage{

    public CreateCheckingPage(WebDriver driver){
        super(driver);
        //driver will go to the parent class Base Page
    }

//    @FindBy(id= "checking-menu")
//    private WebElement checkingMenu;
//    @FindBy(id= "new-checking-menu-item")
//    private WebElement newCheckingButton;
    //those are located in BaseMenuPage parent class now

    //Account types
    @FindBy(id = "Standard Checking")
    private WebElement standardCheckingAccountTypeRadioButton;

    @FindBy(id = "Interest Checking")
    private WebElement interestCheckingAccountTypeRadioButton;

    //Ownership types
    @FindBy(id = "Individual")
    private WebElement individualOwnershipTypeRadioButton;

    @FindBy(id = "Joint")
    private WebElement jointOwnershipTypeRadioButton;
    ///////////////////////////

    @FindBy(id = "name")
    private WebElement accountNameTxt;

    @FindBy(id = "openingBalance")
    private WebElement openingBalanceTxtBox;

    @FindBy(id= "newCheckingSubmit")
    private WebElement submitBtn;

    @FindBy(id = "new-account-conf-alert")
    private WebElement newAccountConfAlertDiv;

    public void createNewChecking(List<NewCheckingAccountInfo> checkingAccountInfoList){
        NewCheckingAccountInfo testDataForOneCheckingAccount = checkingAccountInfoList.get(0);

        //the user clicks on checking button
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkingMenu));
        checkingMenu.click();

        //the user clicks on the new checking button
        wait.until(ExpectedConditions.elementToBeClickable(newCheckingButton));
        newCheckingButton.click();

        // wait for the URL to change
        String expectedUrl = "https://dbank-qa.wedevx.co/bank/account/checking-add";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        assertEquals(ConfigReader.getPropertiesValues("digitalbank.createnewcheckingurl"), getDriver().getCurrentUrl(), "new Checking Button didn't take to the url: " + ConfigReader.getPropertiesValues("digitalbank.createnewcheckingurl"));

        //the user selects account type
        if(testDataForOneCheckingAccount.getCheckingAccountType().equalsIgnoreCase("Standard Checking")){
            standardCheckingAccountTypeRadioButton.click();
        }else if(testDataForOneCheckingAccount.getCheckingAccountType().equalsIgnoreCase("Interest Checking")){
            interestCheckingAccountTypeRadioButton.click();
        }else{
//            System.out.println("Wrong account type");
            throw new NoSuchElementException("Invalid checking account type option provided. Only supports Standard Checking and Interest Checking");
        }


        // the user selects ownership
        if(testDataForOneCheckingAccount.getAccountOwnership().equalsIgnoreCase("Individual")){
            individualOwnershipTypeRadioButton.click();
        }else if(testDataForOneCheckingAccount.getAccountOwnership().equalsIgnoreCase("Joint")){
            jointOwnershipTypeRadioButton.click();
        }else{
//            System.out.println("Wrong account type");
            throw new NoSuchElementException("Invalid ownership type option provided. Only supports Individual Checking and Joint Checking");
        }

        //the usernames the account
        accountNameTxt.sendKeys(testDataForOneCheckingAccount.getAccountName());

        //the user makes the initial deposit
        openingBalanceTxtBox.sendKeys(String.valueOf(testDataForOneCheckingAccount.getInitialDepositAmount()));

        //the user clicks on the submit button
        submitBtn.click();
    }

    public String getActualCreateAccountConfirmationMessage() {
        return newAccountConfAlertDiv.getText();
    }


}
