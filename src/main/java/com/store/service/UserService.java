package com.store.service;

import com.store.dto.UserRequest;
import com.store.dto.UserResponse;
import com.store.entity.User;
import com.store.exception.NotFoundException;
import com.store.mapper.UserMapper;
import com.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class UserService{

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Transactional(readOnly = true)
  public List<UserResponse> findAllUsers() {
    return userMapper.userToUserListResponse(userRepository.findAll());
  }

  @Transactional(readOnly = true)
  public UserResponse getUserById(final Long id) throws NotFoundException {
    return userMapper.userToUserResponse(getUserByIdOrThrowException(id));
  }

  public User findByLogin(final String login) {
    return userRepository.findByLoginIgnoreCase(login).orElseThrow(()
            -> new NotFoundException(String.format("User with login %s not found", login)));
  }

  public void deleteUser(final Long id) throws NotFoundException {
    userRepository.delete(getUserByIdOrThrowException(id));
  }

  public void updateUser(final Long userId, UserRequest userRequest) throws NotFoundException {
    User currentUser = getUserByIdOrThrowException(userId);
    userMapper.mapUserFromUserRequest(userRequest, currentUser);
    userRepository.save(currentUser);
  }

  private User getUserByIdOrThrowException(final Long id) throws NotFoundException {
    return userRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", id)));
  }

}