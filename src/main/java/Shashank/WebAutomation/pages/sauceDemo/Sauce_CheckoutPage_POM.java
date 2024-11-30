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
    private final By checkoutFirstnameField = By.id("first-name");
    private final By checkoutLastnameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueBtnField = By.id("continue");


    public String getCheckoutHeadingName() {
        presenceOfElements(checkoutHeadingElement);
        return getElementAsText(checkoutHeadingElement);
    }

    public void setInputFields(String firstname, String lastname, String postalCode) {
        visibilityOfElement(checkoutFirstnameField);
        presenceOfElements(checkoutLastnameField);
        visibilityOfElement(postalCodeField);

        enterInput(checkoutFirstnameField, firstname);
        enterInput(checkoutLastnameField, lastname);
        enterInput(postalCodeField, postalCode);
    }

    public void clickOnContinueBtn(){
            presenceOfElements(continueBtnField);
            clickElement(continueBtnField);
    }
}
