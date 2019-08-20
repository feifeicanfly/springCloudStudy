package com.itmuch.cloud.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {
  @Autowired private UserRepository userRepository;

  @GetMapping("/{id}")
  public Optional<User> findById(@PathVariable Long id) {
    return this.userRepository.findById(id);
  }

  @PostMapping("/getUserName")
  public JSONObject getUserName(@RequestBody User user) {
    JSONObject json = new JSONObject();
    if (user == null) {
      json.put("code", "01");
      json.put("msg", "未找到数据");
    } else {
      json.put("code", "00");
      json.put("data", JSONUtil.toJsonStr(user));
    }
    return json;
  }
}
