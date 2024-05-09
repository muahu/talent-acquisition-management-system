package io.fullstackbasics.talentrequestservice;

import fullstackbasics.io.tamscoreapi.configuration.AxonXStreamConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Import({AxonXStreamConfig.class})
public class TalentRequestServiceApplication {

	@Value("${spring.application.name}")
	private String serviceName;

	@Autowired
	private Environment environment;

	@GetMapping("/test")
	public String getTest(){
		return "Test from the "+ serviceName + " " +environment.getProperty("local.server.port");
	}


	public static void main(String[] args) {
		SpringApplication.run(TalentRequestServiceApplication.class, args);
	}

}
