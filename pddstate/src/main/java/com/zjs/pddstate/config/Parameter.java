package com.zjs.pddstate.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @Author: Lic
 * @create: 2020/8/27 13:47
 */
@Slf4j
@Component
public class Parameter {

    //#合作伙伴身份标识，拼多多会为每个合作伙伴分配一个ship_id
    public static String ship_id;
    //#快递公司client_id
    public static String client_id;
    //#拼多多的client_id
    public static String target_client_id;
    //二级城市编码
    public static HashMap<String,String> citymap;

    @Value("${pdd.ship_id}")
    private String ship_ids;

    @Value("${pdd.client_id}")
    private String client_ids;

    @Value("${pdd.target_client_id}")
    private String target_client_ids;

    @PostConstruct
    private void init(){
        ship_id = ship_ids;
        client_id = client_ids;
        target_client_id =target_client_ids;
    }
}
