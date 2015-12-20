package cn.demo.random.metrics;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

public class MetricsGauges {

	// ʵ����һ��registry, ����ĵ�һ��ģ�飬�����һ��Ӧ�ó����metricsϵͳ��������ά��һ��Map
	private static final MetricRegistry metrics = new MetricRegistry();
	
	private static Queue<String> queue = new LinkedBlockingQueue<String>();
	
	private static ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).build();
	
	@Test
	public void test() throws InterruptedException{
		reporter.start(2, TimeUnit.SECONDS);
		// ʵ����һ��Guage
		Gauge<Integer> gauge = new Gauge<Integer>(){
			@Override
			public Integer getValue() {
				return queue.size();
			}
		};
		metrics.register(MetricRegistry.name(MetricsGauges.class, "pending-job", "size", "yo"), gauge);
		
		for(int i=0;i<20;i++){
			queue.add("Guage:" + i);
			Thread.sleep(50);
		}
	}
}
