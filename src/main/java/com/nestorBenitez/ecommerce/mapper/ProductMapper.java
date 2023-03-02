package com.nestorBenitez.ecommerce.mapper;

import com.nestorBenitez.ecommerce.DTO.ProductDTO;
import com.nestorBenitez.ecommerce.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public Product convertToProduct(ProductDTO productDTO) {
    Product product = new Product();
    product.setName(productDTO.getName());
    product.setDescription(productDTO.getDescription());
    product.setPrice(productDTO.getPrice());
    product.setImageUrl(productDTO.getImageUrl());
    product.setStock(productDTO.getStock());
    product.setIsActive(productDTO.isActive());
    return product;
  }

  public ProductDTO convertToProductDTO(Product product) {
    ProductDTO productDTO = new ProductDTO();
    productDTO.setName(product.getName());
    productDTO.setDescription(product.getDescription());
    productDTO.setImageUrl(product.getImageUrl());
    productDTO.setPrice(product.getPrice());
    productDTO.setStock(product.getStock());
    productDTO.setActive(product.getIsActive());
    productDTO.setCategoryid(product.getCategory().getId());
    return productDTO;
  }

}
