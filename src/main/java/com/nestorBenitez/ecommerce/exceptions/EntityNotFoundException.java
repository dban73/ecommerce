package com.nestorBenitez.ecommerce.exceptions;

import java.util.UUID;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class EntityNotFoundException extends RuntimeException {

  public static final String MESSAGE_ERROR = "%s with id: %s not found";

  public EntityNotFoundException(String message) {
    super(message);
  }

  public EntityNotFoundException(String entity, UUID id) {
    super(String.format(MESSAGE_ERROR, entity, id.toString()));
  }
}
