package Shashank.WebAutomation.pages.katalon;

import Shashank.WebAutomation.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Katalon_HomePage_POM extends CommonToAllPage {
    WebDriver driver;

    public Katalon_HomePage_POM(WebDriver driver) {
        this.driver = driver;
    }

    private final By appointmentBtn = By.id("btn-make-appointment");
    private  final By heading = By.xpath("//div[@class=\"text-vertical-center\"]/h1");

    public String makeAnAppointment(){

        openKatalonUrl();

        presenceOfElements(heading);

        String headingName = getElement(heading).getText();

        clickElement(appointmentBtn);

        staticWait_Thread(3000);

        return headingName;
    }

}
