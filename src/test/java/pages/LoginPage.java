package pages;

import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    private static final String URL = "https://moodpanda.com/Login/";


    @Override
    void openPage() {
        open(URL);

    }

    @Override
    void isPageObject() {
        

    }
}
