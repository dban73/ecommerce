package com.nestorBenitez.ecommerce.service;

import com.nestorBenitez.ecommerce.entity.Category;
import java.util.List;
import java.util.UUID;

public interface CategoryService {

  List<Category> getAllCategories();

  Category getById(UUID id);
}
