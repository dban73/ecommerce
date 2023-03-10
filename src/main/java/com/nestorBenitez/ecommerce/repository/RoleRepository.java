package com.nestorBenitez.ecommerce.repository;

import com.nestorBenitez.ecommerce.entity.Role;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

  Role findByName(String name);
/*  @Query(value = "SELECT * FROM roles WHERE name = ?1",nativeQuery = true)
  Role findRoleByName(String name);
  @Query(value = "SELECT * FROM Role r WHERE r.name =?1")
  Role getROleByName(String name);*/
}
