package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickMyProfile {
    private WebDriver driver;

    //Constructor to initialize the WebDriver and PageFactory
    //pass constructor driver
    public ClickMyProfile(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);  //initialize elements using PageFactory<-- memorize this by hard
    }
    //use FindBy annotation to locate and initialize web elements
    @FindBy(xpath = "//img[@src='/bank/images/avatar/5.jpg']")
    private WebElement profileIcon;

    @FindBy(xpath = "//a[@href='/bank/user/profile']")
    private WebElement myProfileBtn;

    public void clickProfileIcon(){
        profileIcon.click();
    }
    // Method to click on My Profile button
    public void clickMyProfileBtn(){
        myProfileBtn.click();
    }

    // Combined method to click both profile icon and My Profile button
    public void clickMyProfile(){
        clickProfileIcon();
        clickMyProfileBtn();
    }
}
