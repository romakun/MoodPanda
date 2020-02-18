package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class UpdateMoodTest extends BaseTest{



    @Test
    public void loginUsingCorrectCredentials() {

        log.info("info");
        log.warn("warn");

        log.error("error");
        log.fatal("fatal");

        log.trace("trace");
        log.debug("debug");


//        loginSteps.login("gotestweb@gmail.com", "6699273");
//        moodSteps
//                .openMyUpdatesPage()
//                .updateMood(10, "bla bla bla i'm happy yeah");
   }
}
