package com.nestorBenitez.ecommerce.service.impl;

import com.nestorBenitez.ecommerce.entity.Category;
import com.nestorBenitez.ecommerce.exceptions.EntityNotFoundException;
import com.nestorBenitez.ecommerce.repository.CategoryRepository;
import com.nestorBenitez.ecommerce.service.CategoryService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

  private CategoryRepository categoryRepository;

  @Override
  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  @Override
  public Category getById(UUID id) {
    return categoryRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Category", id));
  }
}
