//package co.wedevx.digitalbank.automation.ui.pages;
////page2
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class Registration2 {
//    private WebDriver driver;
//
//    //Constructor to initialize the WebDriver and PageFactory
//    //pass constructor driver
//    public Registration2(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver, this);  //initialize elements using PageFactory<-- memorize this by hard
//    }
//
//    @FindBy(id = "address")
//    private WebElement addressTxt;
//
//    @FindBy(id = "locality")
//    private WebElement localityTxt;
//
//    @FindBy(id = "region")
//    private WebElement regionTxt;
//
//    @FindBy(id = "postalCode")
//    private WebElement postalCodeTxt;
//
//    @FindBy(id = "country")
//    private WebElement countryTxt;
//
//    @FindBy(id = "homePhone")
//    private WebElement homePhoneTxt;
//
//    @FindBy(id = "mobilePhone")
//    private WebElement mobilePhoneTxt;
//
//    @FindBy(id = "workPhone")
//    private WebElement workPhoneTxt;
//
//    @FindBy (id = "agree-terms")
//    private WebElement agreeCheckBtn;
//
//    @FindBy (xpath = "//button")
//    private WebElement submitBtn;
//
//    public void enterAddress(String address) {
//        addressTxt.sendKeys(address);
//    }
//    public void enterLocality(String locality) {
//        localityTxt.sendKeys(locality);
//    }
//    public void enterRegion(String region) {
//        regionTxt.sendKeys(region);
//    }
//    public void enterPostalCode(String postalCode) {
//        postalCodeTxt.sendKeys(postalCode);
//    }
//    public void enterCountry(String country) {
//        countryTxt.sendKeys(country);
//    }
//    public void enterHomePhone(String homePhone) {
//        homePhoneTxt.sendKeys(homePhone);
//    }
//    public void enterMobilePhone(String mobilePhone) {
//        mobilePhoneTxt.sendKeys(mobilePhone);
//    }
//    public void enterWorkPhone(String workPhone) {
//        workPhoneTxt.sendKeys(workPhone);
//    }
//    public void clickCheckBtn() {
//        agreeCheckBtn.click();
//    }
//    public void clickSubmit() {
//        submitBtn.click();
//    }
//    public void registration2(String address, String locality, String region, String postalCode, String country,
//                             String homePhone, String mobilePhone, String workPhone) {
//        enterAddress(address);
//        enterLocality(locality);
//        enterRegion(region);
//        enterPostalCode(postalCode);
//        enterCountry(country);
//        enterHomePhone(homePhone);
//        enterMobilePhone(mobilePhone);
//        enterWorkPhone(workPhone);
//        clickCheckBtn();
//        clickSubmit();
//    }
//
//}
