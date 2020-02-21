package tests;

import org.testng.annotations.Test;

public class ChangeAvatarTest extends BaseTest{

    @Test
    public void changeAvatar(){
        loginSteps.login("gotestweb@mailinator.com", "12345678");
        changeAvatarsteps
                .openAvatarsPage()
                .editAvatar("3")
                .checkEdition();
    }
}
