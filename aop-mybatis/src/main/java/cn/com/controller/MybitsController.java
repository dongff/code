package cn.com.controller;

import cn.com.dao.ProductInfoMapper;
import cn.com.except.NotControllerResponseAdvice;
import cn.com.model.ProductInfo;
import cn.com.model.ProductInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-07-15 14:39
 * @modified By:
 */
@RestController
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

    @PostMapping(value = "/findByVo", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object findByVo(@Validated @RequestBody ProductInfoVo vo) {

        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(vo, productInfo);
        Object rel= productInfoMapper.selectOne(new QueryWrapper(productInfo));
        return rel;
    }

    @GetMapping("/health")
    @NotControllerResponseAdvice
    public String health() {
        return "success";
    }

}
