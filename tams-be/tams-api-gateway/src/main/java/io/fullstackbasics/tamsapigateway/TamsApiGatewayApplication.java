package io.fullstackbasics.tamsapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TamsApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TamsApiGatewayApplication.class, args);
	}

}
