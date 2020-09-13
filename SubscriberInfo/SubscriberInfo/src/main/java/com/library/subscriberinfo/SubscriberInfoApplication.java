package com.library.subscriberinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SubscriberInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriberInfoApplication.class, args);
	}

}
