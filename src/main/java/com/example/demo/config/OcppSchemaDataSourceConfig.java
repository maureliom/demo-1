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
    basePackages = "com.example.demo.repository.ocpp.schema.jpa",
    entityManagerFactoryRef = "ocppEntityManagerFactory",
    transactionManagerRef = "ocppTransactionManager"
)
public class OcppSchemaDataSourceConfig {

	
    @Bean(name = "ocppDataSourceProperties")
    @ConfigurationProperties("spring.datasource.ocpp-schema")
    public DataSourceProperties ocppDataSourceProperties() {
        return new DataSourceProperties();
    }

	
    @Bean(name = "ocppDataSource")
    public DataSource ocppDataSource(@Qualifier("ocppDataSourceProperties") DataSourceProperties ocppDataSourceProperties) {
        return ocppDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

	
    @Bean
    @ConfigurationProperties("spring.jpa.ocpp-schema")
    public JpaVendorAdapter ocppJpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        return adapter;
    }

	
    @Bean(name = "ocppEntityManagerFactoryBuilder")
    public EntityManagerFactoryBuilder ocppEntityManagerFactoryBuilder(JpaVendorAdapter adapter) {
        return new EntityManagerFactoryBuilder(adapter, new HashMap<>(), null);
    }

	
    @Bean(name = "ocppEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ocppEntityManagerFactory(
            @Qualifier("ocppEntityManagerFactoryBuilder") EntityManagerFactoryBuilder builder,
            @Qualifier("ocppDataSource") DataSource ocppDataSource) {
        return builder
                .dataSource(ocppDataSource)
                .packages("com.example.demo.model.ocpp.schema.jpa")
                .persistenceUnit("ocpp")
                .properties(ocppJpaProperties().getProperties())
                .build();
    }

	
    @Bean
    @ConfigurationProperties("spring.jpa.ocpp-schema")
    public JpaProperties ocppJpaProperties() {
        return new JpaProperties();
    }

	
    @Bean(name = "ocppTransactionManager")
    public PlatformTransactionManager ocppTransactionManager(
            @Qualifier("ocppEntityManagerFactory") EntityManagerFactory ocppEntityManagerFactory) {
        return new JpaTransactionManager(ocppEntityManagerFactory);
    }
}
