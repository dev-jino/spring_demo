package com.example.demo.webcontroller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class WebPostController {
  private final PostService postService;

  @Autowired
  public WebPostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/list")
  public String postList(Model model) {
    List<Post> allPosts = postService.getAllPosts();
    model.addAttribute("postList", allPosts);

    return "post/postList";
  }

  @GetMapping("/add")
  public String postAdd() {
    return "post/postForm";
  }

  @PostMapping("/add")
  public String postAdd(@ModelAttribute Post post) {
    postService.setPost(post);

    return "redirect:list";
  }

  @GetMapping("/detail")
  public String postDetail(@RequestParam("postId") int postId, Model model) {
    Post postById = postService.getPostById(postId);
    model.addAttribute("post", postById);

    return "post/postDetail";
  }

  @GetMapping("/modify")
  public String postModify(@RequestParam("postId") int postId, Model model) {
    Post postById = postService.getPostById(postId);
    model.addAttribute("post", postById);

    return "post/postModifyForm";
  }

  @PostMapping("/modify")
  public String postModify(@ModelAttribute Post post,
                           RedirectAttributes redirect) {
    postService.updatePost(post.getPostId(), post);

    redirect.addAttribute("postId", post.getPostId());

    return "redirect:detail";
  }

  @GetMapping("/delete")
  public String postDelete(@RequestParam("postId") int postId) {
    postService.removePost(postId);

    return "redirect:list";
  }
}
