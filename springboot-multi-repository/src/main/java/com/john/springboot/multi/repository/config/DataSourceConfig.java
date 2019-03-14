package com.john.springboot.multi.repository.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.john.springboot.multi.repository.dal.mapper", 
	sqlSessionTemplateRef = "sqlSessionTemplate")
public class DataSourceConfig {
	
	private final String mybatisConfig = "classpath:mybatis/mysql-mybatis-config.xml";
    
    private final String sqlmap = "classpath:sqlmap/*Mapper.xml";
	
    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.quartz")
    public DataSource getDateSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory quartzSqlSessionFactory(
    		@Qualifier("dataSource") DataSource datasource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(sqlmap));
        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(mybatisConfig));
        return bean.getObject();
    }
    
    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager quartzTransactionManager(
    		@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean("sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate quartzSqlsessiontemplate(
            @Qualifier("sqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
