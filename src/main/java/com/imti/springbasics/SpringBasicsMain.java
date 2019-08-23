package com.imti.springbasics;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * created by imteyaza-1lm on 2019-08-23
 **/

public class SpringBasicsMain {



  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(AppConfig.class);
    ctx.refresh();
    StudentDao studentDao = ctx.getBean(StudentDao.class);
    Student student = studentDao.saveStudent(new Student("Imteyaz", "Ahmad"));
    System.out.println(student.getId());
  }
}
