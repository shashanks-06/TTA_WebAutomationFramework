package Shashank.WebAutomation.tests.katalonTests;

import Shashank.WebAutomation.base.CommonToAllTest;
import Shashank.WebAutomation.driver.DriverManager;
import Shashank.WebAutomation.pages.katalon.Katalon_AppointmentPage_POM;
import Shashank.WebAutomation.pages.katalon.Katalon_BookedAppointment_POM;
import Shashank.WebAutomation.pages.katalon.Katalon_HomePage_POM;
import Shashank.WebAutomation.pages.katalon.Katalon_LoginPage_POM;
import Shashank.WebAutomation.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Test_KatalonAppointment extends CommonToAllTest {

//    For Logging Purpose using Log4J
    private static final Logger logger = LogManager.getLogger(Test_KatalonAppointment.class);

    @Test
    public void test_appointment(){

        logger.info("Starting the Booking of Hospital Appointment");

        Katalon_HomePage_POM katalonHomePagePom = new Katalon_HomePage_POM(DriverManager.getDriver());
        String nameOfHeading = katalonHomePagePom.makeAnAppointment();
        System.out.println(nameOfHeading);

        Katalon_LoginPage_POM katalonLoginPagePom = new Katalon_LoginPage_POM(DriverManager.getDriver());
        katalonLoginPagePom.loginToKatalon();

        Katalon_AppointmentPage_POM katalonAppointmentPagePom = new Katalon_AppointmentPage_POM(
                DriverManager.getDriver());
        katalonAppointmentPagePom.bookAppointment(
                PropertyReader.readKey("katalon_date"),
                PropertyReader.readKey("katalon_monthYear"),
                PropertyReader.readKey("katalon_comment")
        );

        System.out.println();

        Katalon_BookedAppointment_POM katalonBookedAppointmentPom = new Katalon_BookedAppointment_POM(
                DriverManager.getDriver());
        String headingOfBookedAppointment = katalonBookedAppointmentPom.getBookedAppointmentHeading();
        assertThat(headingOfBookedAppointment).isEqualTo(PropertyReader.readKey("katalon_appointmentConfirmation"));
        System.out.println(headingOfBookedAppointment);

        System.out.println();

        String nameOfFacility = katalonBookedAppointmentPom.getFacilityName();
        Assert.assertEquals(nameOfFacility, PropertyReader.readKey("katalon_expectedFacility"));
        System.out.println("Facility : " + nameOfFacility);

        String isReadmission = katalonBookedAppointmentPom.getReadmissionLabel();
        assertThat(isReadmission).isEqualTo(PropertyReader.readKey("katalon_expectedReadmission"));
        System.out.println("Readmission : " +  isReadmission);

        String nameOfProgram = katalonBookedAppointmentPom.getProgramName();
        assertThat(nameOfProgram).isEqualTo(PropertyReader.readKey("katalon_expectedProgram"));
        System.out.println("Healthcare Program : " +  nameOfProgram);

        String dateOfProgram = katalonBookedAppointmentPom.getDate();
        assertThat(dateOfProgram).isEqualTo(PropertyReader.readKey("katalon_expectedDate"));
        System.out.println("Visit Date : " +  dateOfProgram);


        String addedComment = katalonBookedAppointmentPom.getComment();
        assertThat(addedComment).isEqualTo(PropertyReader.readKey("katalon_expectedComment"));
        System.out.println("Comment : " +  addedComment);

        logger.info("Successfully Done Booking Hospital");
    }
}
