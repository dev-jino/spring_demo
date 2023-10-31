package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductDto {
  int productId;
  int qty;

  @Builder
  public ProductDto(int productId, int qty) {
    this.productId = productId;
    this.qty = qty;
  }
}
