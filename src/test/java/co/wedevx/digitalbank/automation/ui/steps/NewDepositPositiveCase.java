//package co.wedevx.digitalbank.automation.ui.steps;
//
//import co.wedevx.digitalbank.automation.ui.pages.CreatingNewCheckingAccountPage;
//import co.wedevx.digitalbank.automation.ui.pages.Deposit;
//import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
//import co.wedevx.digitalbank.automation.ui.pages.RegistrationPage;
//import co.wedevx.digitalbank.automation.ui.utils.Driver;
//import co.wedevx.digitalbank.automation.ui.utils.TestData;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.Map;
//
//import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class NewDepositPositiveCase {
//    WebDriver driver = Driver.getDriver();
//    RegistrationPage registrationPage = new RegistrationPage(getDriver());
//    private LoginPage loginPage = new LoginPage(driver);
//    private CreatingNewCheckingAccountPage newCheckingOpening = new CreatingNewCheckingAccountPage(driver);
//    private Deposit doDeposit = new Deposit(driver);
//
////    @Given("User navigates to Digital Bank signup page")
////    public void user_navigates_to_digital_bank_signup_page() {
////        getDriver().get(ConfigReader.getPropertiesValues("digitalbank.registrationpageurl"));
////        //our aim is to create easily configurable thing
////        assertEquals("Digital Bank", getDriver().getTitle(), "Registration page Title mismatch");
////    }
//
//    @When("User creates account with following fields with mocked email and ssn")
//    public void user_creates_account_with_following_fields_with_mocked_email_and_ssn(List<Map<String, String>> registrationTestDataMap) {
//        registrationPage.fillOutRegistrationForm(registrationTestDataMap);
//    }
//
//    @Then("User should be displayed with the message {string}")
//    public void user_should_be_displayed_with_the_message(String expectedSuccessMessage) {
//        assertEquals(expectedSuccessMessage, registrationPage.getMessage(), "Success Message Mismatch");
//    }
//
//    @When("User signs in with new emailAddress and password {string}")
//    public void user_signs_in_with_new_emailAddress_and_password(String password) {
//        String email = TestData.getEmail(); // Get the generated email
//        loginPage.login(email,password);//Log in with the generated email
//    }
//
//    @Then("User creates new checking account with data")
//    public void user_creates_new_checking_account_with_data(List<Map<String,String>> checkingAccountInfo) {
//     newCheckingOpening.creatingNewChecking(checkingAccountInfo);
//    }
//
//    //Step about success message is in CheckingAccountSteps
//    @Then("the user should see the green {string} message")
//    public void the_user_should_see_the_green_message(String expectedConfMessage) {
//        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
////        WebElement newAccountConfAlertDiv = driver.findElement(By.id("new-account-conf-alert"));
//        WebElement newAccountConfAlertDiv = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("new-account-conf-alert")));
////        WebElement newAccountConfAlertDiv = driver.findElement(By.xpath("//span[@id='new-account-msg']"));
//
//        String actualConfMessage = newAccountConfAlertDiv.getText();
//        System.out.println(actualConfMessage);
//        expectedConfMessage = "Confirmation " + expectedConfMessage + "\n×";
//        assertEquals(expectedConfMessage, actualConfMessage, "The confirmation message does not match the expected message.");
//
//    }
//
//    @Then("User navigates to Deposit page and makes new deposit for {string} account and inputs {double}")
//    public void user_navigates_to_deposit_page_and_makes_new_deposit_for_account_and_inputs(String checkingName, Double depositAmount) {
//        driver.navigate().refresh();
//        doDeposit.makingNewDeposit(checkingName, String.valueOf(depositAmount));
//        //Since the depositAmount in the Cucumber step definition is of type Double,
//        //you need to convert it to String to match the method signature.
//        //This conversion ensures that the method can properly handle the input without any type mismatch errors.
//    }
//
//    @Then("User Validates the new amount on the View checking page and deposit equals {double}")
//    public void user_validates_the_new_amount_on_the_View_checking_page(double expectedDepositAmount) {
//        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement firstRowOfTransactions = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='transactionTable']/tbody/tr")));
//        //table[@id='transactionTable']/tbody/tr/td
//        List<WebElement> firstRowColumns = firstRowOfTransactions.findElements(By.xpath("td"));
//        String actualDepositAmountStr = firstRowColumns.get(3).getText().replaceAll("[^\\d.]", ""); // Remove all non-numeric characters
//        //This will remove the dollar sign and any other non-numeric characters that might be present.
//        double actualDepositAmount = Double.parseDouble(actualDepositAmountStr);
//
//        assertEquals(expectedDepositAmount, actualDepositAmount, "Wrong deposit amount");
//    }
//}
