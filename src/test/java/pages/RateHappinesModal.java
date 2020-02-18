package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class RateHappinesModal extends BasePage {

    private static final String SLIDER_HAPPINED_CSS = "#slider-range-min";
    private static final By UPDATE_MOOD_BUTTON = withText("Update Mood to");
    private static final String MOOD_COMMENT_AREA = ("#TextBoxUpdateMoodTag");

    @Override
    RateHappinesModal openPage() {
        return this;
    }

    @Override
    void isPageOpened() {
        $(SLIDER_HAPPINED_CSS).shouldBe(Condition.visible);
    }

    public RateHappinesModal updateMoodRate(int moodRate){
        int difference = moodRate - getActualRateInModal();
        Keys key;

        if(difference < 0) {
            key  = Keys.ARROW_LEFT;
        } else {
            key = Keys.ARROW_RIGHT;
        }

        for(int i = 0; i < Math.abs(difference); i++) {
            $(By.id("slider-range-min")).find("a").sendKeys(key);
        }

        return this;
    }

    public RateHappinesModal writeCommentInMoodModal(String comment){
        $(MOOD_COMMENT_AREA).sendKeys(comment);
        return this;
    }

    public RateHappinesModal saveMood(){
        $(UPDATE_MOOD_BUTTON).click();
        return this;
    }

    public int getActualRateInModal(){
        String buttonText = $(UPDATE_MOOD_BUTTON).getText();
        String[] rate = buttonText.split("to ");
        return Integer.parseInt(rate[1]);
    }


}
