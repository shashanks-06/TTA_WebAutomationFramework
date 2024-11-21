package Shashank.WebAutomation.tests.vwoTests;

import Shashank.WebAutomation.base.CommonToAllTest;
import Shashank.WebAutomation.driver.DriverManager;
import Shashank.WebAutomation.pages.pageObjectModel.DashboardPage_POM;
import Shashank.WebAutomation.pages.pageObjectModel.LoginPage_POM;
import Shashank.WebAutomation.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestVwoLoginPositive_POM extends CommonToAllTest {

    @Test
    public void test_VwoLoginPositive(){
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        loginPagePom.loginToVwo_ValidCreds(
                PropertyReader.readKey("username"), PropertyReader.readKey("password"));

        DashboardPage_POM dashboardPagePom = new DashboardPage_POM(DriverManager.getDriver());
        String dashboardName =  dashboardPagePom.loggedInUser();


        assertThat(dashboardName).isNotEmpty().isNotNull().isNotBlank();

        Assert.assertEquals(dashboardName, PropertyReader.readKey("expected_username"));
        System.out.println("Expected Username -> " +dashboardName);

        dashboardPagePom.logoutTheUser();

        String vwoLogoName = loginPagePom.verify_backToLoginPage();
        System.out.println("Vwo Logo Name -> " + vwoLogoName);

        Assert.assertEquals(vwoLogoName, PropertyReader.readKey("vwo_logo_value"));
    }
}
