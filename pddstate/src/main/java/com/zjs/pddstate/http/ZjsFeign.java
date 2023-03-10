package com.zjs.pddstate.http;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spp.model.mongodb.Edi_Nwc_CC;

import java.util.List;

/**
 * zjs接口
 * @Author: Lic
 * @create: 2019/6/24 15:45
 */
@Component
@FeignClient(name="zjs",url = "http://",fallback = ZjsFeignHystrix.class)
public interface ZjsFeign {

    /**
     * 状态订阅
     * @Author: Lic
     * @create: 2019/7/17 15:13
     */
    @RequestMapping(value = "${zjs.startSubscribe.url}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    boolean saveBatchEdiWcCc(@RequestBody List<Edi_Nwc_CC> ewc);

}
