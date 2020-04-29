package ru.crud.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("ru.crud.config")
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
public class DatabaseConfig {

  @Autowired
  private Environment environment;

  @Bean
  public DataSource dataSource() {

//    return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
//        .addScript("classpath:db/schema.sql")
//        .addScript("classpath:db/data.sql")
//        .build();

    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
    dataSource.setUrl(environment.getProperty("jdbc.url"));
    dataSource.setUsername(environment.getProperty("jdbc.user"));
    dataSource.setPassword(environment.getProperty("jdbc.pass"));

    return dataSource;
  }

  @Bean
  public SessionFactory sessionFactory() {

    return new LocalSessionFactoryBuilder(dataSource())
        .scanPackages("ru.crud.domain")
        .addProperties(hibernateProperties())
        .buildSessionFactory();
  }

  @Bean
  @Autowired
  public HibernateTransactionManager transactionManager(SessionFactory s) {
    HibernateTransactionManager txManager = new HibernateTransactionManager();
    txManager.setSessionFactory(s);
    return txManager;
  }

  @Bean
  Properties hibernateProperties() {

    Properties hibernateProperties = new Properties();
    hibernateProperties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
    hibernateProperties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
    hibernateProperties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
    hibernateProperties.put("hibernate.use_sql_comments", environment.getProperty("hibernate.use_sql_comments"));
    hibernateProperties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
    //hibernateProperties.put("hibernate.connection.autocommit", true);

    return hibernateProperties;
  }
}
