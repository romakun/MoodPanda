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
    public ChangeAvatarSteps editAvatar(String avatarNumber){
        page.chooseNewAvatar(avatarNumber);
        return this;
    }

    @Step("Check avatar change success")
    public ChangeAvatarSteps checkEdition(){
        page.checkAvatarChooseSuccess();
        return this;
    }
}
