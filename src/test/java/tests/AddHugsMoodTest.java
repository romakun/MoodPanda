package tests;

import org.testng.annotations.Test;

public class AddHugsMoodTest extends BaseTest{
    @Test
    public void addCommentInMood() {
        loginSteps.login("gotestweb@gmail.com", "6699273");
        moodSteps
                .openMyUpdatesPage()
                .addHugsInMoodComment(2);
    }

}
