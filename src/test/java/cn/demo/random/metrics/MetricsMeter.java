package cn.demo.random.metrics;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

public class MetricsMeter {

	private static final MetricRegistry metrics = new MetricRegistry();
	private static final ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).build();
	private static final Meter requests = metrics.meter(MetricRegistry.name(MetricsMeter.class, "request"));
	
	public static void handleRequest(){
		requests.mark();
	}
	@Test
	public void test() throws InterruptedException{
		reporter.start(1, TimeUnit.SECONDS);
		for(int i=0;i<20;i++){
			handleRequest();
			Thread.sleep(100);
		}
	}
}
