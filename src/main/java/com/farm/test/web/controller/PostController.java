package com.farm.test.web.controller;

import com.farm.test.service.posts.PostsService;
import com.farm.test.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class PostController {
  private final PostsService postsService;
  private final HttpSession httpSession;

  @GetMapping("/post")
  public String post(Model model) {
    model.addAttribute("posts", postsService.findAllDesc());
    return "post";
  }

  @GetMapping("/posts/save")
  public String postsSave() {
    return "posts-save";
  }

  @GetMapping("/posts/update/{id}")
  public String postsUpdate(@PathVariable Long id, Model model) {
    PostsResponseDto postsResponseDto = postsService.findById(id);
    model.addAttribute("post", postsResponseDto);
    return "posts-update";
  }
}
