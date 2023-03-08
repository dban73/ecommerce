package com.nestorBenitez.ecommerce.service.impl;

import com.nestorBenitez.ecommerce.entity.Role;
import com.nestorBenitez.ecommerce.repository.RoleRepository;
import com.nestorBenitez.ecommerce.service.RoleService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

  private RoleRepository roleRepository;

  @Override
  public Role getByName(String name) {
    return roleRepository.findByName(name);
  }

  @Override
  public List<Role> getAllRoles() {
    return roleRepository.findAll();
  }

  @Override
  public Role save(Role role) {
    return roleRepository.save(role);
  }
}
