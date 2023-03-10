package com.zjs.pddstate.model.pdd.subscribe;

import lombok.Data;

/**
 * 状态订阅
 * @Author: Lic
 * @create: 2020/8/12 14:11
 */
@Data
public class Subscribe {
    /**
     * 运单号
     */
    private String trackingNumber;
    /**
     * 物流订单号
     */
    private String trackingOrderNo;

}
