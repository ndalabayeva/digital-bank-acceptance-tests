//package co.wedevx.digitalbank.automation.ui.steps;
//
//import co.wedevx.digitalbank.automation.ui.models.BankRegistration;
//import co.wedevx.digitalbank.automation.ui.pages.ClickMyProfile;
//import co.wedevx.digitalbank.automation.ui.pages.Registration1;
//import co.wedevx.digitalbank.automation.ui.pages.Registration2;
//import co.wedevx.digitalbank.automation.ui.pages.UpdateProfile;
//import co.wedevx.digitalbank.automation.ui.utils.Driver;
//import co.wedevx.digitalbank.automation.ui.utils.MockData;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class RandomRegistration {
//    //WebDriver driver = new FirefoxDriver(); <- it was before learning Singleton class
//    WebDriver driver = Driver.getDriver();
//    //what we are telling here is:
//    //okay, make sure you are taking object instance of a driver from the driver class
//    //via driverGet() method that we created which will ensure that
//    //across the whole project we are only using one driver
//
//    //across the whole project we wanna have only one row
//    //or one place where we will execute this new driver, block of code
////    public static WebDriver getDriver(){
////        if (driver == null){
////            driver = new ChromeDriver();
////        }
////        return driver;
////    }
//
//    private ClickMyProfile myProfile = new ClickMyProfile(driver);
//    private UpdateProfile updateProfile = new UpdateProfile(driver);
//    private MockData mockData = new MockData();
//
//    private Registration1 registrationPage1 = new Registration1(driver);
//    private Registration2 registrationPage2 = new Registration2(driver);
//
//
////    @BeforeAll
////    public static void setup() {
////        WebDriverManager.firefoxdriver().setup();
////        System.setProperty("webdriver.gecko.driver", "/Users/nazerke/Downloads/geckodriver");
////        System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");
////
////    }
//
//    @Given("the user is on the sign up page")
//    public void the_user_is_on_the_sign_up_page() {
//        driver.get("https://dbank-qa.wedevx.co/bank");
//        driver.manage().window().fullscreen();
//        WebElement signUpBtn = driver.findElement(By.xpath("//a[@href='/bank/signup']"));
//        signUpBtn.click();
//    }
//
//    @When("the user fills out all the initial fields")
//    public void the_user_fills_out_all_the_initial_fields() {
//        BankRegistration randomUser = MockData.generateRandomUser();
//        System.out.println(randomUser.toString());  // Print generated user data
//        registrationPage1.registration1(randomUser.getTitle(), randomUser.getFirstName(), randomUser.getLastName(),
//                randomUser.getGender(), randomUser.getDateOfBirth(), randomUser.getSocialSecurityNumber(),
//                randomUser.getEmailAddress(), randomUser.getPassword(), randomUser.getConfirmPassword());
//    }
//
//    @When("the user fills out all the remaining fields")
//    public void the_user_fills_out_all_the_remaining_fields() {
//        BankRegistration randomUser = MockData.generateRandomUser();
//        System.out.println(randomUser.toString());  // Print generated user data
//        registrationPage2.registration2(randomUser.getAddress(), randomUser.getLocality(), randomUser.getRegion(),
//                randomUser.getPostalCode(), randomUser.getCountry(), randomUser.getHomePhone(), randomUser.getMobilePhone(),
//                randomUser.getWorkPhone());
//    }
//
//    @Then("the user should see My Profile icon")
//    public void the_user_should_see_My_Profile_icon(){
//        WebElement myProfileIcon = driver.findElement(By.xpath("//img[@src='/bank/images/avatar/5.jpg']"));
//        assertTrue(myProfileIcon.isDisplayed(), "acount was not created");
//    }
//
//}

