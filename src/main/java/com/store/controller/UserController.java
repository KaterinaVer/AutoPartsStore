package com.store.controller;

import com.store.dto.UserRequest;
import com.store.dto.UserResponse;
import com.store.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@CrossOrigin
@Controller
public class UserController {

  private final UserService userService;

  @GetMapping("/api/users")
  public ResponseEntity<List<UserResponse>> getAllUser() {
    return ResponseEntity.ok().body(userService.findAllUsers());
  }

  @GetMapping("/api/users/{id}")
  public ResponseEntity<UserResponse> getUser(
      @PathVariable("id") final Long userId) {
    return ResponseEntity.ok().body(userService.getUserById(userId));
  }

  @DeleteMapping("/api/users/{id}")
  public ResponseEntity<Void> deleteUserById(
      @PathVariable("id") final Long userId) {
    userService.deleteUser(userId);
    return ResponseEntity.ok().build();
  }

  @PutMapping("/api/users/{id}")
  public ResponseEntity<Void> updateUser(
      @PathVariable("id") final Long userId,
      @RequestBody @Valid final UserRequest user) {
    userService.updateUser(userId, user);
    return ResponseEntity.accepted().build();
  }

}