package cn.demo.random.aop;

import java.lang.annotation.Annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLogger {

	private static final Logger logger = LoggerFactory.getLogger(ControllerLogger.class);
	
//	@Pointcut("within(cn.demo.random.controller..*)")
//	@Pointcut(value = "bean(*Controller)")
	@Pointcut(value="@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void controller(){}
	
	@Before("controller()")
	public void logger(JoinPoint point){
		Signature signature = point.getSignature();
		String name = signature.getName();
		Object[] args = point.getArgs();
		String kind = point.getKind();
		Annotation[] annotations = point.getTarget().getClass().getAnnotations();
		logger.info("--- {} is invoked args:{} kind: {}- annotations:{}--------------", 
				name, args, kind, annotations);
	}
	
}
