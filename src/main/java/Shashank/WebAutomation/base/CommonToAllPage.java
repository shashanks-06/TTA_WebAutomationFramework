package Shashank.WebAutomation.base;

import Shashank.WebAutomation.driver.DriverManager;
import Shashank.WebAutomation.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Shashank.WebAutomation.driver.DriverManager.getDriver;

public class CommonToAllPage {

    public CommonToAllPage() {
        // If you want to call something before every Page Object Class call, Put your Code here");
        // Open File, Open Data Base Connection You can write code here
    }

    public void openVwoLoginUrl(){
        getDriver().get(PropertyReader.readKey("vwoUrl"));
    }

    public void openKatalonUrl(){
        getDriver().get(PropertyReader.readKey("katalon_url"));
    }

    public void clickElement(By by){
        getDriver().findElement(by).click();
    }
    public void clickElement(WebElement element){
        element.click();
    }

    public void enterInput(By by, String key){
        getDriver().findElement(by).sendKeys(key);
    }
    public void enterInput(WebElement element, String key){
        element.sendKeys(key);
    }

    // Wait Explicits here

    public WebElement presenceOfElements(By elementLocation){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }


//    To get Elements
    public WebElement getElement(By key){
        return getDriver().findElement(key);
    }

//    Static wait -> Thread.sleep()
    public void staticWait_Thread(int timeInMilliSeconds){
        try {
            Thread.sleep(timeInMilliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectClass_dropdownSelection(WebElement dropdownElement, int index){
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }
    public void selectClass_dropdownSelection(WebElement dropdownElement, WebElement byValue){
        Select select = new Select(dropdownElement);
        select.selectByValue(byValue.getAttribute("value"));
    }
    public void selectClass_dropdownSelection(WebElement dropdownElement, String byVisibleText){
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(byVisibleText);
    }


}
