package com.imti.springbasics;

import java.util.List;

/**
 * created by imteyaza-1lm on 2019-08-22
 **/
public interface StudentDao {

  int saveStudent(Student student);

  List<Student> selectAll();

  int deleteById(int id);

  int updateStudent(Student student, int id);

}
