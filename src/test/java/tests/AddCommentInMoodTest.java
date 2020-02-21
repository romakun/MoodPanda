package tests;

import org.testng.annotations.Test;

public class AddCommentInMoodTest extends BaseTest{

    @Test
    public void addCommentInMood() {
        loginSteps.login("gotestweb@mailinator.com", "12345678");
        moodSteps
                .openMyUpdatesPage()
                .addCommentInMood(2, "BALABAMA STREET YAEH");
    }
}
