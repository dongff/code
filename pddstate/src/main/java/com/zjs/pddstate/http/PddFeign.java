package com.zjs.pddstate.http;

import com.zjs.pddstate.aop.WebAop;
import com.zjs.pddstate.model.pdd.PddRequest;
import com.zjs.pddstate.model.pdd.PddResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spp.model.mongodb.Edi_Nwc_CC;

import java.util.List;

/**
 * @Author: Lic
 * @create: 2020/8/13 10:31
 */
@Component
@FeignClient(name="pdd",url = "https://")
public interface PddFeign {
    /**
     * 拼多多通用接口
     * @Author: Lic
     * @create: 2019/7/17 15:13
     */
    @RequestMapping(value = "${pdd.url}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PddResponse general(@RequestBody PddRequest<String> pddRequest);

    /**
     * 拼多多通用字符串测试接口
     * @Author: Lic
     * @create: 2019/7/17 15:13
     */
    @RequestMapping(value = "${pdd.url}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    String genera(@RequestBody PddRequest<String> pddRequest);
}
