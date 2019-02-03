package com.example.ek.prometheusdemo.web.operation;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;

/**
 * prometheus-demo
 * com.example.ek.prometheusdemo.web.mem.MemoryOperateController.java
 *
 * メトリクス収集のテスト用に色々な操作をするためのControllerクラス
 *
 * @author etsukanegae
 *
 */
@RestController
@Timed
@RequestMapping("operation")
public class SeveralOperateController {

	private static final int THREAD_SLEEP_TIME = 5000;

	/**
	 * メモリを消費させるメソッド
	 *
	 * @return 文字列
	 */
	@GetMapping("memory")
	public String memory() {
		List<String> list = new LinkedList<String>();
		for (int i = 0; i < 1024; i++) {
			list.add(new String(new byte[1024]));
		}
		list = null;
		return "Memory Operation Success";
	}

	/**
	 *
	 * {@link com.example.ek.prometheusdemo.web.operation.SeveralOperateController.THREAD_SLEEP_TIME}
	 * から発生させた乱数分だけ時間のかかるメソッド
	 *
	 * @return　文字列
	 */
	@GetMapping("sleep")
	public String sleep() {
		try {
			Thread.sleep(new Random().nextInt(THREAD_SLEEP_TIME));
		} catch (InterruptedException e) {
			e.printStackTrace();
			return "Thread Sleep Fail";
		}
		return "Thread Sleep Success";
	}

}
