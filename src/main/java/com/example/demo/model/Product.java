package com.example.demo.model;

import lombok.*;

//@Getter
//@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  int productId;
  String productName;
  String maker;
  int price;
  int qty;

//  @Builder
//  public Product(int productId, String productName, String maker, int price, int qty) {
//    this.productId = productId;
//    this.productName = productName;
//    this.maker = maker;
//    this.price = price;
//    this.qty = qty;
//  }
}
