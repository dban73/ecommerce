package com.nestorBenitez.ecommerce.controller;

import com.nestorBenitez.ecommerce.entity.Category;
import com.nestorBenitez.ecommerce.service.CategoryService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

  private CategoryService categoryService;

  @GetMapping
  public ResponseEntity<List<Category>> getAll() {
    List<Category> categories = categoryService.getAllCategories();
    return ResponseEntity.ok(categories);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Category> getById(@PathVariable(name = "id") UUID id) {
    Category category = categoryService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(category);
  }
}
