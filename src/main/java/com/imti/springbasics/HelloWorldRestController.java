package com.imti.springbasics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by imteyaza-1lm on 2019-08-23
 **/
@RestController
public class HelloWorldRestController {

  @GetMapping("/rest/student")
  public ResponseEntity<Student> getStudent(){

    return ResponseEntity.ok().body(new Student("Imteyaz","Ahmad"));
  }

}
