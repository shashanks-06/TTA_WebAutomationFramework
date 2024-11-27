package Shashank.WebAutomation.tests.sauceTests;

import Shashank.WebAutomation.base.CommonToAllTest;
import Shashank.WebAutomation.driver.DriverManager;
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

        sauceDashboardPom.selectCheapProduct();
        String cartItemsNum = sauceDashboardPom.getNumOfCartItems();
        System.out.println("Number of cart items : " + cartItemsNum);
        Assert.assertEquals(cartItemsNum, "1");
    }

}
