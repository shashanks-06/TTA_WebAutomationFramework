package Shashank.WebAutomation.tests.vwoTests;

import Shashank.WebAutomation.base.CommonToAllTest;
import Shashank.WebAutomation.driver.DriverManager;
import Shashank.WebAutomation.pages.vwo.pageObjectModel.LoginPage_POM;
import Shashank.WebAutomation.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestVwoLogin_POM extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVwoLogin_POM.class);

    @Test
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
