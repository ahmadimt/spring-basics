package com.imti.springbasics;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * created by imteyaza-1lm on 2019-08-22
 **/
public class JavaConfigExample {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(Config.class);
    ctx.refresh();
    Student student = ctx.getBean("student", Student.class);
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
  }
}
