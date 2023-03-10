package com.zjs.pddstate.util;

import com.zjs.pddstate.model.pdd.PddResponse;

/**
 * @Author: Lic
 * @create: 2020/8/21 16:19
 */
public class WebErrorUtil {
    /**
     * 异常类
     * @Author: Lic
     * @create: 2020/8/21 16:23
     */
    public static PddResponse getString(String ship_id,boolean success, String reasonCode) {
        PddResponse pddResponse = new PddResponse();
        pddResponse.setShip_id(ship_id);
        pddResponse.setSuccess(success);
        pddResponse.setReason_code(reasonCode);
        return pddResponse;
    }
}
