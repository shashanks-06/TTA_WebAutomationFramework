package Shashank.WebAutomation.tests.sample;

import Shashank.WebAutomation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestVwoLogin {

    @BeforeTest
    public void setUp(){
        DriverManager.init();
    }


    @Test
    public void test_LoginNegativeVwo() throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();

        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

        driver.findElement(By.id("login-username")).sendKeys("admin@admin.com");
        driver.findElement(By.id("login-password")).sendKeys("admin");
        driver.findElement(By.id("js-login-btn")).click();

        Thread.sleep(3000);

        String errorMsg = driver.findElement(By.id("js-notification-box-msg")).getText();
        System.out.println(errorMsg);
        Assert.assertEquals(errorMsg, "Your email, password, IP address or location did not match");

        driver.quit();
    }
}
