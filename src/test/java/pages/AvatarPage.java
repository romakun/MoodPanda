package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AvatarPage extends BasePage {

    private static final String URL = "https://moodpanda.com/Account/Avatar/";
    private static final String AVATAR_CSS = "#ContentPlaceHolderContent_RepeaterImage_ImageButton1_";
    private static final String SUCCESS_ALERT_MESSAGE = "Success!";

    @Override
    public AvatarPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    void isPageOpened() {
        $(AVATAR_CSS + "5").shouldBe(Condition.visible);
    }

    public AvatarPage chooseNewAvatar(String avatarNumber){
        if (Integer.parseInt(avatarNumber) < $$("input[type=image]").size()){
            $(AVATAR_CSS + avatarNumber).click();
        } else {
            Assert.fail("Воу воу воу, такого количества аватарок нет в системе");
        }
        return this;
    }

    public AvatarPage checkAvatarChooseSuccess(){
        $(byText(SUCCESS_ALERT_MESSAGE)).shouldBe(Condition.visible);
        return this;
    }


}
