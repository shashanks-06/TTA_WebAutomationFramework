package Shashank.WebAutomation.tests.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGoogle {
    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("https:www.google.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google");
        driver.quit();
    }
}
