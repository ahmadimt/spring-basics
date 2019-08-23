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
public class StudentDaoTest {

  @Autowired
  private StudentDao studentDao;

  @Test
  @Transactional
  public void shouldCreateStudentInDatabase() {
    Student student = studentDao.saveStudent(new Student("Imteyaz", "Ahmad"));
    Assert.assertEquals(1L, student.getId(), 0);
  }

  @Test
  public void shouldListAllStudentsInDb() {
    List<Student> students = studentDao.selectAll();
    Student student = students.get(0);
    Assert.assertEquals(2, students.size());
    Assert.assertEquals("Imteyaz", student.getFirstName());
  }


  @Test
  public void shouldDeleteStudentById() {
    int status = studentDao.deleteById(1);
    Assert.assertEquals(1, status);
  }

  @Test
  public void shouldUpdateStudent() {
    int status = studentDao.updateStudent(new Student("Imti", "Ahmad"));
    Assert.assertEquals(1, status);
  }
}
