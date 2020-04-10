package com.dzzdsj.demo.codeutils.druid;
import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author Administrator
 * @create 2018-01-24 13:03
 * Copyright: Copyright (c) 2018
 * Company:
 **/
@Configuration
@PropertySource("classpath:application.yml")
public class DruidDBConfig {
    private Logger logger = LoggerFactory.getLogger(DruidDBConfig.class);

    /**
     * 在同样的DataSource中，首先使用被标注的DataSource
     * @return DataSource
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();
        return datasource;
    }
}