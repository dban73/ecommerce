package com.nestorBenitez.ecommerce.mapper;

import com.nestorBenitez.ecommerce.DTO.UserDTO;
import com.nestorBenitez.ecommerce.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public UserDTO convertToUserDTO(User user) {
    UserDTO userDTO = new UserDTO();
    userDTO.setId(user.getId());
    userDTO.setFirstName(user.getFirstName());
    userDTO.setLastName(user.getLastName());
    userDTO.setEmail(user.getEmail());
    userDTO.setAddress(user.getAddress());
    userDTO.setRolename(user.getRole().getName());
    return userDTO;
  }
}
