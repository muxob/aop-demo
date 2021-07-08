package com.solaregde.wsd.comp.aopdemo;

import com.solaregde.wsd.comp.aopdemo.dxf.task.DxfCaller;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;


@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableLoadTimeWeaving(aspectjWeaving= EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
public class AopDemoApplication implements CommandLineRunner {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		String[] dxfs = new String[] {
				"dxf1",
				"test-dxf",
				"dxf -2",
				"dxf -3",
				"dxf -4",
				"dxf -5",
				"dxf -6",
				"dxf -7",
				"dxf -8",
				"dxf -9",
				"dxf -10"
		};

		DxfCaller dxfCaller = new DxfCaller();
		Executors.newFixedThreadPool(5).invokeAll(
				Arrays.stream(dxfs).map( dxf ->
						(Callable<Void>) () -> {
							dxfCaller.callService(dxf);
							return null;
						}
				).collect(Collectors.toList()));
	}

}
