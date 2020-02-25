package tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class UpdateMoodTest extends BaseTest{



    @Test(dataProvider = "moodsData")
    public void updateMood(int moodRate, String moodComment) {
        loginSteps.login("gotestweb@mailinator.com", "12345678");
        moodSteps
                .openMyUpdatesPage()
                .updateMood(moodRate, moodComment);
    }

    @DataProvider
    public Object[][] moodsData() {
        return new Object[][]{
                {0, "0_ZERO"},
                {1, "1_ONE"},
                {2, "2_TWO"},
                {3, "3_THREE"},
                {4, "4_FOUR"},
                {5, "5_FIVE"},
                {6, "6_SIX"},
                {7, "7_SEVEN"},
                {8, "8_EIGHT"},
                {9, "9_NINE"},
                {10, "10_TEN"}
        };
    }
}
