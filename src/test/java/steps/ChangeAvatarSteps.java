package steps;

import io.qameta.allure.Step;
import pages.AvatarPage;

public class ChangeAvatarSteps {
    AvatarPage page;

    public ChangeAvatarSteps() {
        page = new AvatarPage();
    }

    @Step("Open edit avatar page")
    public ChangeAvatarSteps openAvatarsPage() {
        page
                .openPage();
        return this;
    }

    @Step("Edit avatar image")
    public String editAvatar(String avatarNumber){
        return page.chooseNewAvatar(avatarNumber);
    }

    @Step("Check avatar change success")
    public ChangeAvatarSteps checkEdition(){
        page.checkAvatarChooseSuccess();
        return this;
    }

}
