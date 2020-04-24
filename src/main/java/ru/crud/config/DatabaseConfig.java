package ru.crud.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("ru.crud.config")
public class DatabaseConfig {

  @Bean
  public DataSource dataSource() {

    return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
        .addScript("classpath:db/schema.sql")
        .addScript("classpath:db/data.sql")
        .build();
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
    hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    hibernateProperties.put("hibernate.hbm2ddl.auto", "create-drop");
    hibernateProperties.put("hibernate.format_sql", true);
    hibernateProperties.put("hibernate.use_sql_comments", true);
    hibernateProperties.put("hibernate.show_sql", true);

    return hibernateProperties;
  }

  @Bean
  public NamedParameterJdbcTemplate getJdbcTemplate() {
    return new NamedParameterJdbcTemplate(dataSource());
  }
}
