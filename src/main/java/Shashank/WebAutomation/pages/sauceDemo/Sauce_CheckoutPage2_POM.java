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
    private final By subTotalPriceElement = By.cssSelector("[class=\"summary_subtotal_label\"]");
    private final By taxElement = By.cssSelector("[class=\"summary_tax_label\"]");
    private final By totalPriceElement = By.cssSelector("[class=\"summary_total_label\"]");
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

    public String getCleanedPrice(String wholeString, String stringToRemoved){
        return wholeString.replace(stringToRemoved, "");
    }

    public double getSubTotalPrice(){
        visibilityOfElement(subTotalPriceElement);
        String getPrice = getElementAsText(subTotalPriceElement); // Example: "Item total: $7.99"
        String cleanedPrice = getCleanedPrice(getPrice, "Item total: $");
        return Double.parseDouble(cleanedPrice);
    }
//    public double getSubTotalPrice(){
//        visibilityOfElement(subTotalPriceElement);
//        String getPrice = getElementAsText(subTotalPriceElement); // Example: "Item total: $7.99"
//        double subTotal = Double.parseDouble(getPrice.replace("Item total: $", "")); // Remove "Item total: $" and convert to double
//        return subTotal;
//    }

    public double getTax(){
        visibilityOfElement(taxElement);
        String getTax = getElementAsText(taxElement); // Example: "Tax: $0.64"
        String cleanedTax = getCleanedPrice(getTax, "Tax: $");
        return Double.parseDouble(cleanedTax);
    }
//    public double getTax(){
//        visibilityOfElement(taxElement);
//        String getTax = getElementAsText(taxElement); // Example: "Tax: $0.64"
//        double tax = Double.parseDouble(getTax.replace("Tax: $", "")); // Remove "Tax: $" and convert to double
//        return tax;
//    }

    public double getTotalPriceWithTax(){
        return getSubTotalPrice() + getTax();
    }

    public double getTotalPrice(){
        presenceOfElements(totalPriceElement);
        String getTotalPrice = getElementAsText(totalPriceElement); // Example: "Total: $8.63"
        double TotalPrice = Double.parseDouble(getTotalPrice.replace("Total: $", "")); // Remove "$" and convert to double
        return TotalPrice;
    }


    public void clickOnFinish(){
        elementToBeClickable(finishBtnElement);
        clickElement(finishBtnElement);
    }

}
