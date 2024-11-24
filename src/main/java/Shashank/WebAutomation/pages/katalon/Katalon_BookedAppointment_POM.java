package Shashank.WebAutomation.pages.katalon;

import Shashank.WebAutomation.base.CommonToAllPage;
import org.openqa.selenium.*;

import java.io.File;

public class Katalon_BookedAppointment_POM extends CommonToAllPage {
    WebDriver driver;

    public Katalon_BookedAppointment_POM(WebDriver driver) {
        this.driver = driver;
    }

    private final By appointmentConfirmField = By.xpath("//div[@class=\"col-xs-12 text-center\"]/h2");
    private final By facilityField = By.cssSelector("#facility");
    private final By readmissionField = By.id("hospital_readmission");
    private final By programField = By.id("program");
    private final By dateField = By.id("visit_date");
    private final By commentField = By.id("comment");
    private final By bookedAppointmentField = By.xpath("//section[@id=\"summary\"]/div");


    public String getBookedAppointmentHeading(){
        return getElementAsText(appointmentConfirmField);
    }

    public String getFacilityName(){
        return getElementAsText(facilityField);
    }

    public String getReadmissionLabel(){
        return getElementAsText(readmissionField);
    }

    public String getProgramName(){
        return getElementAsText(programField);
    }

    public String getDate(){
        return getElementAsText(dateField);
    }

    public String getComment(){
        return getElementAsText(commentField);
    }

    public void takeScreenshotOfBooking(){
        visibilityOfElement(bookedAppointmentField);
        WebElement element = getElement(bookedAppointmentField);
        File srcFile = element.getScreenshotAs(OutputType.FILE);
        File destFile = new File("src/test/java/Shashank/WebAutomation/tests/katalonTests/Booked_Appointment_Info.png");
        srcFile.renameTo(destFile);
    }
    


}
