package cn.com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-07-15 14:17
 * @modified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "cn.com.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
