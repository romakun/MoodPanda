package steps;

import io.qameta.allure.Step;
import pages.MyUpdatesPage;

public class MoodSteps {

    MyUpdatesPage page;

    public MoodSteps(){
        page = new MyUpdatesPage();
    }

    @Step("Open page with my moods")
    public MoodSteps openMyUpdatesPage(){
        page
                .openPage();
        return this;
    }

    @Step("Update mood to '{moodRate}' with comment '{comment}'")
    public MoodSteps updateMood(int moodRate, String comment){
        page
                .clickUpdateMood()
                .updateMoodRate(moodRate)
                .writeCommentInMoodModal(comment)
                .saveMood()
                .checkUpdateMoodModal(comment);
    return this;
    }

    @Step("Delete mood by number '{moodNumber}'")
    public MoodSteps deleteMood(int moodNumber){
        page
                .deleteMood(moodNumber);
        return this;
    }

    @Step("Add comment message under '{moodNumber}' mood")
    public MoodSteps addCommentInMood(int moodNumber, String comment){
        page
                .addComment(moodNumber, comment);
        return this;
    }

    @Step("Add Hug message under '{moodNumber}' mood")
    public MoodSteps addHugsInMoodComment(int moodNumber){
        page
                .addHugs(moodNumber);
        return this;
    }
}
