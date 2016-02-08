package com.poseidon;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@EnableWebSecurity
@SpringBootApplication
public class PoseidonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoseidonApplication.class, args);
    }
    
    @Bean
    public FlywayMigrationStrategy cleanMigrateStrategy() {
        FlywayMigrationStrategy strategy = new FlywayMigrationStrategy() {
            @Override
            public void migrate(Flyway flyway) {
                flyway.clean();
                flyway.migrate();
            }
        };

        return strategy;
    }

@Configuration
@ConditionalOnClass({SpringSecurityDialect.class})
protected static class ThymeleafSecurityDialectConfiguration {
  protected ThymeleafSecurityDialectConfiguration() {
  }

  @Bean
  @ConditionalOnMissingBean
  public SpringSecurityDialect securityDialect() {
      return new SpringSecurityDialect();
  }
}

}
