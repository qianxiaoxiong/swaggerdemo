package com.swaggerdemo.config.configdatasource;

import com.swaggerdemo.config.DynamicDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;


@Configuration
@MapperScan(basePackages = "com.swaggerdemo.mapper",sqlSessionFactoryRef = "getsqlSessionFactory")
public class ConfigDataSource {



    @Autowired
    private  DynamicDataSource dynamicDataSource;


    @Bean
//    @Primary  //默认是这个
    @ConfigurationProperties(prefix = "spring.datasource.datasource1")
    public DataSource getSqlServerDataSource1() {
        return (DataSource) new HikariDataSource();
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.datasource2")
    public DataSource getDataSource2() {
        return (DataSource) new HikariDataSource();
    }



    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dynamicDataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager( dynamicDataSource);
        return dataSourceTransactionManager;
    }
//    @Bean("dynamicDataSource")
//    public DynamicDataSource getDynamicDataSource(){
//        DynamicDataSource dynamicDataSource = new DynamicDataSource();
//        HashMap<String, DataSource> map = new HashMap<String, DataSource>();
//        map.put("getDataSource1",dataSource1);
//        map.put("getDataSource2",dataSource2);
//        return dynamicDataSource;
//    }

    @Bean
    public SqlSessionFactory getsqlSessionFactory(DataSource dynamicDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        return  sqlSessionFactoryBean.getObject();
    }
}
