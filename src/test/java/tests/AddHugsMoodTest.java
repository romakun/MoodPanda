package tests;

import org.testng.annotations.Test;

public class AddHugsMoodTest extends BaseTest{
    @Test
    public void addNewHugInMood() {
        loginSteps.login("gotestweb@mailinator.com", "12345678");
        moodSteps
                .openMyUpdatesPage()
                .addHugsInMoodComment(2);
    }
}
