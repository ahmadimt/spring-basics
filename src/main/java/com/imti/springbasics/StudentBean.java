package com.imti.springbasics;

import org.springframework.stereotype.Component;

/**
 * created by imteyaza-1lm on 2019-08-22
 **/
@Component
public class StudentBean {

  private String firstName;

  private String lastName;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Student{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
