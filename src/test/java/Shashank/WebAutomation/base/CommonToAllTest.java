package Shashank.WebAutomation.base;

import Shashank.WebAutomation.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class CommonToAllTest {

    @BeforeTest
    public void setUp(){
        DriverManager.init();
    }


    @AfterTest
    public void tearDown(){
        DriverManager.down();
    }

}
