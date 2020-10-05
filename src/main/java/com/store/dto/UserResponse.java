package com.store.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserResponse {

    private Long userId;
    private String login;
    private String role;

}
