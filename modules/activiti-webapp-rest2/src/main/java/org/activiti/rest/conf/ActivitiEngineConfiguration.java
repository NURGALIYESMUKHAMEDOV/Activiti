package org.activiti.rest.conf;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import org.activiti.spring.ProcessEngineFactoryBean;

import javax.sql.DataSource;

/**
 * Created by Astana on 24.02.2018.
 */
@Configuration
public class ActivitiEngineConfiguration {
    private final Logger log = LoggerFactory.getLogger(ActivitiEngineConfiguration.class);

    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource(){
        String jdbcUrl = environment.getProperty("jdbc.url", "jdbc:h2:mem:activiti;DB_CLOSE_DELAY=1000");
        String jdbcDriver = environment.getProperty("jdbc.driver", "org.h2.Driver");
        String jdbcUsername = environment.getProperty("jdbc.username", "sa");
        String jdbcPassword = environment.getProperty("jdbc.password", "");

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUsername(jdbcUsername);
        dataSource.setPassword(jdbcPassword);

        Long connectionTimeout = environment.getProperty("datasource.connection.timeout", Long.class);
        if(connectionTimeout != null){
            dataSource.setConnectionTimeout(connectionTimeout);
        }

        Long idleTimeout = environment.getProperty("datasource.connection.idletimeout", Long.class);
        if(idleTimeout != null){
            dataSource.setIdleTimeout(idleTimeout);
        }

        Long maxLifetime = environment.getProperty("datasource.connection.maxlifetime", Long.class);
        if(maxLifetime != null){
            dataSource.setMaxLifetime(maxLifetime);
        }

        Integer minIdle = environment.getProperty("datasource.connection.minidle", Integer.class);
        if(minIdle != null){
            dataSource.setMinimumIdle(minIdle);
        }

        Integer maxPoolSize = environment.getProperty("datasource.connection.maxpoolsize", Integer.class);
        if(maxPoolSize != null){
            dataSource.setMaximumPoolSize(maxPoolSize);
        }

        return dataSource;
    }

    @Bean(name="transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    public ProcessEngineFactoryBean processEngineFactoryBean(){

    }
}

