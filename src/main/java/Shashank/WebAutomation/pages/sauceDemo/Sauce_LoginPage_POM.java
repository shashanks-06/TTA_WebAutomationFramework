package Shashank.WebAutomation.pages.sauceDemo;

import Shashank.WebAutomation.base.CommonToAllPage;
import Shashank.WebAutomation.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sauce_LoginPage_POM extends CommonToAllPage {
    WebDriver driver;

    public Sauce_LoginPage_POM(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginHeading = By.className("login_logo");
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By submitBtn = By.id("login-button");

    public String loginToSwagLabs(){

        openSauceUrl();

        visibilityOfElement(loginHeading);
        String heading = getElementAsText(loginHeading);

        enterInput(usernameField, PropertyReader.readKey("sauce_username"));
        enterInput(passwordField, PropertyReader.readKey("sauce_password"));
        clickElement(submitBtn);

        staticWait_Thread(2000);

        return heading;
    }

}
