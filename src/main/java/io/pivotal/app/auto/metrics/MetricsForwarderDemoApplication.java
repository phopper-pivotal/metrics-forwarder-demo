package io.pivotal.app.auto.metrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MetricsForwarderDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetricsForwarderDemoApplication.class, args);
	}
}
