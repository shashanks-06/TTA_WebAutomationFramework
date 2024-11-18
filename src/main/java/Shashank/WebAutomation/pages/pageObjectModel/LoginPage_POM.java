package Shashank.WebAutomation.pages.pageObjectModel;

import Shashank.WebAutomation.base.CommonToAllPage;
import Shashank.WebAutomation.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_POM extends CommonToAllPage {

    WebDriver driver;

    public LoginPage_POM(WebDriver driver){
        this.driver = driver;
    }

//    Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signInButton = By.id("js-login-btn");
    private By errorMsg = By.id("js-notification-box-msg");


//    Page Actions
    public String loginToVwo_InvalidCreds(String user, String pwd) {
        driver.get(PropertyReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInButton).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String errorMsgText = driver.findElement(errorMsg).getText();

        return errorMsgText;

    }


}
