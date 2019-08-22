package com.imti.springbasics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created by imteyaza-1lm on 2019-08-22
 **/
@Configuration
public class Config {

  @Bean
  public Student student(){
    Student student = new Student();
    student.setFirstName("Imteyaz");
    student.setLastName("Ahmad");
    return student;
  }
}
