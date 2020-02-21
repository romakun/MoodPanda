package tests;

import org.testng.annotations.Test;

public class DeleteMoodTest extends BaseTest{
    @Test
    public void deleteMoodByNumber() {
        loginSteps.login("gotestweb@mailinator.com", "12345678");
        moodSteps
                .openMyUpdatesPage()
                .deleteMood(1);
    }
}

