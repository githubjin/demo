package cn.demo.random.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;

import static com.codahale.metrics.MetricRegistry.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class MetricsCounter {

	private static final MetricRegistry metrics = new MetricRegistry();
	private static ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).build();
	private static Counter pendingJobs = metrics.counter(name(MetricsCounter.class, "pendding-jobs"));
	
	private static Queue<String> queue = new LinkedList<String>();
	
	public static void add(String str){
		pendingJobs.inc();
		queue.offer(str);
	}
	
	public static void take(){
		pendingJobs.dec();
		queue.poll();
	}
	
	@Test
	public void test() throws InterruptedException{
		reporter.start(1, TimeUnit.SECONDS);
		for(int i=0;i<20;i++){
			add("Counter add " + i);
			Thread.sleep(50);
			take();
		}
	}
	
}
