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
    basePackages = "com.example.demo.repository.refdata",
    entityManagerFactoryRef = "refdataEntityManagerFactory",
    transactionManagerRef = "refdataTransactionManager"
)
public class RefdataDataSourceConfig {

    @Bean(name = "refdataDataSourceProperties")
    @ConfigurationProperties("spring.datasource.refdata")
    public DataSourceProperties refdataDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "refdataDataSource")
    public DataSource refdataDataSource(@Qualifier("refdataDataSourceProperties") DataSourceProperties refdataDataSourceProperties) {
        return refdataDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    public JpaVendorAdapter refdataJpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        return adapter;
    }

    @Bean(name = "refdataEntityManagerFactoryBuilder")
    public EntityManagerFactoryBuilder refdataEntityManagerFactoryBuilder(JpaVendorAdapter adapter) {
        return new EntityManagerFactoryBuilder(adapter, new HashMap<>(), null);
    }

    @Bean(name = "refdataEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean refdataEntityManagerFactory(
            @Qualifier("refdataEntityManagerFactoryBuilder") EntityManagerFactoryBuilder builder,
            @Qualifier("refdataDataSource") DataSource refdataDataSource) {
        return builder
                .dataSource(refdataDataSource)
                .packages("com.example.demo.model.refdata")
                .persistenceUnit("refdata")
                .properties(refDataJpaProperties().getProperties())
                .build();
    }

    @Bean
    @ConfigurationProperties("spring.jpa.refdata")
    public JpaProperties refDataJpaProperties() {
        return new JpaProperties();
    }

    @Bean(name = "refdataTransactionManager")
    public PlatformTransactionManager refdataTransactionManager(
            @Qualifier("refdataEntityManagerFactory") EntityManagerFactory refdataEntityManagerFactory) {
        return new JpaTransactionManager(refdataEntityManagerFactory);
    }
}
