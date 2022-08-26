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
