package com.imti.springbasics;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * created by imteyaza-1lm on 2019-08-22
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TestDataSource {

  @Autowired
  private DriverManagerDataSource dataSource;

  @Test
  public void shouldCreateDataSource() {
    try (Connection connection = dataSource.getConnection()) {
      DatabaseMetaData metaData = connection.getMetaData();
      Assert.assertEquals(5, metaData.getDatabaseMajorVersion());
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


}
