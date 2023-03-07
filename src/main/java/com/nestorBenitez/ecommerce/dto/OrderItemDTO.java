package com.nestorBenitez.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

  private UUID productId;
  private int quantity;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private double totalPrice;

}
