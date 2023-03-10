package com.zjs.pddstate.http;


import com.zjs.pddstate.model.zjs.waybill.BaseResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 宅急送状态信息查询接口
 * @Author: Lic
 * @create: 2018/5/15 17:04
 */
@Component
@Slf4j
public class ZjsWaybillHttp {

    @Autowired
    private ZjsWaybillFeign zjsWaybillFeign;

    /**
     * 客户单号查询状态接口
     *  客户单号100310
        客户编码123123（月结编码）
     * @Author: Lic
     * @create: 2019/5/8 15:00
     * @param
     * @return
     */
    public BaseResp zjsWaybillState(String uuid, String logisticsOrderNo) {
        BaseResp baseResp = new BaseResp();
        try {
            String repuest ="{\"vwocodes\": [\""
                    +logisticsOrderNo+
                    "\"]}";
            log.info(uuid+" 运单中心状态查询入参："+repuest);
            baseResp = zjsWaybillFeign.zjsWaybillState(repuest);
            log.info(uuid+" 运单中心状态查询结果: {}",baseResp.toString());

        } catch (Exception e) {
            baseResp.setCode(-1);
            log.error(uuid+" 状态查询异常！", e);
        }
        return baseResp;
    }
}
