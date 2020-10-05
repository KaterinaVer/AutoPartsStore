package com.store.controller;

import com.store.entity.Role;
import com.store.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@CrossOrigin
@Controller
public class RoleController {

  private final RoleService roleService;

  @GetMapping("/api/roles")
  public ResponseEntity<List<Role>> getRoles() {
    final List<Role> response = roleService.getAllRoles();
    return ResponseEntity.ok().body(response);
  }

}