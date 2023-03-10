package com.zjs.pddstate.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import spp.model.mongodb.Edi_Nwc_CC;

import java.util.List;

/**
 * @Author: Lic
 * @create: 2020/8/24 13:40
 */
@Slf4j
@Component
public class ZjsFeignHystrix implements ZjsFeign {

    @Override
    public boolean saveBatchEdiWcCc(List<Edi_Nwc_CC> ewc) {
        log.error("订单号"+ewc.get(0).getWc()+" 状态订阅异常！服务降级！");
        return false;
    }
}
