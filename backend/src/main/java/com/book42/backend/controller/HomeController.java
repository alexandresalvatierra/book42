package com.book42.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HomeController {

  @GetMapping(value="/")
  public String getMethodName() {
      return "/home";
  }

}
