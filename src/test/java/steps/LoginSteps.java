package steps;

import pages.LoginPage;
import io.qameta.allure.Step;

public class LoginSteps {

    LoginPage loginPage;

    public LoginSteps(){
        loginPage = new LoginPage();
    }

    @Step("Login '{email}' in MoodPanda")
    public LoginSteps login(String email, String password){
        loginPage
                .openPage()
                .login(email, password);
        return this;
    }
}
