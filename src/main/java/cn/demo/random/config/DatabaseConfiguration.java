package cn.demo.random.config;

import java.util.Arrays;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;

import com.codahale.metrics.MetricRegistry;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import cn.demo.random.config.liquibase.AsyncSpringLiquibase;
import liquibase.integration.spring.SpringLiquibase;

@Configuration
@MapperScan(annotationClass = )
@EnableTransactionManagement
public class DatabaseConfiguration {
	
	private final Logger logger = LoggerFactory.getLogger(DatabaseConfiguration.class);
	
	@Autowired
	private AppProperties appproperties;
	@Autowired
	private Environment env;
	
	@Autowired(required = false)
	private MetricRegistry metricRegistry;
	
	@Bean
	@Profile(Constants.SPRING_PROFILE_DEVELOPMENT)
	public DataSource datasource(DataSourceProperties dataSourceProperties, AppProperties appProperties){
		logger.debug("-------------------Configurer Datasource-------------------");
		String databaseName = env.getProperty("spring.datasource.name");
		if(StringUtils.isEmpty(dataSourceProperties.getUrl()) && StringUtils.isEmpty(databaseName)){
			logger.error("Your database connection poll configuration is incorrect ! The application"
					+ " cannot start. Please check your Spring profile,current profiles are: {}",
					Arrays.toString(env.getActiveProfiles()));
			throw new ApplicationContextException("Database connection pool is not configured correctly");
		}
		HikariConfig config = new HikariConfig();
		config.setDataSourceClassName(dataSourceProperties.getDriverClassName());
		if(StringUtils.isEmpty(dataSourceProperties.getUrl())){
			config.addDataSourceProperty("databaseName", databaseName);
			config.addDataSourceProperty("serverName", appProperties.getDatasource().getServerName());
		}else{
			config.addDataSourceProperty("url", dataSourceProperties.getUrl());
		}
		if(dataSourceProperties.getUsername() != null) {
			config.addDataSourceProperty("user", dataSourceProperties.getUsername());
		}else{
			config.addDataSourceProperty("user", "");
		}
		if(dataSourceProperties.getPassword() != null){
			config.addDataSourceProperty("password", dataSourceProperties.getPassword());
		}else{
			config.addDataSourceProperty("password", "");
		}
		//Mysql optimizations, see https://github.com/brettwooldridge/HikariCP/wiki/MySQL-Configuration
		if("com.mysql.jdbc.jdbc2.optional.MysqlDataSource".equals(dataSourceProperties.getDriverClassName())) {
			config.addDataSourceProperty("cachePrepStmts", appProperties.getDatasource().isCachePrepStmts());
			config.addDataSourceProperty("prepStmtCacheSize", appProperties.getDatasource().getPreStmtCacheSize());
			config.addDataSourceProperty("prepStmtCacheSqlLimit", appProperties.getDatasource().getPreStmtCacheSqlLimit());
		}
		//base data
		return new HikariDataSource(config);
	}

	@Bean
	public SpringLiquibase liquibase(DataSource dataSource, DataSourceProperties dataSourceProperties,
			LiquibaseProperties liquibaseProperties) {
		
		//Use liquibase.integration.spring.SpringLiquibase 
		// if you don,t want Liquibase to start asynchronously
		SpringLiquibase liquibase = new AsyncSpringLiquibase();
		liquibase.setDataSource(dataSource);
		liquibase.setChangeLog(appproperties.getLiquibase().getChangeLog());
		liquibase.setContexts(liquibaseProperties.getContexts());
		if(env.acceptsProfiles(Constants.SPRING_PROFILE_FAST)) {
			if("org.h2.jdbcx.JdbcDataSource".equals(dataSourceProperties.getDriverClassName())) {
				liquibase.setShouldRun(true);
				logger.warn("Using '{}' profile with H2 database in memory is not optimal,"
						+ " you should consider switching to Mysql or Postgresql to void rebuilding"
						+ " your databse upon each start.", Constants.SPRING_PROFILE_FAST);
			}else{
				liquibase.setShouldRun(false);
			}
		}else{
			logger.debug("Configuring Liquibase.");
		}
		return liquibase;
	}
	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}

	/*@Bean
	public Hibernate4Module hibernate4Module() {
		return new Hibernate4Module();
	}*/

}
