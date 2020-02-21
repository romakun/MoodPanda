package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDetailsModel {

    String emailAddress;
    String newPassword;
}
