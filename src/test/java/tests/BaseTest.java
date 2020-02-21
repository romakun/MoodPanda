package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import steps.ChangeAvatarSteps;
import steps.EditProfileSteps;
import steps.LoginSteps;
import steps.MoodSteps;

public class BaseTest {

    LoginSteps loginSteps;
    MoodSteps moodSteps;
    EditProfileSteps editprofilesteps;
    ChangeAvatarSteps changeAvatarsteps;

    @BeforeClass
    public void setupDriver(){

     //   Configuration.headless = true;
        Configuration.startMaximized = true;
        Configuration.clickViaJs = true;
        Configuration.screenshots = true;
        Configuration.timeout = 10000;
        Configuration.fastSetValue = true;
        loginSteps = new LoginSteps();
        moodSteps = new MoodSteps();
        editprofilesteps = new EditProfileSteps();
        changeAvatarsteps = new ChangeAvatarSteps();
    }
}
