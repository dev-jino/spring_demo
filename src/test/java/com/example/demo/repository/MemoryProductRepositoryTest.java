package com.example.demo.repository;

import com.example.demo.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryProductRepositoryTest {
  ProductRepository productRepository = new MemoryProductRepository();

  @Test
  void findAll() {
    List<Product> allProducts = productRepository.findAll();
    Assertions.assertThat(allProducts.size()).isEqualTo(1);
  }

  @Test
  void findById() {
    Product product = productRepository.findById(1);
    Assertions.assertThat(product.getProductName()).isEqualTo("제품명1");
  }

  @Test
  void insert() {
    Product product = Product.builder()
        .productName("테스트2")
        .maker("테스트메이커")
        .price(1000)
        .qty(1200)
        .build();
    Product insertProduct = productRepository.insert(product);
    Assertions.assertThat(insertProduct).isEqualTo(null);
  }

  @Test
  void update() {
    Product tobeUpdateProduct = Product.builder()
        .productName("테스트")
        .maker("테스트")
        .price(1000)
        .qty(1000001)
        .build();
    productRepository.update(1, tobeUpdateProduct);
    Assertions.assertThat(productRepository.findById(1).getQty())
        .isEqualTo(1000001);
  }

  @Test
  void delete() {
    productRepository.delete(1);
    Assertions.assertThat(productRepository.findById(1)).isEqualTo(null);
  }
}