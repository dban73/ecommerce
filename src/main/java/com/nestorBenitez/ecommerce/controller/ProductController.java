package com.nestorBenitez.ecommerce.controller;

import com.nestorBenitez.ecommerce.DTO.ProductDTO;
import com.nestorBenitez.ecommerce.entity.Product;
import com.nestorBenitez.ecommerce.service.ProductService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

  private ProductService productService;

  @GetMapping
  public ResponseEntity<List<ProductDTO>> getAllProducts() {
    return ResponseEntity.status(HttpStatus.OK).body(productService.getAllproduct());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDTO> getById(@RequestParam(value = "id") UUID id) {
    ProductDTO productDTO = productService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(productDTO);
  }

  @PostMapping
  public ResponseEntity<Product> saveProduct(@RequestBody ProductDTO productDTO) {
    Product product = productService.saveProduct(productDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(product);
  }
}
