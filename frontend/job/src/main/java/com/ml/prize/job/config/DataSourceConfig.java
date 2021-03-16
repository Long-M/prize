package com.ml.prize.job.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Mr.ml
 * @date 2021/3/14
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

}
