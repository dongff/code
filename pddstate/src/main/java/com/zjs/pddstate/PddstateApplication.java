package com.zjs.pddstate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
//定时器
@EnableScheduling
@SpringBootApplication
public class PddstateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PddstateApplication.class, args);
	}

}