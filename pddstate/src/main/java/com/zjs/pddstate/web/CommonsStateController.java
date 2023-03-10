package com.zjs.pddstate.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zjs.pddstate.config.Parameter;
import com.zjs.pddstate.http.PddFeign;
import com.zjs.pddstate.http.ZjsWaybillFeign;
import com.zjs.pddstate.model.pdd.PddRequest;
import com.zjs.pddstate.model.pdd.PddResponse;
import com.zjs.pddstate.model.pdd.state.Trace;
import com.zjs.pddstate.model.zjs.sign.SignReq;
import com.zjs.pddstate.model.zjs.sign.SignResp;
import com.zjs.pddstate.util.Constants;
import com.zjs.pddstate.util.SignUtil;
import com.zjs.pddstate.util.Util;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spp.model.common.CommonMsgModel;
import spp.model.mongodb.Edi_Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.zjs.pddstate.util.Util.objMapper;

/**
 * @author: 轨迹推送
 * @Description:
 * @Date: Created in 10:50 2019/5/23
 * @Modified By:
 */
@Slf4j
@RestController
public class CommonsStateController {

    @Autowired
    Util util;

    @Autowired
    PddFeign pddFeign;

    @Autowired
    ZjsWaybillFeign zjsWaybillFeign;

    @Autowired
    SignUtil signUtil;

