package com.jwt.configuration;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.jwt")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.jwt.repository")
@PropertySource({
        "classpath:application.properties"
})
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Value("${spring.datasource.driver-class-name}")
    private String dataSourceDriverClassName;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hibernateDdlAuto;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String hibernateDialect;

//    @Bean
//    public  DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(dataSourceDriverClassName);
//        dataSource.setUrl(dataSourceUrl);
//        dataSource.setUsername(dataSourceUsername);
//        dataSource.setPassword(dataSourcePassword);
//        return dataSource;
//    }


@Bean
public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
    final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource);
    entityManagerFactoryBean.setPackagesToScan("com.jwt.models");
//    entityManagerFactoryBean.setPersistenceProviderClass();

//     Use the standard JPA PersistenceProvider interface
//        entityManagerFactoryBean.setPersistenceProvider(persistenceProvider());
//    entityManagerFactoryBean.setJpaProperties(additionalProperties());
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);

    Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        properties.setProperty("hibernate.format_sql", "true");
    entityManagerFactoryBean.setJpaProperties(properties);
    return entityManagerFactoryBean;
}
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager();
    }
//@Bean
//public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
//    JpaTransactionManager transactionManager = new JpaTransactionManager();
//    transactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
//    return transactionManager;
//}
    //    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
//        return builder
//                .hashCode(dataSource())
//                .packages("com.jwt.models") // Set the package where your entity classes are located
//                .persistenceUnit("myUnit")
//                .build();
//    }

        @Bean
    public DataSource dataSource() {
        System.out.println("In data source------------");
        return DataSourceBuilder
                .create()
                .username("root")
                .password("Unoveo@5")
                .url("jdbc:mariadb://localhost:3306/mydb1?createDatabaseIfNotExist=true")
                .driverClassName("org.mariadb.jdbc.Driver")
                .build();
    }
}
