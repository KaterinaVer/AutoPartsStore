package com.store.dto;


import com.store.entity.Role;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserResponse {

    private Long userId;
    private String login;
    private Set<Role> roles;

}