    @ApiOperation(value = "物流轨迹推送")
    @RequestMapping(value = "/acceptstatedata", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Edi_Log acceptCommonData(@RequestBody CommonMsgModel cmm) throws JsonProcessingException {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String cmmjson = objMapper.writeValueAsString(cmm);
        log.info("{} 拼多多物流轨迹推送-------:{}", uuid, cmmjson);
        String desc = "";
        try {
            //默认正常单
            if (cmm.getWt() == null) {
                cmm.setWt(Constants.NORMAL_ORDER);
            }

            if (Constants.DIFFERENT_ORDER.contains(cmm.getWt())) {
                return new Edi_Log(true, cmmjson, "2202异字单，不做推送!");
            }
            Trace trace = new Trace();
            trace.setTrackingNumber(cmm.getWc());
            trace.setTrackingOrderNo(cmm.getCc());
            trace.setId(uuid);
            trace.setOperationTime(cmm.getOt());
            trace.setTransferFlag(0);
            //转件
            if (Constants.NODE_7.equals(cmm.getNd())) {
                trace.setStatus("OTHER");
                trace.setDescription("已转件");
                trace.setTransferFlag(1);
                trace.setTransferNo(cmm.getTwc());
                trace.setTransferPartnerId(util.transferPartnerId(cmm.getTrn()));
            }
            trace.setTimeZone("+08:00");
            trace.setSiteName(cmm.getOun());
            trace.setSiteType(util.unitType(cmm.getOst()));
            trace.setSiteNo(cmm.getOuc());
            trace.setNextSiteName(cmm.getNn());
            trace.setNextSiteType(util.unitType(cmm.getNet()));
            trace.setNextSiteNo(cmm.getNec());
            trace.setCountry("CN");
            trace.setProvince(cmm.getOp());
            trace.setCity(Parameter.citymap.get(cmm.getRc()));
            trace.setContact(cmm.getOne());
            trace.setContactInfo(cmm.getOnp());
            switch (cmm.getNd()) {
                case Constants.NODE_1:
                    desc = "揽收";
                    trace.setStatus("GOT");
                    trace.setDescription("[" + cmm.getPun() + "] 已揽收");
                    break;
                case Constants.NODE_2:
                    desc = "入库";
                    trace.setStatus("ARRIVAL");
                    trace.setDescription("到达 [" + cmm.getOun() + "]");
                    break;
                case Constants.NODE_3:
                    desc = "出库";
                    trace.setStatus("DEPARTURE");
                    trace.setDescription("离开[" + cmm.getOun() + "] 发往 [" + cmm.getNn() + "]");

                    break;
                case Constants.NODE_4:
                    desc = "派送";
                    trace.setStatus("SEND");
                    trace.setDescription("离开 [" + cmm.getOun() + "] 派送中，递送员[" + cmm.getDn() + "]，电话[" + cmm.getDm() + "]");
                    break;
                case Constants.NODE_6:
                    desc = "签收";
                    trace.setStatus("SIGN");
                    trace.setSignerName(cmm.getSn());

                    // 描述
                    //  trace.setDescription("客户已签收 签收人：" + cmm.getSn());
                    trace.setDescription(signDesc(uuid, cmm));

                    break;

                case Constants.NODE_S2:
                    desc = "入库";
                    trace.setStatus("ARRIVAL");
                    trace.setDescription(cmm.getStdc());
                    break;
                case Constants.NODE_S3:
                    desc = "出库";
                    trace.setStatus("DEPARTURE");
                    trace.setDescription(cmm.getStdc());

                    break;
                case Constants.NODE_S4:
                    desc = "派送";
                    trace.setStatus("SEND");
                    trace.setDescription(cmm.getStdc());
                    break;

                default:
                    break;
            }

            //返货单
            if ("2204".equals(cmm.getWt())) {
                if (Constants.NODE_1.equals(cmm.getNd())) {
                    /*返货签收就是拒收*/
                    desc = "拒收";
                    trace.setDescription("拒收,原因:" + cmm.getSpa().get("fbacktype"));
                    trace.setStatus("REJECTION");
                    trace.setFailReason("REJECTION_211");
                } else {
                    trace.setStatus("RETURN");
                }
            }
            PddRequest<String> pddRequest = new PddRequest<>();
            pddRequest.setShip_id(Parameter.ship_id);
            pddRequest.setTarget_client_id(Parameter.target_client_id);
            pddRequest.setData_type("JSON");
            pddRequest.setType("pdd.logistics.co.track.notify");
            pddRequest.setClient_id(Parameter.client_id);
            pddRequest.setTimestamp(System.currentTimeMillis() / 1000);
            List<Trace> list = new ArrayList<>();
            list.add(trace);
            pddRequest.setData(objMapper.writeValueAsString(list));
            pddRequest.setSign(signUtil.generateSign(pddRequest));
            log.info(uuid + " 状态回传接口入参：" + objMapper.writeValueAsString(pddRequest));
            PddResponse pddResponse = pddFeign.general(pddRequest);
            log.info(uuid + " 状态回传接口结果：" + objMapper.writeValueAsString(pddResponse));
            if (pddResponse.getResponse_items().get(0).getSuccess()) {
                return new Edi_Log(true);
            }
            log.info(uuid + " 状态回传失败！");
            return new Edi_Log(false);
        } catch (Exception e) {
            log.warn("{}，订单号:{}状态推送异常，异常信息：{}", uuid, cmm.getWc(), e.getMessage());
            return new Edi_Log(false);
        }
    }

    /**
     * 查询签收状态接口
     *
     * @return
     */
    private String signDesc(String uuid, CommonMsgModel cmm) {

        String signdesc = "客户已签收 签收人：" + cmm.getSn();
        SignReq signReq = new SignReq();
        signReq.setCustomerCode(cmm.getCe());
        signReq.setVwocode(cmm.getWc());

        signReq.setLogisticProviderID(cmm.getCf());
        try {
            log.info(uuid + " 运单中心状态查询入参：" + signReq.toString());
            SignResp signResp = zjsWaybillFeign.zjsWaybillSignDesc(signReq);
            log.info(uuid + " 运单中心状态查询结果: {}", signResp.toString());
            if (signResp.getCode() == 0 && signResp.getData() != null) {
                //拼接信息："，" + [承运商名称] + "运单号：" + [转件单号] + "，" + [转件描述]
                signdesc += "，" + signResp.getData().getCompanyName() + ",运单号：" + signResp.getData().getCourierNumber() + "," + signResp.getData().getStatusDesc();
            }
        } catch (Exception e) {
            log.error(uuid + " 状态查询异常！", e);
        }
        return signdesc;
    }
}
