package Shashank.WebAutomation.driver;

import Shashank.WebAutomation.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverManager {
    public static WebDriver driver;

    public  static WebDriver getDriver(){
        return driver;
    }

    public static void setDriver(WebDriver driver){
        DriverManager.driver = driver;
    }

    public static void init(){
        String browser = null;
        browser = PropertyReader.readKey("browser");
        browser = browser.toLowerCase();

        if (driver == null){
            switch (browser){
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--guest");
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--guest");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    System.out.println("No driver Found");
            }
        }
    }

    public static void down(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }


}
