package cn.demo.random.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

import cn.demo.random.config.liquibase.AsyncSpringLiquibase;
import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {
	
	private final Logger logger = LoggerFactory.getLogger(DatabaseConfiguration.class);
	
	@Autowired
	private AppProperties appproperties;
	@Autowired
	private Environment env;

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
	public Hibernate4Module hibernate4Module() {
		return new Hibernate4Module();
	}
}
