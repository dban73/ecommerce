package com.nestorBenitez.ecommerce.service.impl;

import com.nestorBenitez.ecommerce.DTO.PageDTO;
import com.nestorBenitez.ecommerce.DTO.ProductDTO;
import com.nestorBenitez.ecommerce.entity.Category;
import com.nestorBenitez.ecommerce.entity.Product;
import com.nestorBenitez.ecommerce.exceptions.EntityNotFoundException;
import com.nestorBenitez.ecommerce.mapper.ProductMapper;
import com.nestorBenitez.ecommerce.repository.ProductRepository;
import com.nestorBenitez.ecommerce.service.CategoryService;
import com.nestorBenitez.ecommerce.service.ProductService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;
  private CategoryService categoryService;
  private ProductMapper productMapper;

  @Override
  public List<ProductDTO> getAllProducts() {
    List<Product> products = productRepository.findAll();
    return products.stream().map(product -> productMapper.convertToProductDTO(product)).collect(
        Collectors.toList());
  }

  @Override
  public PageDTO<ProductDTO> getAllProductsPageable(Pageable pageable) {
    Page<Product> products = productRepository.findAll(pageable);
    System.out.println("Este es el numero de paginas totales DTO: " + products.getTotalPages());
    System.out.println(
        "Este es el numero de elementos totales DTO: " + products.getTotalElements());
    Page<ProductDTO> pageProductsDTO = new PageImpl<>(
        products.stream().map(product -> productMapper.convertToProductDTO(product)).collect(
            Collectors.toList()));
    System.out.println(
        "Este es el numero de paginas totales DTO: " + pageProductsDTO.getTotalPages());
    System.out.println(
        "Este es el numero de elementos totales DTO: " + pageProductsDTO.getTotalElements());
    return productMapper.convertToPageDTO(products, pageProductsDTO);
  }

  @Override
  public Page<Product> getProductsPageable(Pageable pageable) {
    return productRepository.findAll(pageable);
  }

  @Override
  public ProductDTO getById(UUID id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product", id));
    return productMapper.convertToProductDTO(product);
  }

  @Override
  public Product saveProduct(ProductDTO productDTO) {
    Category category = categoryService.getById(productDTO.getCategoryid());
    Product product = productMapper.convertToProduct(productDTO);
    product.setCategory(category);
    return productRepository.save(product);
  }

  @Override
  public PageDTO<Product> getFilteredProducts(Double minPrice, Double maxPrice, Pageable pageable) {
    Page<Product> page = productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
    return productMapper.convertToPageDTO(page);
  }
}
