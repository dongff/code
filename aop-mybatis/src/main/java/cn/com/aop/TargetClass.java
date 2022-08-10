package cn.com.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 被代理对象
 */
@RestController
public class TargetClass {


    /**
     * 拼接两个字符串
     */
    @RequestMapping(value="/joint")
    public String joint(String str1, String str2) {
        return str1 + "+" + str2;
    }
}

