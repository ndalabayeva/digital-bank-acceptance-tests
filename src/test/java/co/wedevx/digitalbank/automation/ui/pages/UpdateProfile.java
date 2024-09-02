package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateProfile {
    private WebDriver driver;

    //Constructor to initialize the WebDriver and PageFactory
    //pass constructor driver
    public UpdateProfile(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);  //initialize elements using PageFactory<-- memorize this by hard
    }
    //use FindBy annotation to locate and initialize web elements
    @FindBy(id = "workPhone")
    private WebElement workPhoneTxt;

    @FindBy(id = "address")
    private WebElement addressTxt;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
    private WebElement submitBtn;

    public void updateWorkPhone(String workPhone){
        workPhoneTxt.clear();
        workPhoneTxt.sendKeys(workPhone);
    }

    public void updateAddress(String address){
        addressTxt.clear();
        addressTxt.sendKeys(address);
    }
    public void submit(){
        submitBtn.click();
    }
    public void updateProfileAttributes(String workPhone, String address){
        updateWorkPhone(workPhone);
        updateAddress(address);
        submit();
    }

    // Method to retrieve updated work phone after submission
    public String getUpdatedWorkPhone() {
        return workPhoneTxt.getAttribute("value");
    }

    // Method to retrieve updated address after submission
    public String getUpdatedAddress() {
        return addressTxt.getAttribute("value");
    }
}
