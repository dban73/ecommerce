package com.nestorBenitez.ecommerce.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PageDTO<T> {

  private List<T> content;
  private boolean islast;
  private int pageNumber;
  private int pageSize;
  private int totalPages;
  private long totalElements;
}
