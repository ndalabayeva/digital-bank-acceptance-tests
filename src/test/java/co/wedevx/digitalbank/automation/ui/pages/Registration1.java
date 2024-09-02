//package co.wedevx.digitalbank.automation.ui.pages;
////page1
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
//
//public class Registration1 {
//    private WebDriver driver;
//
//    //Constructor to initialize the WebDriver and PageFactory
//    //pass constructor driver
//    public Registration1(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver, this);  //initialize elements using PageFactory<-- memorize this by hard
//    }
//    //use FindBy annotation to locate and initialize web elements
//    @FindBy(id = "title")
//    private WebElement titleDropdown;
//
//    @FindBy(id = "firstName")
//    private WebElement firstName;
//
//    @FindBy(id = "lastName")
//    private WebElement lastName;
//
//    @FindBy(xpath = "//input[@name='gender' and @value='F']")
//    private WebElement genderFemale; // Assuming 'F' is the value for female
//
//    @FindBy(id = "dob")
//    private WebElement dateOfBirth;
//
//    @FindBy(id = "ssn")
//    private WebElement socialSecurityNumber;
//
//    @FindBy(id = "emailAddress")
//    private WebElement emailAddress;
//
//    @FindBy(id = "password")
//    private WebElement password;
//
//    @FindBy(id = "confirmPassword")
//    private WebElement confirmPassword;
//
//    @FindBy(xpath = "//button")
//    private WebElement nextBtn;
//
//    // Create action methods
//    public void selectTitle(String title) {
//        new Select(titleDropdown).selectByVisibleText(title);
//    }
//
//    public void enterFirstName(String firstName) {
//        this.firstName.sendKeys(firstName);
//    }
//
//    public void enterLastName(String lastName) {
//        this.lastName.sendKeys(lastName);
//    }
//
//    public void selectGender(String gender) {
//        if (gender.equalsIgnoreCase("F")) {
//            genderFemale.click();
//        }
//        // Add logic for other genders if applicable
//    }
//
//    public void enterDateOfBirth(String dob) {
//        dateOfBirth.sendKeys(dob);
//    }
//
//    public void enterSocialSecurityNumber(String ssn) {
//        socialSecurityNumber.sendKeys(ssn);
//    }
//
//    public void enterEmailAddress(String email) {
//        emailAddress.sendKeys(email);
//    }
//
//    public void enterPassword(String password) {
//        this.password.sendKeys(password);
//    }
//
//    public void enterConfirmPassword(String confirmPassword) {
//        this.confirmPassword.sendKeys(confirmPassword);
//    }
//
//    public void clickNext() {
//        nextBtn.click();
//    }
//
//    public void registration1(String title, String firstName, String lastName, String gender, String dob, String ssn,
//                             String email, String password, String confirmPassword) {
//        selectTitle(title);
//        enterFirstName(firstName);
//        enterLastName(lastName);
//        selectGender(gender);
//        enterDateOfBirth(dob);
//        enterSocialSecurityNumber(ssn);
//        enterEmailAddress(email);
//        enterPassword(password);
//        enterConfirmPassword(confirmPassword);
//        clickNext();
//    }
//
//
//}
