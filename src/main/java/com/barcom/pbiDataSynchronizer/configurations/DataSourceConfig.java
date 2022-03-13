package com.barcom.pbiDataSynchronizer.configurations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories(basePackages = "com.barcom.pbiDataSynchronizer.repositories")
public class DataSourceConfig {


    @Bean("datasource")
    @ConfigurationProperties(prefix="spring.datasource")
    @Primary
    public DataSource postgresqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("mysqlDataSource")
    @ConfigurationProperties(prefix="spring.second-datasource")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("jdbcTemplate2")
    public JdbcTemplate jdbcTemplate2(@Qualifier("mysqlDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }


}
