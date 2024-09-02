package co.wedevx.digitalbank.automation.ui.pages;
//Askar's method
//Class 19.3 Create New Checking Account Cucumber Step Def Clean Up According to Best Practices

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewCheckingAccountPage extends BasePage{
    //initialize WebDriver
    private WebDriver driver;

    //Constructor to initialize the WebDriver and PageFactory
    //pass constructor driver
    public ViewCheckingAccountPage(WebDriver driver) {
        super(driver);
        //driver will go to the parent class Base Page
    }

    @FindBy(xpath = "//div[@id='firstRow']/div")
    private List<WebElement> allFirstRowDivs;

    @FindBy(xpath = "//table[@id='transactionTable']/tbody/tr")
    private WebElement firstRowOfTransactions;

    public Map<String, String> getNewlyAddedCheckingAccountTransactionInfoMap() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstRowOfTransactions));

        //table[@id='transactionTable']/tbody/tr/td
        List<WebElement> firstRowColumns = firstRowOfTransactions.findElements(By.xpath("td"));
        //continue without slash / if it's part of whole table's xpath

        Map<String, String> actualResultMap = new HashMap<>();
        actualResultMap.put("actualCategory",firstRowColumns.get(1).getText());
        actualResultMap.put("actualDescription",firstRowColumns.get(2).getText());
        actualResultMap.put("actualAmount",firstRowColumns.get(3).getText().substring(1));
        actualResultMap.put("actualBalance",firstRowColumns.get(4).getText().substring(1));

        return actualResultMap;
    }

    public Map<String, String> getNewlyAddedCheckingAccountInfoMap() {
        WebElement lastAccountCard = allFirstRowDivs.get(allFirstRowDivs.size() - 1);
        //last account card varies and depends on which type of card was created on website
        String actualResult = lastAccountCard.getText();

        Map<String, String> actualResultMap = new HashMap<>();
        actualResultMap.put("actualAccountName", actualResult.substring(0, actualResult.indexOf("\n")).trim());
        actualResultMap.put("actualAccountType", actualResult.substring(actualResult.indexOf("Account"), actualResult.indexOf("Ownership")).trim());
        actualResultMap.put("actualOwnership", actualResult.substring(actualResult.indexOf("Ownership:"), actualResult.indexOf("Account Number:")).trim());
        actualResultMap.put("actualAccountNumber", actualResult.substring(actualResult.indexOf("Account Number:"), actualResult.indexOf("Interest Rate")).trim());
        actualResultMap.put("actualInterestRate", actualResult.substring(actualResult.indexOf("Interest Rate:"), actualResult.indexOf("Balance:")).trim());
        actualResultMap.put("actualBalance", actualResult.substring(actualResult.indexOf("Balance:")).trim());

        return actualResultMap;
    }


}
