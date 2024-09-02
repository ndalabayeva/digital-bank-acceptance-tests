package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.pages.CreatingNewCheckingAccountPage;
import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.pages.RegistrationPage;
import co.wedevx.digitalbank.automation.ui.pages.viewCheckingPage;
import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import co.wedevx.digitalbank.automation.ui.utils.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationSteps {

    private RegistrationPage registrationPage = new RegistrationPage(getDriver());
    List<Map<String, Object>> nextValList = new ArrayList<>();

    private LoginPage loginPage = new LoginPage(getDriver());
    private CreatingNewCheckingAccountPage newCheckingOpening = new CreatingNewCheckingAccountPage(getDriver());
    private viewCheckingPage viewCheckings = new viewCheckingPage(getDriver());


    @Given("User navigates to Digital Bank signup page")
    public void user_navigates_to_digital_bank_signup_page() {
        getDriver().get(ConfigReader.getPropertiesValues("digitalbank.registrationpageurl"));

        //our aim is to create easily configurable thing
        assertEquals("Digital Bank", getDriver().getTitle(), "Registration page Title mismatch");

    }

    @When("User creates account with following fields")
//    @When("User creates account with following fields with mocked email and ssn")
//    we do not mock email and ssn since class 21.10 Automate Registration Steps by Deleting Previously Created User
    public void user_creates_account_with_following_fields(List<Map<String, String>> registrationTestDataMap) {
        registrationPage.fillOutRegistrationForm(registrationTestDataMap);
    }

    @Then("User should be displayed with the message {string}")
    public void user_should_be_displayed_with_the_message(String expectedSuccessMessage) {
        assertEquals(expectedSuccessMessage, registrationPage.getMessage(), "Success Message Mismatch");
    }

    @Then("User should see {string} the required field error message {string}")
    public void userShouldSeeTheRequiredFieldErrorMessage(String fieldName, String expectedErrorMessage) {
        //fieldName will be passed from the feature file <fieldWithError> with error title
        String actualErrorMessage = registrationPage.getRequiredFieldErrorMessage(fieldName);
        assertEquals(expectedErrorMessage, actualErrorMessage, "the error message of the required " + fieldName + " field mismatch");
    }

    @Then("the following user info should be saved in the db")
    public void theFollowingUserInfoShouldBeSavedInTheDb(List<Map<String, String>> expectedUserProfileInfoInDBList) {
        // Retrieve the first element from the expected user profile info list from the database
        Map<String, String> expectedUserInfoMap = expectedUserProfileInfoInDBList.get(0);

        // Construct an SQL query to retrieve user information from the 'users' table based on the email (which is the username in this case)
        String queryUserTable = String.format("select * from users where username='%s'", expectedUserInfoMap.get("email"));
        // Construct an SQL query to retrieve user profile information from the 'users' table based on the email address
        String queryUserProfile = String.format("select * from users where email_address='%s'", expectedUserInfoMap.get("email"));

        // Execute the SQL query to retrieve user information and store the result as a list of maps
        List<Map<String, Object>> actualUserInfoList = DBUtils.runSQLSelectQuery(queryUserTable);
        // Execute the SQL query to retrieve user profile information and store the result as a list of maps
        List<Map<String, Object>> actualUserProfileInfoList = DBUtils.runSQLSelectQuery(queryUserProfile);

        // Verify that only one user record was created during registration
        assertEquals(1, actualUserInfoList.size(), "registration generated unexpected number of users");
        // Verify that only one user profile record was created during registration
        assertEquals(1, actualUserProfileInfoList.size(), "registration generated unexpected number of user profiles");

        //validate the user_profile table
        Map<String, Object> actualUserInfoMap = actualUserInfoList.get(0);
        Map<String, Object> actualUserProfileInfoMap = actualUserProfileInfoList.get(0);
         assertEquals(actualUserInfoMap.get("title"), actualUserProfileInfoMap.get("title"), "registration generated wrong title");
         assertEquals(actualUserInfoMap.get("firstName"), actualUserProfileInfoMap.get("first_name"), "registration generated wrong firstName");
         assertEquals(actualUserInfoMap.get("lastName"), actualUserProfileInfoMap.get("last_name"), "registration generated wrong lastName");
         assertEquals(actualUserInfoMap.get("gender"), actualUserProfileInfoMap.get("gender"), "registration generated wrong gender");
//         assertEquals(actualUserInfoMap.get("dob"), actualUserProfileInfoMap.get("dob"), "registration generated wrong dob");
         assertEquals(actualUserInfoMap.get("ssn"), actualUserProfileInfoMap.get("ssn"), "registration generated wrong ssn");
         assertEquals(actualUserInfoMap.get("email"), actualUserProfileInfoMap.get("email_address"), "registration generated wrong ssn");

        //validate the user table
        assertEquals(expectedUserInfoMap.get("accountNonExpired"), String.valueOf(actualUserInfoMap.get("account_non_expired")), "accountNonExpired mismatch upon registration");
        assertEquals(expectedUserInfoMap.get("accountNonLocked"), String.valueOf(actualUserInfoMap.get("account_non_locked")), "accountNonLocked mismatch upon registration");
        assertEquals(expectedUserInfoMap.get("credentialsNonExpired"), String.valueOf(actualUserInfoMap.get("credentials_non_expired")), "credentialsNonExpired mismatch upon registration");
        assertEquals(expectedUserInfoMap.get("enabled"), String.valueOf(actualUserInfoMap.get("enabled")), "account enabled mismatch upon registration");
        assertEquals(expectedUserInfoMap.get("email"), actualUserInfoMap.get("username"), "username mismatch upon registration");
        int expectedUserProfileId = Integer.parseInt(String.valueOf(nextValList.get(0).get("next_val")));
        assertEquals(++expectedUserProfileId, actualUserInfoMap.get("id"),"ID mismatch");
    }

    @Given("the user with {string} is not in DB")
    public void theUserWithIsNotInDB(String email) {
        String queryForUserProfile = String.format("DELETE FROM user_profile where email_address='%s'", email);
        String queryForUsers = String.format("DELETE FROM user_profile where username='%s'", email);

        String queryToGetNextValInHibernateSeqTable = String.format("select * from hibernate_sequence");
        nextValList = DBUtils.runSQLSelectQuery(queryToGetNextValInHibernateSeqTable);

        DBUtils.runSQLUpdateQuery(queryForUserProfile);
        DBUtils.runSQLUpdateQuery(queryForUsers);
    }
}
