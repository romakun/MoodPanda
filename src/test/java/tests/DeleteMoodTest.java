package tests;

import org.testng.annotations.Test;

public class DeleteMoodTest extends BaseTest{
    @Test
    public void deleteMoodByNumber() {
        loginSteps.login("gotestweb@gmail.com", "6699273");
        moodSteps
                .openMyUpdatesPage()
                .deleteMood(1);
    }
}

