package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyUpdatesPage extends BasePage{

    private static final String URL = "https://moodpanda.com/Feed/?Me=1";
    private static final String MY_TOOL_BAR_CSS = "#ContentPlaceHolderContent_MyMoodPandaNav1_UserStats";
    private static final String UPDATE_MOOD_CSS = "#LinkUpdate";

    @Override
    public MyUpdatesPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    void isPageOpened() {
        $(MY_TOOL_BAR_CSS).shouldBe(Condition.visible);
    }

    public RateHappinesModal clickUpdateMood(/*int moodRate, String comment*/){
        $(UPDATE_MOOD_CSS).click();
        RateHappinesModal modal = new RateHappinesModal();
        modal.isPageOpened();
        return modal;
    }

}
