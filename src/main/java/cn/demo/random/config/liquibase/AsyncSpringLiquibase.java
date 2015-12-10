package cn.demo.random.config.liquibase;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.core.task.TaskExecutor;
import org.springframework.util.StopWatch;

import cn.demo.random.config.Constants;
import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;

/**
 * Special liquibase.integration.spring.SpringLiquibase that will update the database asynchronously
 * <p>
 * 	By default, this asyncchronous version lnly works when usering "dev" profile.<br>
 * 	The standard liquibase.inegration.spring.SpringLiquibase starts Liquibase in the current thread:
 * 	<ul>
 * 		<li>This is needed id you want to do some database requests at startup</li>
 * 		<li>This ensure that the database is ready when the application starts</li>
 *  </ul
 *  But as this is a rather slow process, we use this asynchronous version to speed up our start-uo time:
 *  <ul>
 *  	<li>On a recent Macbook Pro, start-up time is down from 14 seconds to 8 seconds</li>
 *  	<li>In production, this can help your application run on platforms like Herku,where it must start/restart very quickly</li>
 *  </ul>
 * </p>
 * @author Yo
 *
 */
public class AsyncSpringLiquibase extends SpringLiquibase {
	
	private final Logger logger = org.slf4j.LoggerFactory.getLogger(AsyncSpringLiquibase.class);
	
	@Autowired
	@Qualifier("taskExecutor")
	private TaskExecutor taskExecutor;
	
	@Autowired
	private Environment env;
	
	@Override
	public void afterPropertiesSet() throws LiquibaseException {
		if(env.acceptsProfiles(Constants.SPRING_PROFILE_DEVELOPMENT)) {
			taskExecutor.execute(new Runnable() {
				@Override
				public void run() {
					logger.warn("Starting Liquibase asynchronously,"
							+ " your databse might not be ready at startup!");
					try {
						initDb();
					} catch (LiquibaseException e) {
						e.printStackTrace();
					}
				}
			});
		}else{
			logger.debug("Starting Liquibase synchronously");
			super.afterPropertiesSet();
		}
	}



	protected void initDb() throws LiquibaseException{
		StopWatch watch = new StopWatch();
		watch.start();
		super.afterPropertiesSet();
		watch.stop();
		logger.debug("Started Liquibase in {} ms", watch.getTotalTimeMillis());
	}

}
