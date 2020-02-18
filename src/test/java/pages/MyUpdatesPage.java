package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementShould;
import com.codeborne.selenide.ex.ListSizeMismatch;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MyUpdatesPage extends BasePage {

    private static final String URL = "https://moodpanda.com/Feed/?Me=1";
    private static final String MY_TOOL_BAR_CSS = "#ContentPlaceHolderContent_MyMoodPandaNav1_UserStats";
    private static final String UPDATE_MOOD_CSS = "#LinkUpdate";
    private static final String MY_MOOD_BLOCKS_CSS = ".rounded-top-corner";
    private static final String MY_MOOD_TRASH_BUTTON_CSS = ".ButtonDelete";
    private static final String MY_MOOD_COMMENT_ICONS_CSS = ".addcomment";
    private static final String COMMENT_BLOCK_CSS = "#ContentPlaceHolderContent_RepeaterFeed_PanelNewComment_";
    private static final String BUTTON_REPLY_CSS = ".ButtonReply";
    private static final String MY_MOOD_HUG_ICONS = ".ButtonHug";
    private static final String MY_MOOD_FOLLOW_ICON = ".FeedFollow";

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

    public RateHappinesModal clickUpdateMood() {
        $(UPDATE_MOOD_CSS).click();
        RateHappinesModal modal = new RateHappinesModal();
        modal.isPageOpened();
        return modal;
    }

    public void deleteMood(int moodNumber) {
        int moodsCount = $$(MY_MOOD_BLOCKS_CSS).size();
        getMoodByNumber(moodNumber).find(MY_MOOD_TRASH_BUTTON_CSS).click();
        refresh();
        try {
            $$(MY_MOOD_BLOCKS_CSS).shouldHaveSize(moodsCount - 1);
        } catch (ListSizeMismatch e) {
            System.out.println("Количество moods не изменилось");
        }
    }



    public void addComment(int moodNumber, String comment){
        getMoodByNumber(moodNumber)
                .find(MY_MOOD_COMMENT_ICONS_CSS)
                .click();
        int commentsCount = Integer.parseInt(getMoodByNumber(moodNumber).find(".mccomments" + moodNumber).getText());

        $(COMMENT_BLOCK_CSS + (moodNumber - 1))
                .shouldBe(Condition.visible)
                .find("textarea")
                .setValue(comment);
        $(COMMENT_BLOCK_CSS + (moodNumber - 1))
                .find(BUTTON_REPLY_CSS)
                .click();
         try {
            getMoodByNumber(moodNumber).find(".mccomments" + moodNumber).shouldBe(Condition.text("" + (commentsCount + 1)));
        } catch (ElementShould e){
             System.out.println("Что-то пошло не так и количество комментариев не увеличилось на 1");
         }
    }

    public void addHugs(int moodNumber){
        int commentHugsCount = $$(byText("*Hugs*")).size();
        getMoodByNumber(moodNumber)
                .find(MY_MOOD_HUG_ICONS)
                .click();
        try {
            $$(byText("*Hugs*")).shouldHaveSize(commentHugsCount + 1);
        } catch (ListSizeMismatch e){
            System.out.println("Количество обнимашек не увеличилось на 1");
        }
    }

    public SelenideElement getMoodByNumber(int desiredMoodNumber) {
        List<SelenideElement> moods = $$(MY_MOOD_BLOCKS_CSS);
        SelenideElement mood = null;
        for (int i = 0; i < moods.size(); i++) {
            String moodClassName = moods.get(i).getAttribute("Class");
            String moodNumberString = moodClassName.split(" ")[2].replaceAll("[^0-9]", "");
            int moodNumber = Integer.parseInt(moodNumberString);
            if (moodNumber == desiredMoodNumber) {
                mood = moods.get(i);
            }
        }
        return mood;
    }
}
