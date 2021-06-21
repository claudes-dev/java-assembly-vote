package br.com.claudes.challenge.config;

import com.zaxxer.hikari.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DatabaseConfig {

  @Value("${spring.datasource.url}")
  private String dbUrl;

  @Value("${spring.datasource.password}")
  private String password;

  @Value("${spring.datasource.username}")
  private String user;

  @Value("${spring.datasource.driverClassName}")
  private String driver;

  @Bean
  public DataSource dataSource() {
    HikariConfig config = new HikariConfig();
    config.setDriverClassName(driver);
    config.setJdbcUrl(dbUrl);
    config.setPassword(password);
    config.setUsername(user);

    log.info(dbUrl);
    log.info(user);
    log.info(password);
    return new HikariDataSource(config);
  }

}
