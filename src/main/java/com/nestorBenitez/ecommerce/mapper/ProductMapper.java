package com.nestorBenitez.ecommerce.mapper;

import com.nestorBenitez.ecommerce.dto.PageDTO;
import com.nestorBenitez.ecommerce.dto.ProductDTO;
import com.nestorBenitez.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
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

  public PageDTO<Product> convertToPageDTO(Page<Product> page) {
    PageDTO<Product> dto = new PageDTO<>();
    dto.setContent(page.getContent());
    dto.setPageNumber(page.getNumber());
    dto.setPageSize(page.getSize());
    dto.setTotalPages(page.getTotalPages());
    dto.setTotalElements(page.getTotalElements());
    dto.setIslast(page.isLast());
    return dto;
  }

  public PageDTO<ProductDTO> convertToPageDTO(Page<Product> pageProduct, Page<ProductDTO> page) {
    PageDTO<ProductDTO> dto = new PageDTO<>();
    dto.setContent(page.getContent());
    dto.setPageNumber(pageProduct.getNumber());
    dto.setPageSize(pageProduct.getSize());
    dto.setTotalPages(pageProduct.getTotalPages());
    dto.setTotalElements(pageProduct.getTotalElements());
    dto.setIslast(pageProduct.isLast());
    return dto;
  }
}
