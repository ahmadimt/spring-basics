package com.imti.springbasics;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

/**
 * created by imteyaza-1lm on 2019-08-22
 **/
@Component
public class StudentDaoImpl implements StudentDao {

  @PersistenceContext
  private EntityManager entityManager;


  @Transactional
  @Override
  public Student saveStudent(Student student) {
    entityManager.persist(student);
    entityManager.flush();
    return student;
  }


  @Override
  public List<Student> selectAll() {
    return null;
  }


  @Override
  public int deleteById(int id) {
    return 0;
  }

  @Override
  public int updateStudent(Student student) {
    return 0;
  }
}
