package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class viewCheckingPage extends BaseMenuPage{

    public viewCheckingPage(WebDriver driver){
       super(driver);
    }

    @FindBy(id = "checking-menu")
    private WebElement checkingMenuButton;

    public void viewCheckingMenuButtons(){
        checkingMenuButton.click();
        viewCheckingMenuButton.click();
    }

}
