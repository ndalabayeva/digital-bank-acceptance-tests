package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//making abstract because we don't want anyone to create Base Page object
//we are not creating object here, it just serves as a parent class
//BasePage is abstract to prevent direct instantiation and is intended to be a parent class.
public abstract class BasePage {
    private WebDriver driver;

    //Constructor to initialize the WebDriver and PageFactory
    //pass constructor driver
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);  //initialize elements using PageFactory<-- memorize this by hard
    }
}
