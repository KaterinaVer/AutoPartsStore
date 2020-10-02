package com.store.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserRequest {
    public static final String USERNAME_PATTERN = "^[a-z0-9_-]{6,30}$";
    public static final String PASSWORD_PATTERN = "^[a-zA-Z0-9]{8,30}$";

    @Pattern(regexp = USERNAME_PATTERN, message = "username have to consist from: a-z characters, 0-9 figures, symbols _, -; and have length 6-15")
    private String login;

    @Pattern(regexp = PASSWORD_PATTERN, message = "password have to consist from: a-z characters, A-Z characters, 0-9 figures; and have length 8-15")
    private String password;

    @NotBlank
    private String userName;

    @NotBlank
    private String userSurname;

}
