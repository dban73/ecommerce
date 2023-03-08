package com.nestorBenitez.ecommerce.exceptions;

import java.util.UUID;

public class EntityNameDuplicateException extends RuntimeException {
  public static final String MESSAGE_ERROR = "error: Role Name %s Already Exists";

  public EntityNameDuplicateException(String roleName) {
    super(String.format(MESSAGE_ERROR, roleName));
  }

}
