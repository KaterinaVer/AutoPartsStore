package com.store.dto;

import com.store.entity.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserRoleResponse {

  private Long userRoleId;
  private Role role;
  private UserResponse user;

}