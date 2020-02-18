package tests;

import org.testng.annotations.Test;


public class UpdateMoodTest extends BaseTest{

    @Test
    public void loginUsingCorrectCredentials() {
        loginSteps.login("gotestweb@gmail.com", "6699273");
        moodSteps
                .openMyUpdatesPage()
                .updateMood(10, "bla bla bla i'm happy yeah");
    }
}
