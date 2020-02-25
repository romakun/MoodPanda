package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CalendarPage extends BasePage {
    private static final String URL = "https://moodpanda.com/Feed/Calendar/?u=7660529";
    private static final String SHOW_BUTTON_CSS = "#ContentPlaceHolderContent_ButtonUpdate";
    private static final String MONTHS_CSS = ".col-md-4";


    @Override
    public CalendarPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    void isPageOpened() {
        $(SHOW_BUTTON_CSS).shouldBe(Condition.visible);
    }


    public int getMoodsCountPerDay() {
        String[] moodsPerDay = getMonthCalendar().find(byText(getActualDay())).find("span").innerText().split(" ");
        int moodsCount = 0;
        if ((moodsPerDay[0] + moodsPerDay[1]).equals("No Reasons")) {
            return moodsCount;
        } else {
            moodsCount = moodsPerDay.length;
        }
        return moodsCount;
    }

    public SelenideElement getMonthCalendar() {
        List<SelenideElement> calendar = $$(MONTHS_CSS);
        SelenideElement month = null;
        for (int i = 0; i < calendar.size(); i++) {
            if (calendar.get(i).find("span").getText().equals(getActualMonth())) {
                month = calendar.get(i);
            }
        }
        return month;
    }


    public String getActualDay() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("d");
        return dateFormat.format(date);
    }


    public String getActualMonth() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        return dateFormat.format(date);
    }
}
