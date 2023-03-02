package com.nestorBenitez.ecommerce;

import com.nestorBenitez.ecommerce.entity.Category;
import com.nestorBenitez.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

  @Autowired
  CategoryRepository categoryRepository;

  public static void main(String[] args) {
    SpringApplication.run(EcommerceApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Category category = new Category();
    category.setName("TRAVEL");
    category.setDescription("travel backpack");

    Category category1 = new Category();
    category1.setName("SCHOOL");
    category1.setDescription("scholls backpack");

    categoryRepository.save(category);
    categoryRepository.save(category1);
  }
}
