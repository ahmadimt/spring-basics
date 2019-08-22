package com.imti.springbasics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 * created by imteyaza-1lm on 2019-08-22
 **/
@Component
public class StudentDaoImpl implements StudentDao {


  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int saveStudent(Student student) {
    return jdbcTemplate
        .update("INSERT INTO student (FIRST_NAME, LAST_NAME) VALUES(?,?)", student.getFirstName(),
            student.getLastName());
  }


  @Override
  public List<Student> selectAll() {
    return jdbcTemplate.query("select first_name, last_name from student",
        new RowMapper<Student>() {
          @Override
          public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Student(resultSet.getString("first_name"), resultSet.getString("last_name"));
          }
        });
  }


  @Override
  public int deleteById(int id) {
    return jdbcTemplate.update("delete from student where id = ?", id);
  }

  @Override
  public int updateStudent(Student student, int id) {
    return jdbcTemplate
        .update("update student set first_name = ? where id = ?", student.getFirstName(), id);
  }
}
