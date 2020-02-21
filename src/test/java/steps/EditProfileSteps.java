package steps;

import io.qameta.allure.Step;
import models.LoginDetailsModel;
import models.PersonalInfoModel;
import pages.EditProfilePage;

public class EditProfileSteps {

    EditProfilePage page;

    public EditProfileSteps() {
        page = new EditProfilePage();
    }

    @Step("Open edit profile page")
    public EditProfileSteps openEditProfilePage() {
        page
                .openPage();
        return this;
    }

    @Step("Type new Data in profile")
    public EditProfileSteps typeNewData(PersonalInfoModel options) {
        page.updatePersonalInfo(options);
        return this;
    }

    @Step("Type new Login details data")
    public EditProfileSteps typeNewDetails(LoginDetailsModel data){
        page.updateLoginDetails(data);
        return this;
    }

    @Step("Save new data in profile")
    public EditProfileSteps saveDataInProfile(){
        page.saveProfileEditions();
        return this;
    }
}
