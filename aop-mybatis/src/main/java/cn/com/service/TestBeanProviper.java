package cn.com.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-08-23 16:16
 * @modified By:
 */
@Configuration
public class TestBeanProviper {

    @Bean("simpleRetryTemplate")
    public RetryTemplate simpleRetryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();

        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
        //默认3次，设置为5次
        simpleRetryPolicy.setMaxAttempts(5);
        retryTemplate.setRetryPolicy(simpleRetryPolicy);

        //固定等待时间 10s
        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(10000);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        return retryTemplate;

    }

}
