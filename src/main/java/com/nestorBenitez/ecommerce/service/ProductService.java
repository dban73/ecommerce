package com.nestorBenitez.ecommerce.service;

import com.nestorBenitez.ecommerce.DTO.ProductDTO;
import com.nestorBenitez.ecommerce.entity.Product;
import java.util.List;
import java.util.UUID;

public interface ProductService {

  List<ProductDTO> getAllproduct();

  ProductDTO getById(UUID id);

  Product saveProduct(ProductDTO productDTO);
}
