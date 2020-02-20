package tests;

import org.testng.annotations.Test;

public class AddHugsMoodTest extends BaseTest{
    @Test
    public void addNewHugInMood() {
        loginSteps.login("gotestweb@gmail.com", "6699273");
        moodSteps
                .openMyUpdatesPage()
                .addHugsInMoodComment(2);
    }
}
