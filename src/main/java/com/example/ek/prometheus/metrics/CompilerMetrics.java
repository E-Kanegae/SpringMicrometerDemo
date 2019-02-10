package com.example.ek.prometheus.metrics;

import java.lang.management.CompilationMXBean;
import java.lang.management.ManagementFactory;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.MeterRegistry;

/**
 * prometheus-demo
 * com.example.ek.prometheus.metrics.CompilerMetrics.java
 *
 * JIT Compiler関連のメトリクス収集用クラス
 *
 * @author etsukanegae
 *
 */
@Component
public class CompilerMetrics {

	/**
	 * AP起動してからの時間 [ms]
	 */
	long totalTimeFromApStarted;

	CompilerMetrics(MeterRegistry meterRegistry){
		totalTimeFromApStarted = System.currentTimeMillis(); //AP起動時の時間
		meterRegistry.gauge("custom.metrics.jit.compile.time", this, CompilerMetrics::getTotalCompileSeconds);
	}

	/**
	 *
	 * JITの総コンパイル時間を返却するメソッド
	 *
	 * Input : none
	 * Output: long
	 * @return　総コンパイル時間　[s]
	 */
	public long getTotalCompileSeconds() {
		CompilationMXBean compilationMx = ManagementFactory.getCompilationMXBean();
		long totalTime = compilationMx.getTotalCompilationTime();
		return totalTime == 0 ? 0 : totalTime/ 1000;
	}



}
