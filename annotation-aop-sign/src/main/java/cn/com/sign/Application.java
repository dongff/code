package cn.com.sign;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-22 13:58
 * @modified By:
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {


        BeanFactory bf=
        SpringApplication.run(Application.class, args);
    }
}
