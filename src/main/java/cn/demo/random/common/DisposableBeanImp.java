package cn.demo.random.common;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class DisposableBeanImp implements DisposableBean {

	private static final Logger logger = LoggerFactory.getLogger(DisposableBeanImp.class);
	
	@Override
	public void destroy() throws Exception {
		logger.info("---------------ApplicationContext closed------------------");
	}
	
//	@PreDestroy
	public void preDestroy(){
		logger.info("-------@PreDestroy--------ApplicationContext closed------------------");
	}

}
