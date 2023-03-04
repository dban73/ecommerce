package com.nestorBenitez.ecommerce.service;

import com.nestorBenitez.ecommerce.dto.UserDTO;
import java.util.List;
import java.util.UUID;

public interface UserService {

  List<UserDTO> getAllUsers();

  UserDTO getById(UUID id);
}
