package com.store.controller;

import com.store.dto.AuthResponse;
import com.store.dto.UserRequest;
import com.store.entity.User;
import com.store.security.JwtProvider;
import com.store.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@CrossOrigin
@Controller
public class AuthorizationController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @PostMapping("/api/login")
    public ResponseEntity<AuthResponse> auth(@RequestBody final UserRequest request) {
        final User userEntity = userService.findByLogin(request.getLogin());
        final String token = jwtProvider.generateToken(userEntity.getLogin());
        return ResponseEntity.ok().body(new AuthResponse(token));
    }
}
