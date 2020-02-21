package pages;

import com.codeborne.selenide.Condition;
import models.LoginDetailsModel;
import models.PersonalInfoModel;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EditProfilePage extends BasePage {

    private static final String URL = "https://moodpanda.com/Account/";
    private static final String UPDATE_DETAILS_BUTTON_CSS = "#ContentPlaceHolderContent_ButtonSave";
    private static final String EMAIL_ADDRESS_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxEmail";
    private static final String NEW_PASSWORD_INPUT_SCC = "#ContentPlaceHolderContent_TextBoxNewPassword";
    private static final String CONFIRM_NEW_PASSWORD_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxNewPasswordConfirm";
    private static final String FIRST_NAME_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxFirstname";
    private static final String SURNAME_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxSurname";
    private static final String YEAR_OF_BIRTH_SELECTOR_CSS = "#ContentPlaceHolderContent_DropDownListYearOfBirth";
    private static final String GENDER_SELECTOR_CSS = "#ContentPlaceHolderContent_DropDownListGender";
    private static final String SUCCESS_ALERT_MESSAGE = "Success!";


    @Override
    public EditProfilePage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    void isPageOpened() {
        $(UPDATE_DETAILS_BUTTON_CSS).shouldBe(Condition.visible);
    }

    public void updatePersonalInfo(PersonalInfoModel options) {
        $(FIRST_NAME_INPUT_CSS).setValue(options.getFirstName());
        $(SURNAME_INPUT_CSS).setValue(options.getSurnameInitial());
        $(YEAR_OF_BIRTH_SELECTOR_CSS).selectOption(options.getYearOfBirth());
        $(GENDER_SELECTOR_CSS).selectOption(options.getGender());
    }

    public void updateLoginDetails(LoginDetailsModel data){
        $(EMAIL_ADDRESS_INPUT_CSS).setValue(data.getEmailAddress());
        $(NEW_PASSWORD_INPUT_SCC).setValue(data.getNewPassword());
        $(CONFIRM_NEW_PASSWORD_INPUT_CSS).setValue(data.getNewPassword());
    }

    public void saveProfileEditions(){
        $(UPDATE_DETAILS_BUTTON_CSS).click();
        $(byText(SUCCESS_ALERT_MESSAGE)).shouldBe(Condition.visible);
    }
}
