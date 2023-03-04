package com.nestorBenitez.ecommerce.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

  private UUID id;
  private String firstName;
  private String lastName;
  private String email;
  private String address;
  private String rolename;
}
