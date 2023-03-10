package com.nestorBenitez.ecommerce.controller;

import com.nestorBenitez.ecommerce.entity.Role;
import com.nestorBenitez.ecommerce.service.RoleService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {

  private RoleService roleService;

  @GetMapping
  public ResponseEntity<List<Role>> getAllRoles() {
    return ResponseEntity.ok(roleService.getAllRoles());
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<Role> getByName(@PathVariable String name) {
    return ResponseEntity.ok(roleService.getByName(name));
  }
  @PostMapping
  public ResponseEntity<Role> SaveRol(@RequestBody Role role) {
    return ResponseEntity.status(HttpStatus.CREATED).body(roleService.save(role));
  }
}
