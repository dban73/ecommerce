package com.nestorBenitez.ecommerce.service;

import com.nestorBenitez.ecommerce.entity.Role;
import java.util.List;

public interface RoleService {

  Role getByName(String name);

  List<Role> getAllRoles();
}
