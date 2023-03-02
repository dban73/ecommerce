package com.nestorBenitez.ecommerce.service.impl;

import com.nestorBenitez.ecommerce.DTO.UserDTO;
import com.nestorBenitez.ecommerce.entity.User;
import com.nestorBenitez.ecommerce.exceptions.EntityNotFoundException;
import com.nestorBenitez.ecommerce.mapper.UserMapper;
import com.nestorBenitez.ecommerce.repository.UserRepository;
import com.nestorBenitez.ecommerce.service.UserService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private UserMapper userMapper;

  @Override
  public List<UserDTO> getAllUsers() {
    List<User> userDTOS = userRepository.findAll();
    return userDTOS.stream().map(user -> userMapper.convertToUserDTO(user))
        .collect(Collectors.toList());
  }

  @Override
  public UserDTO getById(UUID id) {
    return userMapper.convertToUserDTO(
        userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User", id)));
  }
}
