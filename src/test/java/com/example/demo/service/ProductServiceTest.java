package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.MemoryProductRepository;
import com.example.demo.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
  ProductRepository productRepository = new MemoryProductRepository();
  ProductService productService = new ProductService(productRepository);

  @Test
  void addProduct() {
    Product product = Product.builder()
        .productName("test1")
        .maker("test")
        .price(15000)
        .qty(100)
        .build();
    String s = productService.addProduct(product);
    Assertions.assertThat(s).isEqualTo("새로운 제품 추가 성공");
  }
}