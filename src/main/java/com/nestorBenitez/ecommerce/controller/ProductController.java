package com.nestorBenitez.ecommerce.controller;

import com.nestorBenitez.ecommerce.dto.PageDTO;
import com.nestorBenitez.ecommerce.dto.ProductDTO;
import com.nestorBenitez.ecommerce.entity.Product;
import com.nestorBenitez.ecommerce.service.ProductService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDTO> getById(@PathVariable UUID id) {
    ProductDTO productDTO = productService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(productDTO);
  }

  @GetMapping("/pageable")
  public ResponseEntity<Page<Product>> getById(
      @RequestParam(value = "page", defaultValue = "0") int page,
      @RequestParam(value = "size", defaultValue = "10") int size) {
    Pageable pageable = PageRequest.of(page, size);
    return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsPageable(pageable));
  }

  @GetMapping("/pageable2")
  public ResponseEntity<PageDTO<ProductDTO>> getByAll(
      @RequestParam(value = "page", defaultValue = "0") int page,
      @RequestParam(value = "size", defaultValue = "10") int size) {
    Pageable pageable = PageRequest.of(page, size);
    return ResponseEntity.status(HttpStatus.OK)
        .body(productService.getAllProductsPageable(pageable));
  }

  @GetMapping("/price")
  public ResponseEntity<PageDTO<Product>> getFilteredProducts(
      @RequestParam(required = false) Double minPrice,
      @RequestParam(required = false) Double maxPrice,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "20") int size,
      @RequestParam(defaultValue = "id") String sortField,
      @RequestParam(defaultValue = "asc") String sortOrder) {
    if (minPrice == null) {
      minPrice = Double.MIN_VALUE;
    }
    if (maxPrice == null) {
      maxPrice = Double.MAX_VALUE;
    }
    Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
    Pageable pageable = PageRequest.of(page, size, sort);
    PageDTO<Product> filteredPage = productService.getFilteredProducts(minPrice, maxPrice,
        pageable);
    return ResponseEntity.status(HttpStatus.OK).body(filteredPage);
  }

  @PostMapping
  public ResponseEntity<Product> saveProduct(@RequestBody ProductDTO productDTO) {
    Product product = productService.saveProduct(productDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(product);
  }

  @GetMapping("/category/{categoryId}")
  public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable UUID categoryId) {
    List<Product> products = productService.getAllByCategoryId(categoryId);
    return ResponseEntity.ok(products);
  }

  @GetMapping("/category/name/{categoryName}")
  public ResponseEntity<List<Product>> getProductsByCategoryName(
      @PathVariable String categoryName) {
    List<Product> products = productService.getAllByCategoryName(categoryName);
    return ResponseEntity.ok(products);
  }
  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") UUID productId,
      @RequestBody ProductDTO productTarget){
    Product product = productService.updateProduct(productId,productTarget);
    return ResponseEntity.ok(product);
  }
}
