package tests;

import models.LoginDetailsModel;
import models.PersonalInfoModel;
import org.testng.annotations.Test;

public class EditProfileTest extends BaseTest {
    @Test
    public void editProfile() {

        PersonalInfoModel options = PersonalInfoModel.builder()
                .firstName("Teremok")
                .surnameInitial("T")
                .yearOfBirth("1990")
                .gender("Other")
                .build();

//        LoginDetailsModel data = LoginDetailsModel.builder()
//                .emailAddress("gotestweb@mailinator.com")
//                .newPassword("12345678")
//                .build();

        loginSteps.login("gotestweb@mailinator.com", "12345678");
        editprofilesteps
                .openEditProfilePage()
                .typeNewData(options)
       //         .typeNewDetails(data)
                .saveDataInProfile();
    }
}
