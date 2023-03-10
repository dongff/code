package com.zjs.pddstate.service;

import com.zjs.pddstate.config.Parameter;
import com.zjs.pddstate.http.PddFeign;
import com.zjs.pddstate.model.pdd.PddRequest;
import com.zjs.pddstate.model.pdd.PddResponse;
import com.zjs.pddstate.model.pdd.city.CityInfo;
import com.zjs.pddstate.util.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 二级城市查询接口
 * @Author: Lic
 * @create: 2020/8/17 9:29
 */
@Slf4j
@Service
public class PddCitiesService {

    @Autowired
    PddFeign pddFeign;

    @Autowired
    SignUtil signUtil;

//    @Autowired
//    StringRedisTemplate stringRedisTemplate;

    /**
     * 二级城市
     * @Author: Lic
     * @create: 2020/8/12 14:55
     */
    public void city(String uuid){
        try {
            PddRequest<String> pddRequest = new PddRequest<>();
            pddRequest.setShip_id(Parameter.ship_id);
            pddRequest.setTarget_client_id(Parameter.target_client_id);
            pddRequest.setData_type("JSON");
            pddRequest.setType("pdd.logistics.secondary.city.get");
            pddRequest.setClient_id(Parameter.client_id);
            pddRequest.setTimestamp(System.currentTimeMillis()/ 1000);
            pddRequest.setSign(signUtil.generateSign(pddRequest));
            log.info(uuid+"拼多多二级城市查询接口入参："+ pddRequest);
            PddResponse pddResponse = pddFeign.general(pddRequest);
            log.info(uuid+"拼多多二级城市查询接口结果："+ pddResponse);
            if(pddResponse.getResponse().getSuccess()){
                HashMap<String,String> map = new HashMap<>();
                for (CityInfo cityInfo:pddResponse.getResponse().getData()) {
                    map.put(cityInfo.getCityName(),cityInfo.getCityCode());
                    //stringRedisTemplate.opsForValue().set("pdd:city:"+cityInfo.getCityName(),cityInfo.getCityCode());
                }
                Parameter.citymap = map;
                log.info(uuid+"二级城市插入内存完成！");
            }
        } catch (Exception e) {
            log.error(uuid+" 数据异常",e);
        }
    }

}
