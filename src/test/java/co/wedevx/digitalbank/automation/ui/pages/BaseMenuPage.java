package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseMenuPage extends BasePage{

    public BaseMenuPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id= "checking-menu")
    protected WebElement checkingMenu;

    @FindBy(id= "new-checking-menu-item")
    protected WebElement newCheckingButton;

    @FindBy (id = "view-checking-menu-item")
    protected WebElement viewCheckingMenuButton;

    @FindBy (id = "transfer-menu-item")
    protected WebElement transferBetweenAccountsButton;

    @FindBy (id = "home-menu-item")
    protected WebElement homeButton;

    public void goToHomePage(){
        homeButton.click();
    }
    //I can use this method in any of the step definitions because each POM inherits BaseMenuPage
}
