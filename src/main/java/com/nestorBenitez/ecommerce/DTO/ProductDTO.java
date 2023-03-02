package com.nestorBenitez.ecommerce.DTO;

import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

  private String name;
  private String description;
  private String imageUrl;
  private double price;
  private int stock;
  private boolean isActive;
  private UUID categoryid;
}
