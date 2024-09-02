package co.wedevx.digitalbank.automation.ui.utils;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

//Driver class is intended to follow the Singleton pattern,
//ensuring that there is only one instance of the WebDriver throughout the application's lifecycle.
public class Driver {
    //logic that will initialize any of the supported web drivers
    //whoever using application will change properties file that doesn't need coding skills
    private static WebDriver driver; //one instance of driver

    //Private constructor to prevent instantiation
    private Driver() { //<-we make sure that constructor is private
    }

    //across the whole project we wanna have only one row
    //or one place where we will execute this new driver, block of code
    public static WebDriver getDriver() {
        if (driver == null) {  // Ensure only one instance of WebDriver

            String browser = ConfigReader.getPropertiesValues("digitalbank.browser");
            switch (browser.toLowerCase()) {
                case "chrome":

                    WebDriverManager.chromedriver().setup();
                    System.setProperty("webdriver.chrome.driver", "/Users/nazerke/Downloads/chromedriver");
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.operadriver().setup();
                    driver = new SafariDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "headless":
                    ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                    System.setProperty("webdriver.chrome.driver", "/Users/nazerke/Downloads/chromedriver");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("disable-extensions");
                    options.setExperimentalOption("useAutomationExtension", false);
                    options.addArguments("--proxy-server='direct://'");
                    options.addArguments("--proxy-bypass-list=*");
                    options.addArguments("--start-maximized");
                    options.addArguments("--headless");

                    driver = new ChromeDriver(options);
                    break;

                case "firefox":
                default:
                    WebDriverManager.firefoxdriver().setup();
                    System.setProperty("webdriver.gecko.driver", "/Users/nazerke/Downloads/geckodriver");
                    System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;

            }
            //with If statement
//        if (driver == null){
//            if (browser.equalsIgnoreCase("chrome")){
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//            }else if(browser.equalsIgnoreCase("firefox")){
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//            }
//        }
//
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//
            //the Driver class sets the implicit wait once during the WebDriver instantiation.
            //You can ensure that you don't have any redundant implicit wait settings elsewhere,
            //such as in the Hooks or any other setup methods.
        }
        return driver;
    }

    public static void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            //taking a screenshot
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            //adding the screenshot to the report
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }


    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
