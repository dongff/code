package com.zjs.pddstate.http;

import com.zjs.pddstate.model.zjs.sign.SignReq;
import com.zjs.pddstate.model.zjs.sign.SignResp;
import com.zjs.pddstate.model.zjs.waybill.BaseResp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
  * 宅急送运单中心接口
  * @Author: Lic
  * @create: 2020/5/27 15:26
  * @param
  * @return
  */
@Component
@FeignClient(name="waybill",url = "http://")
public interface ZjsWaybillFeign {

    /**
     * 运号查询状态信息接口
     * @Author: Lic
     * @create: 2019/7/9 9:16
     */
    @RequestMapping(value = "${zjs.waybill.state.url}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    BaseResp zjsWaybillState(@RequestBody String repuest);



    /**
     * 运号查询第三方转件签收信息接口
     * @Author: Lic
     * @create: 2019/7/9 9:16
     */
    @RequestMapping(value = "${zjs.waybill.sign.url}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    SignResp zjsWaybillSignDesc(@RequestBody SignReq signReq);


}
