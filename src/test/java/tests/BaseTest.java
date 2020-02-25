package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import steps.*;
import tests.base.TestListener;

import static com.codeborne.selenide.Selenide.close;

@Listeners(TestListener.class)
public class BaseTest {

    LoginSteps loginSteps;
    MoodSteps moodSteps;
    EditProfileSteps editprofilesteps;
    ChangeAvatarSteps changeAvatarsteps;
    CalendarSteps calendarsteps;

    @BeforeClass
    public void setupDriver() {

        Configuration.headless = true;
        Configuration.startMaximized = true;
        Configuration.screenshots = true;
        Configuration.timeout = 10000;
        Configuration.fastSetValue = true;
        loginSteps = new LoginSteps();
        moodSteps = new MoodSteps();
        editprofilesteps = new EditProfileSteps();
        changeAvatarsteps = new ChangeAvatarSteps();
        calendarsteps = new CalendarSteps();

    }

    @AfterMethod
    public void quitBrowser() {
        close();
    }
}
