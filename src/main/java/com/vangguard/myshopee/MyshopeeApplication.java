package com.vangguard.myshopee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyshopeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyshopeeApplication.class, args);
	}

}
