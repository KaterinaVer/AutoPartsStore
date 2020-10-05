package com.store.controller;

import com.store.dto.UserRequest;
import com.store.dto.UserResponse;
import com.store.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@AllArgsConstructor
@CrossOrigin
@Controller
public class RegistrationController {

  private final RegistrationService registrationService;

  @PostMapping(value = "/api/sign-up")
  public ResponseEntity<UserResponse> registrateUser(@RequestBody @Valid final UserRequest user) {
    return ResponseEntity.ok().body(registrationService.registerSimpleUser(user));
  }

}