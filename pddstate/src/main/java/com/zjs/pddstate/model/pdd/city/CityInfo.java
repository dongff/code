package com.zjs.pddstate.model.pdd.city;

import lombok.Data;

/**
 * @Author: Lic
 * @create: 2020/8/17 9:57
 */
@Data
public class CityInfo {
    /**
     * 城市编码
     */
    private String cityCode;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 刷新时间。格式：yyyy-MM-dd HH:mm:ss
     */
    private String refreshTime;
}
