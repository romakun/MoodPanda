package tests;

import org.testng.annotations.Test;

public class ChangeAvatarTest extends BaseTest {
    String avatarSrc;

    @Test
    public void changeAvatar() {
        loginSteps.login("gotestweb@mailinator.com", "12345678");
        avatarSrc = changeAvatarsteps
                .openAvatarsPage()
                .editAvatar("3");
        changeAvatarsteps
                .checkEdition();
        moodSteps
                .openMyUpdatesPage()
                .checkAvatar(avatarSrc);
    }
}
