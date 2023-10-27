package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Data // Getter, Setter가 포함되어있음
public class Post {
  private int postId;
  private String title;
  private String body;
  private int likes;
}
