package com.imti.springbasics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by imteyaza-1lm on 2019-08-22
 **/
public class FileSystemXmlApplicationContextExample {

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
        "file:/Users/imteyaza-1lm/Documents/beans.xml");
    Student student = ctx.getBean("student", Student.class);
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
  }
}
