package Shashank.WebAutomation.pages.pageObjectModel;

import Shashank.WebAutomation.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage_POM extends CommonToAllPage {

    WebDriver driver;

    public DashboardPage_POM(WebDriver driver) {
        this.driver = driver;
    }

//    Page Locators
    By usernameOnDashboard = By.cssSelector("span[class='Fw(semi-bold) ng-binding']");
    By userIcon = By.xpath("//button[@title=\"User menu\"]/img[@data-qa=\"user-image\"]");
    By logoutBtn = By.cssSelector("[data-qa=\"logout-btn\"]");

//    Page Actions
    public String loggedInUser() {
        staticWait_Thread(3000);
        visibilityOfElement(usernameOnDashboard);
        return getElement(usernameOnDashboard).getText();
    }

    public void logoutTheUser(){
        presenceOfElements(userIcon);
        clickElement(userIcon);

        staticWait_Thread(2000);

        presenceOfElements(logoutBtn);
        clickElement(logoutBtn);


    }

}
