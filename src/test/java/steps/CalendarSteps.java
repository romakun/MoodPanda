package steps;


import io.qameta.allure.Step;
import pages.CalendarPage;

import static org.testng.Assert.assertEquals;

public class CalendarSteps {
    CalendarPage page;
    int moodsCount;

    public CalendarSteps() {
        page = new CalendarPage();
    }

    @Step("Open calendar page")
    public CalendarSteps openCalendarPage() {
        page
                .openPage();
        return this;
    }

    @Step
    public CalendarSteps checkMoodCountPerDay() {
        moodsCount = page.getMoodsCountPerDay();
        return this;
    }

    @Step
    public CalendarSteps checkMoodCountAfterUpdateMood() {
        assertEquals(page.getMoodsCountPerDay() - 1, moodsCount, "Количество мудов не изменилось");
        return this;
    }
}
