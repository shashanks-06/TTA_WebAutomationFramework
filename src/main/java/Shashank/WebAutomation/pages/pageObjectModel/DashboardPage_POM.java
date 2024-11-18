package Shashank.WebAutomation.pages.pageObjectModel;

import Shashank.WebAutomation.base.CommonToAllPage;
import org.openqa.selenium.By;

public class DashboardPage_POM extends CommonToAllPage {

    public DashboardPage_POM() {
    }

//    Page Locators
    By usernameOnDashboard = By.cssSelector("[data-qa=\\\"lufexuloga\\\"]");

//    Page Actions
    public String loggedInUser(){
        presenceOfElements(usernameOnDashboard);
        return getElement(usernameOnDashboard).getText();
    }

}
