package io.fullstackbasics.careerportalservice;

import fullstackbasics.io.tamscoreapi.configuration.AxonXStreamConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@Import({AxonXStreamConfig.class})
public class CareerPortalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CareerPortalServiceApplication.class, args);
	}

}
