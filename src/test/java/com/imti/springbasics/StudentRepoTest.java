package com.imti.springbasics;

import java.util.List;
import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * created by imteyaza-1lm on 2019-08-22
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class StudentRepoTest {

  @Autowired
  private StudentRepo studentRepo;

  @Test
  @Transactional
  public void shouldCreateStudentInDatabase() {
    Student student = studentRepo.save(new Student("Imteyaz", "Ahmad"));
    Assert.assertEquals(11L, student.getId(), 0);
  }

  @Test
  public void shouldListAllStudentsInDb() {
    List<Student> students = studentRepo.findAll();
    Student student = students.get(0);
    Assert.assertEquals(4, students.size());
    Assert.assertEquals("Imteyaz", student.getFirstName());
  }


  @Test
  public void shouldDeleteStudentById() {
    studentRepo.deleteById(1L);

  }

  @Test
  public void shouldUpdateStudent() {
    Student student = new Student("Imti", "Ahmad");
    student.setId(1L);
    Student status = studentRepo.save(student);
    Assert.assertEquals(1, status);
  }
}
