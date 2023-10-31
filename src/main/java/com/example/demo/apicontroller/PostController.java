package com.example.demo.apicontroller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
  private final PostService postService;

  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/posts")
  public List<Post> viewAllPost() {
    List<Post> allPosts = postService.getAllPosts();
    return allPosts;
  }

  @PostMapping("/posts")
  public Post registPost(@RequestBody Post post) {
    System.out.println("1 : "+post);
    postService.setPost(post);
    System.out.println("2 : "+post);
    return post;
  }

  @PutMapping("/posts/{postId}")
  public Post updatePost(@PathVariable("postId") int postId,
                         @RequestBody Post post) {
    postService.updatePost(postId, post);
    return post;
  }

  @DeleteMapping("/posts/{postId}")
  public void removePost(@PathVariable("postId") int postId) {
    postService.removePost(postId);
  }
}
