package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class RateHappinesModal extends BasePage {

    private static final String SLIDER_HAPPINED_CSS = "#slider-range-min";
    private static final String SLIDER_LOCATOR = ".ui-slider-range-min";

    @Override
    RateHappinesModal openPage() {
        return this;
    }

    @Override
    void isPageOpened() {
        $(SLIDER_HAPPINED_CSS).shouldBe(Condition.visible);
    }

    public RateHappinesModal updateMood(int moodRate, String comment){
        String style = $(SLIDER_LOCATOR).getAttribute("Class");
        String[] rate = style.split("badge-");
        int defRate = Integer.parseInt(rate[1]);
        int difference = moodRate - defRate;
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

}
