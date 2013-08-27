package com.example.spring_data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.config.DataSourceConfiguration;
import com.example.config.LocalDataSourceConfiguration;
import com.example.model.Customer;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;


@Configuration
@EnableJpaRepositories
@PropertySource("classpath:/services.properties")
@EnableTransactionManagement
@Import( { LocalDataSourceConfiguration.class })
public class JpaCustomerConfiguration {

    @Inject private DataSourceConfiguration dataSourceConfiguration;

    @Inject private Environment environment;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {

        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSourceConfiguration.dataSource());
        localContainerEntityManagerFactoryBean.setPackagesToScan(Customer.class.getPackage().getName());

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);

        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        EntityManagerFactory entityManagerFactory = entityManagerFactory().getObject();
        return new JpaTransactionManager(entityManagerFactory);
    }
    
}
