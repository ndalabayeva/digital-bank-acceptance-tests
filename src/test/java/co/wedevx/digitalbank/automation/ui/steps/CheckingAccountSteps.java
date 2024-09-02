package co.wedevx.digitalbank.automation.ui.steps;
//Class 19.3 Create New Checking Account Cucumber Step Def Clean Up According to Best Practices

import co.wedevx.digitalbank.automation.ui.models.AccountCard;
import co.wedevx.digitalbank.automation.ui.models.BankTransaction;
import co.wedevx.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import co.wedevx.digitalbank.automation.ui.pages.CreateCheckingPage;
import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.pages.ViewCheckingAccountPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingAccountSteps {
    //WebDriver driver = new FirefoxDriver(); <- it was before learning Singleton class
    WebDriver driver = Driver.getDriver();
    //what we are telling here is:
    //okay, make sure you are taking object instance of a driver from the driver class
    //via driverGet() method that we created which will ensure that
    //across the whole project we are only using one driver

    //across the whole project we wanna have only one row
    //or one place where we will execute this new driver, block of code
//    public static WebDriver getDriver(){
//        if (driver == null){
//            driver = new ChromeDriver();
//        }
//        return driver;
//    }

    private LoginPage loginPage = new LoginPage(driver);
    private CreateCheckingPage createCheckingPage = new CreateCheckingPage(driver);
    private ViewCheckingAccountPage viewCheckingAccountPage = new ViewCheckingAccountPage(driver);


//    Since you already have a Driver class that handles the WebDriver instantiation based on the configuration
//    in the properties file, the @BeforeAll setup method becomes redundant and should be removed.

//    @BeforeAll --> it's already in Driver class
//    public static void setup() {
//        WebDriverManager.firefoxdriver().setup();
//        System.setProperty("webdriver.gecko.driver", "/Users/nazerke/Downloads/geckodriver");
//        System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");
//
//    }

    @Given("the user is logged in as {string} {string}")
    public void the_user_is_logged_in_as(String username, String password) {
        //Step defs take data from Feature file and provide it here
        loginPage.login(username, password);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//
//        WebElement usernameTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
//        WebElement passwordTxt = driver.findElement(By.id("password"));
//        WebElement sumbitBtn = driver.findElement(By.id("submit"));
//
//        usernameTxt.sendKeys(username);
//        passwordTxt.sendKeys(password);
//        sumbitBtn.click();
    }

    @When("the user creates a new checking account with the following data")
    public void the_user_creates_a_new_checking_account_with_the_following_data(List<NewCheckingAccountInfo> checkingAccountInfoList) {
        createCheckingPage.createNewChecking(checkingAccountInfoList);
    }

    @Then("the user should see the green {string} message")
    public void the_user_should_see_the_green_message(String expectedConfMessage) {

        expectedConfMessage = "Confirmation " + expectedConfMessage + "\n×";

        assertEquals(expectedConfMessage,createCheckingPage.getActualCreateAccountConfirmationMessage());
    }

    @Then("the user should see newly added account card")
    public void the_user_should_see_newly_added_account_card(List<AccountCard> accountCardList) {
        Map<String, String> actualResultMap = viewCheckingAccountPage.getNewlyAddedCheckingAccountInfoMap();

        AccountCard expectedResult = accountCardList.get(0);

        assertEquals(expectedResult.getAccountName(), actualResultMap.get("actualAccountName"));
        assertEquals("Account: " + expectedResult.getAccountType(), actualResultMap.get("actualAccountType"));
        assertEquals("Ownership: " + expectedResult.getOwnership(), actualResultMap.get("actualOwnership"));
        //Account number will be studied further
        assertEquals("Interest Rate: " + expectedResult.getInterestRate(),actualResultMap.get("actualInterestRate"));

        String expectedBalance = String.format("%.2f", expectedResult.getBalance());
        assertEquals("Balance: $" + expectedBalance, actualResultMap.get("actualBalance"));
    }

    @Then("the user should see the following transaction")
    public void the_user_should_see_the_following_transaction(List<BankTransaction> expectedTransactions) {
        Map<String, String> actualResultMap = viewCheckingAccountPage.getNewlyAddedCheckingAccountTransactionInfoMap();
        BankTransaction expectedTransaction = expectedTransactions.get(0);

        assertEquals(expectedTransaction.getCategory(), actualResultMap.get("actualCategory"), "transaction category mismatch");
        //assertEquals(expectedTransaction.getDescription(), actualDescription, "transaction description mismatch");
        //dynamic staff like description will be studied later
        assertEquals(expectedTransaction.getAmount(), Double.parseDouble(actualResultMap.get("actualAmount")), "transaction amount mismatch");
        //Map is returning String but we are validating double value
        assertEquals(expectedTransaction.getBalance(), Double.parseDouble(actualResultMap.get("actualBalance")), "transaction balance mismatch");
//        To test what will happen if step fails:
//        fail();

    }
}
