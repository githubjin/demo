package cn.demo.random.async;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.task.AsyncTaskExecutor;

public class ExceptionHandlingAsyncTaskExecutor implements InitializingBean, AsyncTaskExecutor, DisposableBean {

	private final Logger logger = LoggerFactory.getLogger(ExceptionHandlingAsyncTaskExecutor.class);
	private final AsyncTaskExecutor executor;
	
	public ExceptionHandlingAsyncTaskExecutor(AsyncTaskExecutor executor) {
		this.executor = executor;
	}

	@Override
	public void execute(Runnable task) {
		executor.execute(task);
	}

	@Override
	public void destroy() throws Exception {
		if(this.executor instanceof DisposableBean) {
			DisposableBean bean = (DisposableBean)this.executor;
			bean.destroy();
		}
	}

	@Override
	public void execute(Runnable task, long startTimeout) {
		executor.execute(this.createWrappedRunable(task), startTimeout);
	}
	
	private Runnable createWrappedRunable(final Runnable task) {
		return () -> {
			try {
				task.run();
			}catch (Exception e) {
				handle(e);
			}
		};
	}
	
	protected void handle(Exception e) {
		logger.error("Caught async exception", e);
	}

	@Override
	public Future<?> submit(Runnable task) {
		return this.executor.submit(this.createWrappedRunable(task));
	}

	@Override
	public <T> Future<T> submit(Callable<T> task) {
		return this.executor.submit(createCallable(task));
	}
	
	private <T> Callable<T> createCallable(final Callable<T> task) {
		return () -> {
			try {
				return task.call();
			} catch (Exception e) {
				this.handle(e);
				throw e;
			}
		};
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(this.executor instanceof InitializingBean) {
			InitializingBean bean = (InitializingBean)this.executor;
			bean.afterPropertiesSet();
		}
	}

}
