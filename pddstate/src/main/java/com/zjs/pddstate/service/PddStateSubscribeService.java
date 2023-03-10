package com.zjs.pddstate.service;

import com.zjs.pddstate.http.ZjsHttp;
import com.zjs.pddstate.model.pdd.PddRequest;
import com.zjs.pddstate.model.pdd.PddResponse;
import com.zjs.pddstate.model.pdd.subscribe.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.zjs.pddstate.util.Util.objMapper;

/**
 * @Author: Lic
 * @create: 2020/8/12 14:32
 */
@Slf4j
@Service
public class PddStateSubscribeService {

    @Autowired
    ZjsHttp zjsHttp;

    /**
     * 状态订阅接口
     * @Author: Lic
     * @create: 2020/8/12 14:55
     */
    public PddResponse subscribe(String uuid, PddRequest<String> pddRequest){
        PddResponse pddResponse = new PddResponse();
        pddResponse.setShip_id(pddRequest.getShip_id());
        pddResponse.setSuccess(false);
        pddResponse.setReason_code("9999");
        try {
            Subscribe subscribe = objMapper.readValue(pddRequest.getData(),Subscribe.class);
            boolean flah = zjsHttp.startSubscribe(uuid, subscribe.getTrackingNumber(), subscribe.getTrackingOrderNo());
            if(flah){
                pddResponse.setSuccess(true);
                pddResponse.setReason_code("0");
            }
        } catch (Exception e) {
            pddResponse.setReason_code("9990");
            log.error(uuid+" 数据异常",e);
        }
        return pddResponse;
    }
}
