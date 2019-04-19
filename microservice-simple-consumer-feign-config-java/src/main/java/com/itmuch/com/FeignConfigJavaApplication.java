package com.itmuch.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FeignConfigJavaApplication {

  public static void main(String[] args) {
    SpringApplication.run(FeignConfigJavaApplication.class, args);
  }
}
