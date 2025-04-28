package com.example.demo.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.example.demo.repository.task",
    entityManagerFactoryRef = "taskEntityManagerFactory",
    transactionManagerRef = "taskTransactionManager"
)
public class TaskDataSourceConfig {

	@Primary
    @Bean(name = "taskDataSourceProperties")
    @ConfigurationProperties("spring.datasource.task")
    public DataSourceProperties taskDataSourceProperties() {
        return new DataSourceProperties();
    }

	@Primary
    @Bean(name = "taskDataSource")
    public DataSource taskDataSource(@Qualifier("taskDataSourceProperties") DataSourceProperties taskDataSourceProperties) {
        return taskDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

	@Primary
    @Bean
    @ConfigurationProperties("spring.jpa.task")
    public JpaVendorAdapter taskJpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        return adapter;
    }

	@Primary
    @Bean(name = "taskEntityManagerFactoryBuilder")
    public EntityManagerFactoryBuilder taskEntityManagerFactoryBuilder(JpaVendorAdapter adapter) {
        return new EntityManagerFactoryBuilder(adapter, new HashMap<>(), null);
    }

	@Primary
    @Bean(name = "taskEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean taskEntityManagerFactory(
            @Qualifier("taskEntityManagerFactoryBuilder") EntityManagerFactoryBuilder builder,
            @Qualifier("taskDataSource") DataSource taskDataSource) {
        return builder
                .dataSource(taskDataSource)
                .packages("com.example.demo.model.task")
                .persistenceUnit("task")
                .properties(taskJpaProperties().getProperties())
                .build();
    }

	@Primary
    @Bean
    @ConfigurationProperties("spring.jpa.task")
    public JpaProperties taskJpaProperties() {
        return new JpaProperties();
    }

	@Primary
    @Bean(name = "taskTransactionManager")
    public PlatformTransactionManager taskTransactionManager(
            @Qualifier("taskEntityManagerFactory") EntityManagerFactory taskEntityManagerFactory) {
        return new JpaTransactionManager(taskEntityManagerFactory);
    }
}
