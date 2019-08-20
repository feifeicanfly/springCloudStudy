package com.itmuch.com.controller;

import com.itmuch.com.entity.User;
import com.itmuch.com.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** @author zhouli */
@RequestMapping("/movies")
@RestController
public class MovieController {
  @Autowired private UserFeignClient userFeignClient;

  @GetMapping("/users/{id}")
  public User findById(@PathVariable Long id) {
    return this.userFeignClient.findById(id);
  }

  /** 传递复杂对象 */
  @GetMapping("/users/getUserName")
  public String getUserName(@ModelAttribute User user) {
    return this.userFeignClient.getUserName(user);
  }
}
