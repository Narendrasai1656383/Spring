package com.firstSpring.first_spring_framework;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NormController {
   @RequestMapping("/")
   public String method() {
	   return "My first one";
   }
  @RequestMapping("/hello")
  public String hello(){
	   return "Hello";
  }
}
