package com.sunman.springboot.fuelstation.api.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringbootFuelStationEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFuelStationEurekaServerApplication.class, args);
	}

}
