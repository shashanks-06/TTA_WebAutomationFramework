package Shashank.WebAutomation.pages.sauceDemo;

import Shashank.WebAutomation.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sauce_CheckoutPage2_POM extends CommonToAllPage {
    WebDriver driver;

    public Sauce_CheckoutPage2_POM(WebDriver driver) {
        this.driver = driver;
    }

    private final By checkoutPage2HeadingElement = By.cssSelector("[class=\"title\"]");
    private final By productNameElement = By.cssSelector("[class=\"inventory_item_name\"]");
    private final By productPriceElement = By.cssSelector("[class=\"inventory_item_price\"]");
    private final By paymentInfoElement = By.xpath("//div[@class=\"summary_value_label\"][1]");
    private final By shippingInfoElement = By.xpath("//div[@class=\"summary_value_label\"][2]");
    private final By finishBtnElement = By.id("finish");


    public String getHeading(){
        visibilityOfElement(checkoutPage2HeadingElement);
        return getElementAsText(checkoutPage2HeadingElement);
    }

    public String getProductName(){
        visibilityOfElement(productNameElement);
        return getElementAsText(productNameElement);
    }

    public String getProductPrice(){
        visibilityOfElement(productPriceElement);
        return getElementAsText(productPriceElement);
    }

    public String getPaymentInfo(){
        presenceOfElements(paymentInfoElement);
        return getElementAsText(paymentInfoElement);
    }

    public String getShippingInfo(){
        presenceOfElements(shippingInfoElement);
        return getElementAsText(shippingInfoElement);
    }

    public void clickOnFinish(){
        elementToBeClickable(finishBtnElement);
        clickElement(finishBtnElement);
    }

}
