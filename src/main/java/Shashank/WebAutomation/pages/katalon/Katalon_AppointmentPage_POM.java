package Shashank.WebAutomation.pages.katalon;

import Shashank.WebAutomation.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Katalon_AppointmentPage_POM extends CommonToAllPage {
    WebDriver driver;

    public Katalon_AppointmentPage_POM(WebDriver driver) {
        this.driver = driver;
    }

    private final By appointmentHeading = By.xpath("//h2[normalize-space()='Make Appointment']");
    private final By facilityDropdown = By.id("combo_facility");
    private final By checkbox = By.id("chk_hospotal_readmission");
    private final By radioBtn = By.id("radio_program_medicaid");
    private final By calendarInputField = By.id("txt_visit_date");
    private final By nextMonthBtn = By.cssSelector("div[class='datepicker-days'] th[class='next']");
    private final By prevMonthBtn = By.cssSelector("div[class='datepicker-days'] th[class='prev']");
    private final By commentTextarea = By.id("txt_comment");
    private final By bookAppointmentBtn = By.id("btn-book-appointment");


    public void bookAppointment(String date, String monthYear, String comments){
        presenceOfElements(appointmentHeading);

        clickElement(facilityDropdown);
        selectClass_dropdownSelection(getElement(facilityDropdown), 1);
        clickElement(facilityDropdown);

        clickElement(checkbox);
        clickElement(radioBtn);

//        clickElement(calendarInputField);
//        clickElement(nextMonthBtn);
//        selectDate(date);

        calendarDateSelection(calendarInputField, nextMonthBtn,
                date, monthYear);

        enterInput(commentTextarea, comments);

        clickElement(bookAppointmentBtn);

        staticWait_Thread(3000);

    }

//    public void selectDate(String date){
//        driver.findElement(By.xpath("//td[normalize-space()='" + date + "']")).click();
//    }
}
