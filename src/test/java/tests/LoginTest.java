package tests;

import org.testng.annotations.Test;


public class LoginTest extends BaseTest{

    @Test
    public void loginUsingCorrectCredentials() {
        loginSteps.login("gotestweb@gmail.com", "6699273");
        moodSteps.updateMood(10, "bla bla");
      }
}
