package com.store.service;


import com.store.dto.UserRequest;
import com.store.dto.UserResponse;
import com.store.entity.Role;
import com.store.entity.RoleName;
import com.store.entity.User;
import com.store.exception.NotFoundException;
import com.store.mapper.UserMapper;
import com.store.repository.RoleRepository;
import com.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class RegistrationService{

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserMapper userMapper;
  private final RoleRepository roleRepository;

  public UserResponse registrateSimpleUser(UserRequest userRequest) {
    User user = new User();
    userMapper.mapUserFromUserRequest(userRequest, user);
    user.setPassword(passwordEncoder.encode(user.getPassword()));


    Role userRole = getRoleByNameOrThrowException();
    user.setRole(userRole);

    user = userRepository.save(user);

    return userMapper.userToUserResponse(user);
  }

  private Role getRoleByNameOrThrowException () throws NotFoundException {
    return roleRepository.findByRoleName(RoleName.USER)
            .orElseThrow(() -> new NotFoundException(String.format("Role with name %s not found", RoleName.USER)));
  }

}