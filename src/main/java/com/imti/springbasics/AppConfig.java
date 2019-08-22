package com.imti.springbasics;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * created by imteyaza-1lm on 2019-08-22
 **/
@Configuration
@ComponentScan(basePackages = "com.imti.springbasics")
public class AppConfig {

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("com.mysql.jdbc.Driver");
    ds.setUrl("jdbc:mysql://localhost/svce?useSSL=false");
    ds.setUsername("root");
    ds.setPassword("root");
    return ds;
  }

  @Bean
  public JdbcTemplate jdbcTemplate(){
    return new JdbcTemplate(dataSource());
  }
}
