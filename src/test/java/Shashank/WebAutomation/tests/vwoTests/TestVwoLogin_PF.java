package Shashank.WebAutomation.tests.vwoTests;

import Shashank.WebAutomation.base.CommonToAllTest;
import Shashank.WebAutomation.driver.DriverManager;
import Shashank.WebAutomation.pages.vwo.pageFactory.LoginPage_PF;
import Shashank.WebAutomation.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestVwoLogin_PF extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVwoLogin_PF.class);

    @Test
    public void test_LoginVwoNegative_PF(){

        logger.info("Starting the TestCase");
        LoginPage_PF loginPagePf = new LoginPage_PF(DriverManager.getDriver());

        logger.info("Opening the URL");
        String errorMsgText = loginPagePf.loginToVwo_InvalidCreds(
                PropertyReader.readKey("invalid_username"), PropertyReader.readKey("invalid_password"));

        logger.info("Verifying the Error message in the field :-> " +errorMsgText);
        assertThat(errorMsgText).isNotNull().isNotEmpty().isNotBlank();


        Assert.assertEquals(errorMsgText, PropertyReader.readKey("error_message"));

    }
}
