package Shashank.WebAutomation.pages.sauceDemo;

import Shashank.WebAutomation.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sauce_CompletedPage_POM extends CommonToAllPage {
    WebDriver driver;

    public Sauce_CompletedPage_POM(WebDriver driver) {
        this.driver = driver;
    }

    private final By headingElement = By.cssSelector("[class=\"title\"]");
    private final By doneGreetingsElement = By.cssSelector("[class=\"complete-header\"]");
    private final By doneInstructionsElement = By.cssSelector("[class=\"complete-text\"]");
    private final By backToHomeBtnElement = By.id("back-to-products");


    public String getHeading(){
        visibilityOfElement(headingElement);
        return getElementAsText(headingElement);
    }

    public String getGreetings(){
        presenceOfElements(doneGreetingsElement);
        return getElementAsText(doneGreetingsElement);
    }

    public String getInstructions(){
        presenceOfElements(doneInstructionsElement);
        return getElementAsText(doneInstructionsElement);
    }

    public void clickBackToHomeBtn(){
        elementToBeClickable(backToHomeBtnElement);
        clickElement(backToHomeBtnElement);
    }



}
