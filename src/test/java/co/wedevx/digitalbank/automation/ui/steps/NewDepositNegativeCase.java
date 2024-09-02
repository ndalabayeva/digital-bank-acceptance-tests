//package co.wedevx.digitalbank.automation.ui.steps;
////Ex 19.1.1 Deposit - positive case for Checking
//
//import co.wedevx.digitalbank.automation.ui.pages.*;
//import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
//import co.wedevx.digitalbank.automation.ui.utils.Driver;
//import co.wedevx.digitalbank.automation.ui.utils.TestData;
//import io.cucumber.java.en.Given;
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
//public class NewDepositNegativeCase {
//    WebDriver driver = Driver.getDriver();
//    RegistrationPage registrationPage = new RegistrationPage(getDriver());
//    private LoginPage loginPage = new LoginPage(driver);
//    private CreatingNewCheckingAccountPage newCheckingOpening = new CreatingNewCheckingAccountPage(driver);
//    private Deposit doDeposit = new Deposit(driver);
//
//    @Given("User navigates to Digital Bank signup page")
//    public void user_navigates_to_digital_bank_signup_page() {
//        getDriver().get(ConfigReader.getPropertiesValues("digitalbank.registrationpageurl"));
//        //our aim is to create easily configurable thing
//        assertEquals("Digital Bank", getDriver().getTitle(), "Registration page Title mismatch");
//    }
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
//        newCheckingOpening.creatingNewChecking(checkingAccountInfo);
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
//    @Then("User navigates to Deposit page and makes deposit for {string} leaving amount empty")
//    public void user_navigates_to_deposit_page_and_makes_deposit_for_leaving_amount_empty(String checkingName, Double depositAmount) {
//        driver.navigate().refresh();
//        doDeposit.makingNewDeposit(checkingName, String.valueOf(depositAmount));
//        //Since the depositAmount in the Cucumber step definition is of type Double,
//        //you need to convert it to String to match the method signature.
//        //This conversion ensures that the method can properly handle the input without any type mismatch errors.
//    }
//
//    @Then("User Validates the error is displayed and deposit was not made")
//    public void user_validates_the_error_is_displayed_and_deposit_was_not_made(double expectedDepositAmount) {
//       String expectedUrl = "https://dbank-qa.wedevx.co/bank/account/checking-view?selectSwitch=30846";
//       assertEquals(expectedUrl, driver.getCurrentUrl(), "Submit button didn't take to the url" + expectedUrl);
//    }
//}