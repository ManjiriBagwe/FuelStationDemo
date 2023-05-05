package com.sunman.springboot.fuelstation.fuelsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootFuelStationFuelSaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFuelStationFuelSaleApplication.class, args);
	}


    //For consuming service from Eureka clients
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
