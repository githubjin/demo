package cn.demo.random.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImp implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CommandLineRunnerImp.class);
	
	@Override
	public void run(String... args) throws Exception {
		StringBuilder sb = new StringBuilder("");
		for(String arg : args){
			sb.append(arg).append(" ; ");
		}
		logger.info("-------------------------CommandLineRunner: Application started--------------------------args:{}", sb.toString());
	}

}
