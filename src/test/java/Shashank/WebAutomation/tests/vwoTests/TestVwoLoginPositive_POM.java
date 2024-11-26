package Shashank.WebAutomation.tests.vwoTests;

import Shashank.WebAutomation.base.CommonToAllTest;
import Shashank.WebAutomation.driver.DriverManager;
import Shashank.WebAutomation.pages.vwo.pageObjectModel.DashboardPage_POM;
import Shashank.WebAutomation.pages.vwo.pageObjectModel.LoginPage_POM;
import Shashank.WebAutomation.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestVwoLoginPositive_POM extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVwoLoginPositive_POM.class);

    @Test
    public void test_VwoLoginPositive(){
        logger.info("Starting the TestCase");
        logger.info("Login to VWO");
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        loginPagePom.loginToVwo_ValidCreds(
                PropertyReader.readKey("username"), PropertyReader.readKey("password"));

        logger.info("Getting the name of User on Dashboard");
        DashboardPage_POM dashboardPagePom = new DashboardPage_POM(DriverManager.getDriver());
        String dashboardName =  dashboardPagePom.loggedInUser();


        assertThat(dashboardName).isNotEmpty().isNotNull().isNotBlank();

        Assert.assertEquals(dashboardName, PropertyReader.readKey("expected_username"));
        System.out.println("Expected Username -> " +dashboardName);

        logger.info("Logout the User");
        dashboardPagePom.logoutTheUser();

        logger.info("Getting the name of Logo on LoginPage");
        String vwoLogoName = loginPagePom.verify_backToLoginPage();
        System.out.println("Vwo Logo Name -> " + vwoLogoName);

        Assert.assertEquals(vwoLogoName, PropertyReader.readKey("vwo_logo_value"));

        logger.info("Ending the TestCase");

    }
}
