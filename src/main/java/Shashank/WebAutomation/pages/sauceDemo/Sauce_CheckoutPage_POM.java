package Shashank.WebAutomation.pages.sauceDemo;

import Shashank.WebAutomation.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sauce_CheckoutPage_POM extends CommonToAllPage {

    WebDriver driver;

    public Sauce_CheckoutPage_POM(WebDriver driver) {
        this.driver = driver;
    }

    private final By checkoutHeadingElement = By.cssSelector("[class=\"title\"]");


    public String getCheckoutHeadingName() {
        presenceOfElements(checkoutHeadingElement);
        return getElementAsText(checkoutHeadingElement);
    }
}
