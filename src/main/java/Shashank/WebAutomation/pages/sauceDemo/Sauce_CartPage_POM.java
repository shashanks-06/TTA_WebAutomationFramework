package Shashank.WebAutomation.pages.sauceDemo;

import Shashank.WebAutomation.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sauce_CartPage_POM extends CommonToAllPage {
    WebDriver driver;

    public Sauce_CartPage_POM(WebDriver driver){
        this.driver = driver;
    }

    private final By yourCartHeading = By.cssSelector("[class=\"title\"]");
    private final By cartItemElement = By.cssSelector("[class=\"inventory_item_name\"]");
    private final By cartItemPriceElement = By.cssSelector("[class=\"inventory_item_price\"]");
    private final By checkoutBtnElement = By.id("checkout");

    public String getYourCartHeading(){
        visibilityOfElement(yourCartHeading);
        return getElementAsText(yourCartHeading);
    }

    public String getCartItemName(){
        visibilityOfElement(cartItemElement);
        return getElementAsText(cartItemElement);
    }

    public String getCartItemPrice(){
        visibilityOfElement(cartItemPriceElement);
        return getElementAsText(cartItemPriceElement);
    }

    public void clickCheckoutBtn(){
        elementToBeClickable(checkoutBtnElement);
        clickElement(checkoutBtnElement);
    }
}
