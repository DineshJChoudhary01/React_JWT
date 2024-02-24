package com.jwt.security.spring;




import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

//@Configuration
//@EnableAutoConfiguration
//@EnableTransactionManagement
public class DataSourceConfig {


//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//            DataSource dataSource,
//            JpaVendorAdapter jpaVendorAdapter
//    ) {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource);
//        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
//        entityManagerFactoryBean.setPackagesToScan("com.jwt.models");
//
//        entityManagerFactoryBean.setJpaProperties(additionalProperties());
//        return entityManagerFactoryBean;
//    }

//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//    @Bean
//    public HibernateJpaVendorAdapter jpaVendorAdapter() {
//        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
//        hibernateJpaVendorAdapter.setShowSql(false);
//        hibernateJpaVendorAdapter.setGenerateDdl(true);
//        // Set other properties if needed
//        return hibernateJpaVendorAdapter;
//    }
//
//    Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
//        properties.setProperty("hibernate.format_sql", "true");
//        return properties;
//    }
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//            DataSource dataSource,
//            JpaVendorAdapter jpaVendorAdapter
//    ) {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource);
//        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
//        entityManagerFactoryBean.setPackagesToScan("com.jwt.models"); // Replace with your entity package
//        entityManagerFactoryBean.setJpaProperties(additionalProperties());
//        return entityManagerFactoryBean;
//    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource);
//        entityManagerFactoryBean.setPackagesToScan("com.jwt.models"); // Replace with your entity package
//        entityManagerFactoryBean.setJpaProperties(additionalProperties());
//        entityManagerFactoryBean.setPersistenceUnitName("PU");
////        entityManagerFactoryBean.setPersistenceProviderClass(PersistenceProvider.class);
////        entityManagerFactoryBean.setPersistenceProvider(HibernatePersistenceProvider.class);
////        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
////        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MariaDBDialect");
////        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
//        return entityManagerFactoryBean;
//    }
//        @Bean
//    public HibernatePersistence persistenceProvider() {
//        return new HibernatePersistence(); // Use the HibernatePersistence class provided by JPA
//    }
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
//
//    Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        properties.setProperty("hibernate.format_sql", "true");
//        return properties;
//    }

//    @Bean
//    public DataSource dataSource() {
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        return builder.setType(EmbeddedDatabaseType.HSQL)
//                .addScript("classpath:org/springframework/security/core/userdetails/jdbc/users.ddl").build();
//    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
//        LocalContainerEntityManagerFactoryBean localEMF = new LocalContainerEntityManagerFactoryBean();
//        localEMF.setDataSource(dataSource());
//        JpaVendorAdapter jva= new HibernateJpaVendorAdapter();
//        localEMF.setJpaVendorAdapter(jpaVendorAdapter());
//        localEMF.setJpaProperties(additionalProperties());
//        return localEMF;
//    }
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter(){
//    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
//    hibernateJpaVendorAdapter.setShowSql(false);
//    hibernateJpaVendorAdapter.setGenerateDdl(true);
//    hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
//    return hibernateJpaVendorAdapter;
//    }

//    @Bean
//    @Primary
//    public DataSource dataSource() {
//        System.out.println("In data source------------");
//        return DataSourceBuilder
//                .create()
//                .username("root")
//                .password("Unoveo@5")
//                .url("jdbc:mariadb://localhost:3306/mydb1?createDatabaseIfNotExist=true")
//                .driverClassName("org.mariadb.jdbc.Driver")
//                .build();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return transactionManager;
//    }
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//    Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        properties.setProperty("hibernate.format_sql","true");
//        return properties;
//    }
//@Bean
//public DataSource dataSource() {
//    // Configure your MariaDB DataSource here
//    // Return an instance of MariaDB DataSource
//}
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setDataSource(dataSource);
//        emf.setPackagesToScan("com.jwt.models"); // Set the package where your entity classes are located
//        emf.setJpaVendorAdapter(jpaVendorAdapter());
//        emf.setJpaProperties(additionalProperties());
//        return emf;
//    }
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        adapter.setShowSql(true);
//        adapter.setGenerateDdl(true);
//        adapter.setDatabase(Database.MYSQL); // Use the appropriate Database value for MariaDB
//        return adapter;
//    }
//
//    private Properties additionalProperties() {
//
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        properties.setProperty("hibernate.format_sql","true");
//        return properties;
//    }
}