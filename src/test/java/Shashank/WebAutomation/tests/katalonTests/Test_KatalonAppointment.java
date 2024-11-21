package Shashank.WebAutomation.tests.katalonTests;

import Shashank.WebAutomation.base.CommonToAllTest;
import Shashank.WebAutomation.driver.DriverManager;
import Shashank.WebAutomation.pages.katalon.Katalon_AppointmentPage_POM;
import Shashank.WebAutomation.pages.katalon.Katalon_HomePage_POM;
import Shashank.WebAutomation.pages.katalon.Katalon_LoginPage_POM;
import Shashank.WebAutomation.utils.PropertyReader;
import org.testng.annotations.Test;

public class Test_KatalonAppointment extends CommonToAllTest {

    @Test
    public void test_appointment(){
        Katalon_HomePage_POM katalonHomePagePom = new Katalon_HomePage_POM(DriverManager.getDriver());
        String nameOfHeading = katalonHomePagePom.makeAnAppointment();
        System.out.println("Name Of Heading -> "  + nameOfHeading);

        Katalon_LoginPage_POM katalonLoginPagePom = new Katalon_LoginPage_POM(DriverManager.getDriver());
        katalonLoginPagePom.loginToKatalon();

        Katalon_AppointmentPage_POM katalonAppointmentPagePom = new Katalon_AppointmentPage_POM(
                DriverManager.getDriver());
        katalonAppointmentPagePom.bookAppointment(
                PropertyReader.readKey("katalon_date"),
                PropertyReader.readKey("katalon_comment")
        );
    }
}
