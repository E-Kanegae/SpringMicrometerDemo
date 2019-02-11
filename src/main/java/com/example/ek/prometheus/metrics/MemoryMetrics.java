package com.example.ek.prometheus.metrics;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.MeterRegistry;


/**
 * prometheus-demo
 * com.example.ek.prometheus.metrics.MemoryMetrics.java
 *
 * MemoryMXBeanからメモリ情報を取得するメトリクス収集用カスタムクラス
 *
 * @author etsukanegae
 *
 */
@Component
public class MemoryMetrics {

	MemoryMetrics(MeterRegistry meterRegistry){
		meterRegistry.gauge("custom.metrics.heap.used", this, MemoryMetrics::getUsedHeapMemoryUsage);
		meterRegistry.gauge("custom.metrics.non-heap.used", this, MemoryMetrics::getUsedNonHeapMemoryUsage);
	}

	/**
	 *
	 *
	 * このアプリケーションが使用しているヒープ容量を返却するメソッド
	 *
	 * Input : none
	 * Output: long
	 * @return ヒープ使用量 Kbytes
	 */
	public long getUsedHeapMemoryUsage(){
		MemoryMXBean memoryMx = ManagementFactory.getMemoryMXBean();
		long usedHeap = memoryMx.getHeapMemoryUsage().getUsed();

		return usedHeap;
	}

	/**
	 *
	 * このアプリケーションが使用しているノンヒープ容量を返却するメソッド
	 *
	 * Input : none
	 * Output: long
	 * @return ノンヒープ使用量 Kbytes
	 */
	public long getUsedNonHeapMemoryUsage(){
		MemoryMXBean memoryMx = ManagementFactory.getMemoryMXBean();
		long usedNonHeap = memoryMx.getNonHeapMemoryUsage().getUsed();
		return usedNonHeap;
	}

}
