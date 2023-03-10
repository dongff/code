package com.zjs.pddstate.model.pdd;

import lombok.Data;

/**
 * 拼多多通用入参实体
 * @Author: Lic
 * @create: 2020/8/12 14:14
 */
@Data
public class PddRequest<T> {
    /**
     * 快递公司的client_id
     */
    private String client_id;
    /**
     * 响应格式，即返回数据的格式，JSON或者XML（二选一），默认JSON，注意是大写
     */
    private String data_type;
    /**
     * 合作伙伴身份标识，拼多多会为每个合作伙伴分配一个ship_id
     */
    private String ship_id;
    /**
     * 拼多多的id
     */
    private String from_client_id;
    /**
     * 拼多多的id
     */
    private String target_client_id;
    /**
     * UNIX时间戳，单位秒,调用请求的时间
     */
    private Long timestamp;
    /**
     * 拼多多开放平台API接口名称：
        pdd.logistics.secondary.city.get(二级城市查询接口)
        pdd.logistics.co.track.notify(轨迹推送接口)
     */
    private String type;
    /**
     * 具体结果
     */
    private T data;
    /**
     * API输入参数签名结果，签名算法参考：4、SIGN生成规则
     */
    private String sign;

}
