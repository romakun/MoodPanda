package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class RateHappinesModal extends BasePage {

    private static final String SLIDER_HAPPINED_CSS = "#slider-range-min";
    private static final By UPDATE_MOOD_BUTTON = withText("Update Mood to");
    private static final String MOOD_COMMENT_AREA = ("#TextBoxUpdateMoodTag");
    private static final String MOOD_UPDATED_DONE_BUTTON = "Done";
    private static final String MOOD_UPDATED_MODAL_TITLE_TEXT = "Mood Updated";

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
        log.info("Изменяем рейтинг муда на [" + moodRate + "]");
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
        log.info("Оставляем комментарий [" + comment + "] в муде");
        $(MOOD_COMMENT_AREA).setValue(comment);
        return this;
    }

    public RateHappinesModal saveMood(){
        log.info("Жмем кнопку сохранения муда");
        $(UPDATE_MOOD_BUTTON).click();
        return this;
    }

    public int getActualRateInModal(){
        log.info("Получаем рейтинг муда в открывшемся окне");
        String buttonText = $(UPDATE_MOOD_BUTTON).getText();
        String[] rate = buttonText.split("to ");
        return Integer.parseInt(rate[1]);
    }

    public RateHappinesModal checkUpdateMoodModal(String moodComment){
        log.info("Проверяем, что модальное окно подверждения сохранения муда появилось");
        $(byText(MOOD_UPDATED_MODAL_TITLE_TEXT)).shouldBe(Condition.visible);
        log.info("Закрываем окно подверждения сохранения муда нажав кнопку Done");
        $(byText(MOOD_UPDATED_DONE_BUTTON)).click();
        log.info("Обновляем страницу");
        refresh();
        log.info("Проверяем, что на странице появился созданный муд по комментарию [" + moodComment + "]");
        $(byText(moodComment)).shouldBe(Condition.visible);
        return this;
    }
}
