package com.itmuch.cloud.controller;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/api")
@RestController
public class ApiController {
  @Autowired private UserRepository userRepository;

  /**
   * 访问Zuul的/api/microservice-provider-user/1路径，请求将会被转发到microservice-provider-user的/api/1
   *
   * @param id
   * @return
   */
  @GetMapping("/{id}")
  public Optional<User> findById(@PathVariable Long id) {
    return this.userRepository.findById(id);
  }
}
