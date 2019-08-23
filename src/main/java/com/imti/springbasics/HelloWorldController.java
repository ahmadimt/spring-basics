package com.imti.springbasics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * created by imteyaza-1lm on 2019-08-23
 **/
@Controller
public class HelloWorldController {

  @GetMapping({"/", "/hello"})
  public String hello(
      @RequestParam(value = "name", required = false, defaultValue = "World") String name,
      Model model) {
    model.addAttribute("name", name);
    return "hello";
  }
}
