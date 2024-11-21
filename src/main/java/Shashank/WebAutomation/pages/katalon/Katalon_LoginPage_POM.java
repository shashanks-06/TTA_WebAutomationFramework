package Shashank.WebAutomation.pages.katalon;

import Shashank.WebAutomation.base.CommonToAllPage;
import Shashank.WebAutomation.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Katalon_LoginPage_POM extends CommonToAllPage {
    WebDriver driver;

    public Katalon_LoginPage_POM(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginHeading = By.xpath("//h2[normalize-space()='Login']");
    private final By usernameField = By.id("txt-username");
    private final By passwordField = By.id("txt-password");
    private final By loginBtnField = By.id("btn-login");

    public void loginToKatalon(){
        visibilityOfElement(loginHeading);

        enterInput(usernameField, PropertyReader.readKey("katalon_username"));
        enterInput(passwordField, PropertyReader.readKey("katalon_password"));
        clickElement(loginBtnField);

        staticWait_Thread(1000);
    }
}
