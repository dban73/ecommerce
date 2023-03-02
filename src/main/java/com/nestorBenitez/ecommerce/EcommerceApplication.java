package com.nestorBenitez.ecommerce;

import com.nestorBenitez.ecommerce.entity.Category;
import com.nestorBenitez.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {
  public static void main(String[] args) {
    SpringApplication.run(EcommerceApplication.class, args);
  }
}
