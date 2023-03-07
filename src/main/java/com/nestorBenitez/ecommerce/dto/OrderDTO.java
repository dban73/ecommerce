package com.nestorBenitez.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nestorBenitez.ecommerce.entity.OrderState;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

  private String comment;

  private List<OrderItemDTO> items;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private LocalDateTime date;
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private OrderState state;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private double totalPrice;
}
