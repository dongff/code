package com.zjs.pddstate.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spp.model.mongodb.Edi_Nwc_CC;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Lic
 * @create: 2020/8/12 14:42
 */
@Slf4j
@Service
public class ZjsHttp {

    //客户标识
    @Value("${zjs.clientFlag}")
    private String clientFlag;

    @Autowired
    ZjsFeign zjsFeign;

    /**
     * 状态订阅
     * @Author: Lic
     * @create: 2019/7/9 9:45
     */
    public boolean startSubscribe(String uuid,String mailNo,String orderNo){
        boolean flah = false;
        try {
            List<Edi_Nwc_CC> list = new ArrayList<>();
            Edi_Nwc_CC ewc = new Edi_Nwc_CC();
            //运单号
            ewc.setWc(mailNo);
            //客户单号
            ewc.setCc(orderNo);
            //客户标识
            ewc.setCf(clientFlag);
            //是否回查
            ewc.setIfhc(true);
            //当前时间
            ewc.setRt(new Date());
            list.add(ewc);

            log.info(uuid+" 请求状态订阅接口参数为 {}",list);
            flah = zjsFeign.saveBatchEdiWcCc(list);
            log.info(uuid+" 请求状态订阅接口结果为 {}",flah);
        } catch (Exception e) {
            log.warn(uuid + " 状态订阅接口异常",e);
        }
        return flah;
    }
}
