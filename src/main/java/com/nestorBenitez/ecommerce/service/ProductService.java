package com.nestorBenitez.ecommerce.service;

import com.nestorBenitez.ecommerce.DTO.PageDTO;
import com.nestorBenitez.ecommerce.DTO.ProductDTO;
import com.nestorBenitez.ecommerce.entity.Product;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

  List<ProductDTO> getAllProducts();
  PageDTO<ProductDTO> getAllProductsPageable(Pageable pageable);
  Page<Product> getProductsPageable(Pageable pageable);
  ProductDTO getById(UUID id);

  Product saveProduct(ProductDTO productDTO);
  PageDTO<Product> getFilteredProducts(Double minPrice,Double maxprice,Pageable pageable);
}
