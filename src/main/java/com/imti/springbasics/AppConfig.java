package com.imti.springbasics;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * created by imteyaza-1lm on 2019-08-22
 **/
@Configuration
@ComponentScan(basePackages = "com.imti")
@EnableTransactionManagement
public class AppConfig {

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    //ds.setDriverClassName("com.mysql.jdbc.Driver");
    ds.setUrl("jdbc:h2:~/test");
    ds.setUsername("sa");
    ds.setPassword("sa");
    return ds;
  }

  @Bean
  public HibernatePersistenceProvider persistenceProvider() {
    return new HibernatePersistenceProvider();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean managerFactoryBean() {
    LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    managerFactoryBean.setDataSource(dataSource());
    managerFactoryBean.setPackagesToScan("com.imti.springbasics");
    managerFactoryBean.setPersistenceUnitName("students");
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    managerFactoryBean.setJpaVendorAdapter(vendorAdapter);
    managerFactoryBean.setJpaProperties(additionalProperties());
    return managerFactoryBean;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);
    transactionManager.setPersistenceUnitName("students");
    return transactionManager;
  }

  private Properties additionalProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto", "update");
    properties.setProperty("hibernate.show_sql", "true");
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    properties.setProperty("hibernate.physical_naming_strategy", "com.imti.springbasics.PhysicalNamingStrategyImpl");
    return properties;
  }
}
