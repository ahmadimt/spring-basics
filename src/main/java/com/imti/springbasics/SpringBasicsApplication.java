package com.imti.springbasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.imti.springbasics")
public class SpringBasicsApplication {

  @Autowired
  private StudentBean studentBean;

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringBasicsApplication.class);
    StudentBean bean = ctx.getBean(StudentBean.class);
    bean.setFirstName("Imteyaz");
    bean.setLastName("Ahmad");
    System.out.println(bean.getFirstName());
    System.out.println(bean.getLastName());
  }

}
