package Shashank.WebAutomation.tests.sauceTests;

import Shashank.WebAutomation.base.CommonToAllTest;
import Shashank.WebAutomation.driver.DriverManager;
import Shashank.WebAutomation.pages.sauceDemo.*;
import Shashank.WebAutomation.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Test_SwagLabs extends CommonToAllTest {

    Sauce_LoginPage_POM sauceLoginPage;
    Sauce_Dashboard_POM sauceDashboardPom;
    Sauce_CartPage_POM sauceCartPagePom;
    Sauce_CheckoutPage_POM sauceCheckoutPagePom;
    Sauce_CheckoutPage2_POM sauceCheckoutPage2Pom;

    private String cheapestProductName;
    private String cheapestProductPrice;

    @Test
    public void test_LoginToSwagLabs(){
        sauceLoginPage = new Sauce_LoginPage_POM(DriverManager.getDriver());
        String headingOfLoginPage = sauceLoginPage.loginToSwagLabs();
        System.out.println("Heading Of Login Page -> " + headingOfLoginPage);

        Assert.assertEquals(headingOfLoginPage, PropertyReader.readKey("sauce_expectedHeadingName"));

        sauceLoginPage.setInputFieldsToLogin();
    }



    @Test(dependsOnMethods = "test_LoginToSwagLabs")
    public void test_DashboardOfSwagLabs(){
        sauceDashboardPom = new Sauce_Dashboard_POM(DriverManager.getDriver());
        System.out.println(sauceDashboardPom.getHeading());
        Assert.assertEquals(sauceDashboardPom.getHeading(), PropertyReader.readKey("sauce_expectedHeadingName"));

        String[] cheapestProductDetails = sauceDashboardPom.selectCheapProduct();
        cheapestProductName = cheapestProductDetails[0];
        cheapestProductPrice = cheapestProductDetails[1];

        String cartItemsNum = sauceDashboardPom.getNumOfCartItems();
        System.out.println("Number of cart items : " + cartItemsNum);


        Assert.assertEquals(cartItemsNum, PropertyReader.readKey("sauce_expectedCartItemsNum"));

        sauceDashboardPom.clickOnCartBtn();

    }



    @Test(dependsOnMethods = "test_DashboardOfSwagLabs")
    public void test_CartPageOfSwagLabs(){
        sauceCartPagePom = new Sauce_CartPage_POM(DriverManager.getDriver());

        String yourCartHeading = sauceCartPagePom.getYourCartHeading();
        System.out.println("Your cart heading : " + yourCartHeading);
        Assert.assertEquals(yourCartHeading, PropertyReader.readKey("sauce_expectedYourCartHeading"));

        String cartItemName = sauceCartPagePom.getCartItemName();
        String cartItemPrice = sauceCartPagePom.getCartItemPrice();

        Assert.assertEquals(cartItemName, cheapestProductName);
        assertThat(cartItemPrice).isEqualTo(cheapestProductPrice);

        System.out.println("Cart Item Selected and Item in the Cart is Same.");

        sauceCartPagePom.clickCheckoutBtn();
    }


    @Test(dependsOnMethods = "test_CartPageOfSwagLabs")
    public void test_CheckoutPageOfSwagLabs(){
        sauceCheckoutPagePom = new Sauce_CheckoutPage_POM(DriverManager.getDriver());
        String checkoutHeadingName = sauceCheckoutPagePom.getCheckoutHeadingName();
        Assert.assertEquals(checkoutHeadingName, PropertyReader.readKey("sauce_expectedCheckoutHeadingName"));
        System.out.println("Checkout page Heading Name: " + checkoutHeadingName);

        sauceCheckoutPagePom.setInputFields(
                PropertyReader.readKey("sauce_firstname"),
                PropertyReader.readKey("sauce_lastname"),
                PropertyReader.readKey("sauce_postalCode")
        );
        sauceCheckoutPagePom.clickOnContinueBtn();
    }

    @Test(dependsOnMethods = "test_CheckoutPageOfSwagLabs")
    public void test_CheckoutPage2OfSwagLabs(){
        sauceCheckoutPage2Pom = new Sauce_CheckoutPage2_POM(DriverManager.getDriver());

        System.out.println("Sauce CheckoutPage 2 Heading -> " + sauceCheckoutPage2Pom.getHeading());
        assertThat(sauceCheckoutPage2Pom.getHeading()).isEqualTo(PropertyReader.readKey("sauce_expectedCheckout2HeadingName"));

        assertThat(sauceCheckoutPage2Pom.getProductName()).isEqualTo(cheapestProductName);
        System.out.println("Cart Item Selected and Checkout Item is Same.");
        System.out.println("Product Name: " + sauceCheckoutPage2Pom.getProductName());

        assertThat(sauceCheckoutPage2Pom.getProductPrice()).isEqualTo(cheapestProductPrice);
        System.out.println("Selected Cart Item Price and Checkout Item Price is Same.");
        System.out.println("Product Price: " + sauceCheckoutPage2Pom.getProductPrice());

        assertThat(sauceCheckoutPage2Pom.getPaymentInfo()).isEqualTo(PropertyReader.readKey("sauce_paymentInfo"));
        System.out.println("Payment Information: " + sauceCheckoutPage2Pom.getPaymentInfo());

        assertThat(sauceCheckoutPage2Pom.getShippingInfo()).isEqualTo(PropertyReader.readKey("sauce_shippingInfo"));
        System.out.println("Shipping Information: " + sauceCheckoutPage2Pom.getShippingInfo());

        String totalPriceWithTax = String.valueOf(sauceCheckoutPage2Pom.getTotalPriceWithTax());
        String totalPrice = String.valueOf(sauceCheckoutPage2Pom.getTotalPrice());

        Assert.assertEquals(totalPrice, totalPriceWithTax);
        System.out.println("Total Price: $" + totalPrice);

        sauceCheckoutPage2Pom.clickOnFinish();

        System.out.println("Successfully Done Checking Out the Product!!");
    }
}
