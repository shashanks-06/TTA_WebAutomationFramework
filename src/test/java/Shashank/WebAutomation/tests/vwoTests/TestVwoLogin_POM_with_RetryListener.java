package Shashank.WebAutomation.tests.vwoTests;

import Shashank.WebAutomation.base.CommonToAllTest;
import Shashank.WebAutomation.driver.DriverManager;
import Shashank.WebAutomation.listeners.RetryAnalyzer;
import Shashank.WebAutomation.pages.pageObjectModel.LoginPage_POM;
import Shashank.WebAutomation.utils.PropertyReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVwoLogin_POM_with_RetryListener extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVwoLogin_POM_with_RetryListener.class);


    @Owner("Shashank")
    @Description("TC1 - Verify with the invalid login, error message is displayed.")
    @Test(retryAnalyzer = RetryAnalyzer.class)      // To retry the test using RetryListener
    public void test_LoginNegativeVwo(){
        logger.info("Starting the TestCase");
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());

        logger.info("Opening the URL");
        String errorMsgText = loginPagePom.loginToVwo_InvalidCreds(
                PropertyReader.readKey("invalid_username"), PropertyReader.readKey("invalid_password"));


        logger.info("Verifying the Error message in the field :-> " +errorMsgText);
//        AssertJ
        assertThat(errorMsgText).isNotEmpty().isNotBlank().isNotNull();

//        TestNG Assertions
        Assert.assertEquals(errorMsgText, PropertyReader.readKey("error_message"));


    }



}
