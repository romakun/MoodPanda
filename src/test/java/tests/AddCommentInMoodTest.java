package tests;

import org.testng.annotations.Test;

public class AddCommentInMoodTest extends BaseTest{

    @Test
    public void addCommentInMood() {
        loginSteps.login("gotestweb@gmail.com", "6699273");
        moodSteps
                .openMyUpdatesPage()
                .addCommentInMood(2, "BALABAMA STREET YAEH");
    }
}
