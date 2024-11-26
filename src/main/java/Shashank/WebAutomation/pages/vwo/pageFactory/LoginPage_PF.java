package Shashank.WebAutomation.pages.vwo.pageFactory;

import Shashank.WebAutomation.base.CommonToAllPage;
import Shashank.WebAutomation.driver.DriverManager;
import Shashank.WebAutomation.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF extends CommonToAllPage {

    // Page Locators
    @FindBy(id = "login-username") private WebElement username;
    @FindBy(id = "login-password") private WebElement password;
    @FindBy(id = "js-login-btn") private WebElement signInBtn;
    @FindBy(id = "js-notification-box-msg") private WebElement errorMsg;

    public LoginPage_PF(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String loginToVwo_InvalidCreds(String user, String pwd){
        DriverManager.getDriver().get(PropertyReader.readKey("vwoUrl"));
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(signInBtn);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return errorMsg.getText();
    }
}
