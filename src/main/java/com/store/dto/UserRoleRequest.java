package com.store.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserRoleRequest {

  @NotBlank
  private Long userId;

  @NotBlank
  private Long roleId;

}