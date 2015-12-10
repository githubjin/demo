package cn.demo.random.metrics;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

public class MetricsGauges {

	// 实例化一个registry, 最核心的一个模块，相对于一个应用程序的metrics系统的容器，维护一个Map
	private static final MetricRegistry metrics = new MetricRegistry();
	
	private static Queue<String> queue = new LinkedBlockingQueue<String>();
	
	private static ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).build();
	
	@Test
	public void test() throws InterruptedException{
		reporter.start(2, TimeUnit.SECONDS);
		// 实例化一个Guage
		Gauge<Integer> gauge = new Gauge<Integer>(){
			@Override
			public Integer getValue() {
				return queue.size();
			}
		};
		metrics.register(MetricRegistry.name(MetricsGauges.class, "pending-job", "size", "yo"), gauge);
		
		for(int i=0;i<20;i++){
			queue.add("Guage:" + i);
			Thread.sleep(500);
		}
	}
}
