package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalInfoModel {

    String firstName;
    String surnameInitial;
    String yearOfBirth;
    String gender;

}
