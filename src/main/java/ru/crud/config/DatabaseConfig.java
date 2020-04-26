package ru.crud.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;


import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("ru.crud.config")
public class DatabaseConfig {

  @Bean
  public DataSource dataSource() {

//    return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
//        .addScript("classpath:db/schema.sql")
//        .addScript("classpath:db/data.sql")
//        .build();

    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
    dataSource.setUsername("postgres");
    dataSource.setPassword("root");

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
  Properties hibernateProperties() {

    Properties hibernateProperties = new Properties();
    hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    hibernateProperties.put("hibernate.hbm2ddl.auto", "create-drop");
    hibernateProperties.put("hibernate.format_sql", true);
    hibernateProperties.put("hibernate.use_sql_comments", true);
    hibernateProperties.put("hibernate.show_sql", true);

    return hibernateProperties;
  }
}
