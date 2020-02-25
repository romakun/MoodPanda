package pages;


import com.codeborne.selenide.Condition;

import org.testng.Assert;
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

    public String chooseNewAvatar(String avatarNumber){
        String src = null;
        if (Integer.parseInt(avatarNumber) < $$("input[type=image]").size()){
            $(AVATAR_CSS + avatarNumber).click();
            src = $(AVATAR_CSS + avatarNumber).getAttribute("src");
        } else {
            Assert.fail("Воу воу воу, такого количества аватарок нет в системе");
        }
        return src;
    }

    public AvatarPage checkAvatarChooseSuccess(){
        $(byText(SUCCESS_ALERT_MESSAGE)).shouldBe(Condition.visible);
        return this;
    }


}
