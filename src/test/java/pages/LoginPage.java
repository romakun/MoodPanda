package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    private static final String URL = "https://moodpanda.com/Login/";
    private static final String LOGIN_BUTTON_CSS = "#ContentPlaceHolderContent_ButtonLogin";
    private static final String LOGIN_NAME_CSS = "#ContentPlaceHolderContent_TextBoxEmail";
    private static final String LOGIN_PASSWORD_CSS = "#ContentPlaceHolderContent_TextBoxPassword";


    @Override
    public LoginPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    void isPageOpened() {
        $(LOGIN_BUTTON_CSS).shouldBe(Condition.visible);
    }

    public LoginPage login(String email, String password){
        $(LOGIN_NAME_CSS).sendKeys(email);
        $(LOGIN_PASSWORD_CSS).sendKeys(password);
        $(LOGIN_BUTTON_CSS).click();
        return this;
    }
}
