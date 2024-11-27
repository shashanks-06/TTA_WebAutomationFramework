package Shashank.WebAutomation.pages.sauceDemo;

import Shashank.WebAutomation.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Sauce_Dashboard_POM extends CommonToAllPage {
    WebDriver driver;

    public Sauce_Dashboard_POM(WebDriver driver){
        this.driver = driver;
    }

    private final By headingOfDashboard = By.className("app_logo");
    private final By priceElements = By.className("inventory_item_price");
    private final By addToCartBtnElements = By.cssSelector("[class=\"btn btn_primary btn_small btn_inventory \"]");
    private final By numOfCartItems = By.className("shopping_cart_badge");

    public String getHeading(){
        return getElementAsText(headingOfDashboard);
    }

    public void selectCheapProduct(){

        List<WebElement> priceList;
        List<WebElement> addToCartBtnList;

        double minPrice = Double.MAX_VALUE; // To track the lowest price
        int minPriceIndex = -1;             // To track the index of the cheapest product

        for (int i = 0;  ; i++) {       // Infinite loop until prices are exhausted

            // Re-locate elements on every iteration to avoid StaleElementReferenceException
            priceList = getElementS(priceElements);
            addToCartBtnList = getElementS(addToCartBtnElements);

            // Exit if all products are processed
            if (i >= priceList.size()){
                break;
            }

            String priceText = getElementSAsText(priceElements, i); // Example: "$29.90"
            double price = Double.parseDouble(priceText.replace("$", "")); // Remove "$" and convert to double

            if (price < minPrice){
                minPrice = price;
                minPriceIndex = i;
            }
        }

        // Add the cheapest product to the cart
        if (minPriceIndex != -1){
            addToCartBtnList = getElementS(addToCartBtnElements);
            addToCartBtnList.get(minPriceIndex).click();
            System.out.println("Cheapest Product added to the cart. Price : $" + minPrice);
        }else {
            System.out.println("No products found.");
        }

        staticWait_Thread(2000);

    }

    public String getNumOfCartItems(){
        return getElementAsText(numOfCartItems);
    }
}
