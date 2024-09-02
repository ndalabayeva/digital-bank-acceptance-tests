package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.utils.DBUtils;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.*;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;

//here order doesn't matter
public class Hooks {
    @Before("@Registration")
    public static void establishConnectionToDB() {
        DBUtils.establishConnection();
    }

    @Before("not @Registration")  //exclude for all feature files excluding Registration
    public void the_user_is_on_dbank_homepage() {

        getDriver().get("https://dbank-qa.wedevx.co/bank/login");
//        no need to add implicit wait as it already was set in Driver class
    }

    @After("not @NegativeRegistrationCases")
    public void afterScenario(Scenario scenario) {
        Driver.takeScreenShot(scenario);
//        Driver.closeDriver();
    }

    @After()
    public void closeConnectionToDB() {
        DBUtils.closeConnection();
    }
}
