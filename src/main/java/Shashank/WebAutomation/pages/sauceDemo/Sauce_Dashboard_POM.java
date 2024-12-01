package Shashank.WebAutomation.pages.sauceDemo;

import Shashank.WebAutomation.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class Sauce_Dashboard_POM extends CommonToAllPage {
    WebDriver driver;

    public Sauce_Dashboard_POM(WebDriver driver){
        this.driver = driver;
    }

    private final By headingOfDashboard = By.className("app_logo");
    private final By priceElements = By.className("inventory_item_price");
    private final By productElements = By.cssSelector("[class=\"inventory_item_name \"]");
    private final By addToCartBtnElements = By.cssSelector("[class=\"btn btn_primary btn_small btn_inventory \"]");
    private final By numOfCartItems = By.className("shopping_cart_badge");
    private final By cartBtnElement = By.cssSelector("[class=\"shopping_cart_link\"]");

    public String getHeading(){
        return getElementAsText(headingOfDashboard);
    }

    public String[] selectCheapProduct(){

        List<WebElement> priceList;
        List<WebElement> addToCartBtnList;
        List<WebElement> productsList;
        String cheapestProductName = null;
        String cheapestProductPrice = null;

        double minPrice = Double.MAX_VALUE; // To track the lowest price
        int minPriceIndex = -1;             // To track the index of the cheapest product

        for (int i = 0;  ; i++) {       // Infinite loop until prices are exhausted

            // Re-locate elements on every iteration to avoid StaleElementReferenceException
            priceList = getElementS(priceElements);
            addToCartBtnList = getElementS(addToCartBtnElements);
            productsList = getElementS(productElements);

            // Exit if all products are processed
            if (i >= priceList.size()){
                break;
            }

            cheapestProductPrice = getElementSAsText(priceElements, i); // Example: "$29.90"
            double price = Double.parseDouble(cheapestProductPrice.replace("$", "")); // Remove "$" and convert to double

            if (price < minPrice){
                minPrice = price;
                minPriceIndex = i;
            }
        }

        // Add the cheapest product to the cart
        if (minPriceIndex != -1){
            productsList = getElementS(productElements);
            cheapestProductName = productsList.get(minPriceIndex).getText();
            cheapestProductPrice = priceList.get(minPriceIndex).getText();
            addToCartBtnList = getElementS(addToCartBtnElements);
            addToCartBtnList.get(minPriceIndex).click();
            System.out.println("Cheapest Product '"+ cheapestProductName +"' added to the cart. Price : " + cheapestProductPrice);
        }else {
            System.out.println("No products found.");
        }

        return new String[]{cheapestProductName, cheapestProductPrice};
    }

    public String getNumOfCartItems(){
        return getElementAsText(numOfCartItems);
    }

    public void clickOnCartBtn(){
        clickElement(cartBtnElement);
        staticWait_Thread(2000);
    }
}
