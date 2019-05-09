package com.itmuch.com.controller;

import com.itmuch.com.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RequestMapping("/movies")
@RestController
public class MovieController {
  @Autowired private RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "findByIdFallback")
  @GetMapping("/users/{id}")
  public User findById(@PathVariable Long id) {
    // 这里用到了RestTemplate的占位符能力
    User user = this.restTemplate.getForObject("http://localhost:8000/users/{id}", User.class, id);
    // ...电影微服务的业务...
    return user;
  }

  public User findByIdFallback(Long id, Throwable t) {
    System.out.println(t.getLocalizedMessage());
    return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
  }
}
