package tests;

import org.testng.annotations.Test;

public class CalendarTest extends BaseTest {

    @Test
    public void checkCalendarTest() {
        loginSteps.login("gotestweb@mailinator.com", "12345678");
        calendarsteps
                .openCalendarPage()
                .checkMoodCountPerDay();
        moodSteps
                .openMyUpdatesPage()
                .updateMood(10, "Best_DAY!");
        calendarsteps
                .openCalendarPage()
                .checkMoodCountAfterUpdateMood();
    }
}
