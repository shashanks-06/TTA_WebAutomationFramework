package Shashank.WebAutomation.tests.sauceTests;

import Shashank.WebAutomation.base.CommonToAllTest;
import Shashank.WebAutomation.driver.DriverManager;
import Shashank.WebAutomation.pages.sauceDemo.Sauce_CartPage_POM;
import Shashank.WebAutomation.pages.sauceDemo.Sauce_Dashboard_POM;
import Shashank.WebAutomation.pages.sauceDemo.Sauce_LoginPage_POM;
import Shashank.WebAutomation.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_SwagLabs extends CommonToAllTest {

    @Test
    public void test_SwagLabs(){
        Sauce_LoginPage_POM sauceLoginPage = new Sauce_LoginPage_POM(DriverManager.getDriver());
        String headingOfLoginPage = sauceLoginPage.loginToSwagLabs();
        System.out.println("Heading Of Login Page -> " + headingOfLoginPage);

        Assert.assertEquals(headingOfLoginPage, PropertyReader.readKey("sauce_expectedHeadingName"));

        Sauce_Dashboard_POM sauceDashboardPom = new Sauce_Dashboard_POM(DriverManager.getDriver());
        System.out.println(sauceDashboardPom.getHeading());
        Assert.assertEquals(sauceDashboardPom.getHeading(), PropertyReader.readKey("sauce_expectedHeadingName"));

        String cheapestProduct = sauceDashboardPom.selectCheapProduct();
        String cartItemsNum = sauceDashboardPom.getNumOfCartItems();
        System.out.println("Number of cart items : " + cartItemsNum);
        Assert.assertEquals(cartItemsNum, PropertyReader.readKey("sauce_expectedCartItemsNum"));

        sauceDashboardPom.clickOnCartBtn();

        Sauce_CartPage_POM sauceCartPagePom = new Sauce_CartPage_POM(DriverManager.getDriver());

        String yourCartHeading = sauceCartPagePom.getYourCartHeading();
        System.out.println("Your cart heading : " + yourCartHeading);
        Assert.assertEquals(yourCartHeading, PropertyReader.readKey("sauce_expectedYourCartHeading"));

        String cartItemName = sauceCartPagePom.getCartItemName();
        Assert.assertEquals(cartItemName, cheapestProduct);
        System.out.println("Cart Item Selected and Item in the Cart is Same.");


    }

}
