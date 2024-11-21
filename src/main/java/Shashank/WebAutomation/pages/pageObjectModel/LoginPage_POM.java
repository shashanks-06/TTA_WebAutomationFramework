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
    private final By dashboardName = By.cssSelector("[data-qa=\"lufexuloga\"]");
    private final By vwoLogo = By.cssSelector("img[alt='VWO'][width='132px']");


//    Page Actions
    public String loginToVwo_InvalidCreds(String user, String pwd) {
        driver.get(PropertyReader.readKey("vwoUrl"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInButton).click();

        staticWait_Thread(3000);

        String errorMsgText = driver.findElement(errorMsg).getText();

        return errorMsgText;

    }

    public void loginToVwo_ValidCreds (String user, String pwd){

        openVwoLoginUrl();
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(signInButton);

        staticWait_Thread(3000);

    }

    public String verify_backToLoginPage(){
        staticWait_Thread(2000);

        presenceOfElements(vwoLogo);

        return getElement(vwoLogo).getAttribute("alt");
    }



}
