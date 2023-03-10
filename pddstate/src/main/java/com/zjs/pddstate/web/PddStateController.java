package com.zjs.pddstate.web;

import com.zjs.pddstate.aop.WebAop;
import com.zjs.pddstate.model.pdd.PddQueryResponse;
import com.zjs.pddstate.model.pdd.PddRequest;
import com.zjs.pddstate.model.pdd.PddResponse;
import com.zjs.pddstate.service.PddCitiesService;
import com.zjs.pddstate.service.PddQueryStateService;
import com.zjs.pddstate.service.PddStateSubscribeService;
import com.zjs.pddstate.util.DateHandleUtil;
import com.zjs.pddstate.util.SignUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Author: Lic
 * @create: 2020/8/12 14:06
 */
@Api("拼多多 API")
@Slf4j
@RestController
public class PddStateController {

    @Autowired
    PddStateSubscribeService pddStateSubscribeService;

    @Autowired
    PddQueryStateService pddQueryStateService;

    @Autowired
    PddCitiesService pddCitiesService;

    @Autowired
    SignUtil signUtil;

    @Autowired
    HttpServletRequest request;

    @WebAop("拼多多状态订阅接口")
    @ApiOperation(value = "拼多多状态订阅接口", notes = "拼多多状态订阅接口")
    @PostMapping("/state/subscribe")
    public PddResponse subscribe(@RequestBody PddRequest<String> pddRequest){
        return pddStateSubscribeService.subscribe((String) request.getAttribute("uuid"), pddRequest);
    }

    @WebAop("拼多多状态查询接口")
    @ApiOperation(value = "拼多多状态查询接口", notes = "拼多多状态查询接口")
    @PostMapping("/state/queryState")
    public PddQueryResponse queryState(@RequestBody PddRequest<String> pddRequest){
        return pddQueryStateService.queryState((String) request.getAttribute("uuid"), pddRequest);
    }

    @Scheduled(cron = "${timer}")
    @PostConstruct
    public void city(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        log.info(DateHandleUtil.getCurTime()+" 二级城市定时查询开始");
        pddCitiesService.city(uuid);
        log.info(DateHandleUtil.getCurTime()+" 二级城市定时查询结束");
    }
}

