package com.store.rest;

import com.store.dto.Jwt;
import com.store.dto.UserRequest;
import com.store.dto.UserResponse;
import com.store.entity.User;
import com.store.repository.UserRepository;
import com.store.security.JwtProvider;
import com.store.service.RegistrationService;
import com.store.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
  private final UserService userService;
  private final JwtProvider jwtProvider;

  @PostMapping(value = "/api/sign-up")
  public ResponseEntity<UserResponse> registrateUser(
      @RequestBody @Valid UserRequest user) {
    return ResponseEntity.ok().body(registrationService.registrateSimpleUser(user));
  }

  @PostMapping("/auth")
  public ResponseEntity<Jwt> auth(@RequestBody UserRequest request) {
    User userEntity = userService.findByLogin(request.getLogin());
    String token = jwtProvider.generateToken(userEntity.getLogin());
    return ResponseEntity.ok().body(new Jwt(token));
  }

}