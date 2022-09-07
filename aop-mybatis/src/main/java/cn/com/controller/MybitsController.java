package cn.com.controller;

import cn.com.dao.ProductInfoMapper;
import cn.com.except.NotControllerResponseAdvice;
import cn.com.model.ProductInfo;
import cn.com.model.ProductInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-07-15 14:39
 * @modified By:
 */
@RestController
@Slf4j
public class MybitsController {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    /**
     * 拼接两个字符串
     */
    @GetMapping(value = "/joint1")
    public String joint1(String str1, String str2) {
        return str1 + "+" + str2;
    }


    /**
     * (1)value：指定发生的异常进行重试
     * (2)include：和value一样，默认空，当exclude也为空时，所有异常都重试
     * (3)exclude：指定异常不重试，默认空，当include也为空时，所有异常都重试
     * (4)maxAttemps：重试次数，默认3
     * (5)backoff：重试补偿机制，默认没有
     *
     *@Backoff 注解 重试补偿策略:
     * (1)不设置参数时，默认使用FixedBackOffPolicy（指定等待时间），重试等待1000ms
     * (2)设置delay，使用FixedBackOffPolicy（指定等待设置delay和maxDealy时，重试等待在这两个值之间均态分布）
     * (3)设置delay、maxDealy、multiplier，使用 ExponentialBackOffPolicy（指数级重试间隔的实现），multiplier即指定延迟倍数，比如delay=5000L，multiplier=2,则第一次重试为5秒，第二次为10秒，第三次为20秒
     *
     * delay间隔重试时间
     * @param vo
     * @return
     */
    @Retryable(value = RestClientException.class,maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 2))
    @PostMapping(value = "/findByVo", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object findByVo( @Valid @RequestBody ProductInfoVo vo) {

        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(vo, productInfo);
        Object rel = productInfoMapper.selectOne(new QueryWrapper(productInfo));
        return rel;
    }

    @GetMapping("/health")
    @NotControllerResponseAdvice
    public String health() {
        return "success";
    }


    @Autowired
    @Qualifier("simpleRetryTemplate")
    private RetryTemplate retryTemplate;

    @GetMapping("/springRetryTest")
    public void springRetryTest() {
        retryTemplate.execute(context -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
            log.info("这是第" + (context.getRetryCount() + 1) + "次重试:" + sdf.format(new Date()));
            throw new RuntimeException();
        });
    }


}
