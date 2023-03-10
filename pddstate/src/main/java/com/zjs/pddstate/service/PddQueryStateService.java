package com.zjs.pddstate.service;

import com.zjs.pddstate.config.Parameter;
import com.zjs.pddstate.http.ZjsWaybillHttp;
import com.zjs.pddstate.model.pdd.PddQueryResponse;
import com.zjs.pddstate.model.pdd.PddRequest;
import com.zjs.pddstate.model.pdd.PddResponse;
import com.zjs.pddstate.model.pdd.state.Trace;
import com.zjs.pddstate.model.pdd.state.TrackingNumber;
import com.zjs.pddstate.model.zjs.waybill.*;
import com.zjs.pddstate.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.zjs.pddstate.util.Util.objMapper;

/**
 * 状态查询接口
 * @Author: Lic
 * @create: 2020/8/13 11:16
 */
@Slf4j
@Service
public class PddQueryStateService {

    @Autowired
    ZjsWaybillHttp zjsWaybillHttp;

    @Autowired
    Util util;
    /**
     * 状态查询接口
     * @Author: Lic
     * @create: 2020/8/12 14:55
     */
    public PddQueryResponse queryState(String uuid, PddRequest<String> pddRequest){
        PddQueryResponse pddQueryResponse = new PddQueryResponse();
        pddQueryResponse.setShip_id(pddRequest.getShip_id());
        pddQueryResponse.setSuccess(false);
        pddQueryResponse.setReasonCode("9999");
        try {
            List<Trace> list = new ArrayList<>();
            TrackingNumber trackingNumber = objMapper.readValue(pddRequest.getData(),TrackingNumber.class);
            BaseResp baseResp = zjsWaybillHttp.zjsWaybillState(uuid,trackingNumber.getTrackingNumber());
            if(baseResp.getCode()==0){
                pddQueryResponse.setSuccess(true);
                pddQueryResponse.setReasonCode("0");
                if(baseResp.getData()!=null){
                    //开单
                    List<AladinWayBillStatus> aladinWayBillStatusList = baseResp.getData().getAladinWayBillStatus();
                    if (aladinWayBillStatusList.size() > 0) {
                        for (AladinWayBillStatus aladinWayBillStatus: aladinWayBillStatusList) {
                            Trace trace = new Trace();
                            trace.setStatus("GOT");
                            trace.setDescription("["+aladinWayBillStatus.getPickerUserName()+"] 已揽收");
                            if(aladinWayBillStatus.getWoType()==2204){
                                trace.setDescription("拒收,原因:" + aladinWayBillStatus.getVapplremark());
                                trace.setStatus("REJECTION");
                                trace.setFailReason("REJECTION_211");
                            }
                            trace.setTrackingNumber(aladinWayBillStatus.getVwocode());
                            trace.setTrackingOrderNo(aladinWayBillStatus.getVcustcode());
                            trace.setId(uuid);
                            trace.setOperationTime(aladinWayBillStatus.getCreationTime());
                            trace.setTransferFlag(0);
                            trace.setTimeZone("+08:00");
                            trace.setSiteName(aladinWayBillStatus.getUnitName());
                            trace.setSiteType(util.unitType(aladinWayBillStatus.getUnitType()));
                            trace.setSiteNo(aladinWayBillStatus.getUnitCode());
        //                    trace.setNextSiteName(aladinWayBillStatus.getUnitName());
        //                    trace.setNextSiteType(util.unitType(aladinWayBillStatus.getUnitType()));
        //                    trace.setNextSiteNo(aladinWayBillStatus.getUnitName());
                            trace.setCountry("CN");
                            trace.setProvince(aladinWayBillStatus.getProvAreaName());
                            trace.setCity(Parameter.citymap.get(aladinWayBillStatus.getCityAreaName()));
                            trace.setContact(aladinWayBillStatus.getUserName());
                            trace.setContactInfo(aladinWayBillStatus.getUserPhone());
                            list.add(trace);
                        }
                    }
                    //入库
                    List<InStockStatusDto> inStockStatusDtoList = baseResp.getData().getInStockStatusDto();
                    if (inStockStatusDtoList.size() > 0) {
                        for (InStockStatusDto inStockStatusDto : inStockStatusDtoList) {
                            Trace trace = new Trace();
                            trace.setStatus("ARRIVAL");
                            if (inStockStatusDto.getWoType() == 2204) {
                                trace.setStatus("RETURN");
                            }
                            trace.setDescription("到达 [" + inStockStatusDto.getUnitName() + "]");
                            trace.setTrackingNumber(inStockStatusDto.getVwocode());
                            trace.setTrackingOrderNo(inStockStatusDto.getVcustcode());
                            trace.setId(uuid);
                            trace.setOperationTime(inStockStatusDto.getOperatingTime());
                            trace.setTransferFlag(0);
                            trace.setTimeZone("+08:00");
                            trace.setSiteName(inStockStatusDto.getUnitName());
                            trace.setSiteType(util.unitType(inStockStatusDto.getUnitType()));
                            trace.setSiteNo(inStockStatusDto.getUnitCode());
                            //                    trace.setNextSiteName(inStockStatusDto.getUnitName());
                            //                    trace.setNextSiteType(util.unitType(inStockStatusDto.getUnitType()));
                            //                    trace.setNextSiteNo(inStockStatusDto.getUnitName());
                            trace.setCountry("CN");
                            trace.setProvince(inStockStatusDto.getProvAreaName());
                            trace.setCity(Parameter.citymap.get(inStockStatusDto.getCityAreaName()));
                            trace.setContact(inStockStatusDto.getUserName());
                            trace.setContactInfo(inStockStatusDto.getUserPhone());
                            list.add(trace);
                        }
                    }

                    //出库
                    List<OutStockStatusDto> outStockStatusDtoList = baseResp.getData().getOutStockStatusDto();
                    if (outStockStatusDtoList.size() > 0) {
                        for (OutStockStatusDto outStockStatusDto: outStockStatusDtoList) {
                            Trace trace = new Trace();
                            trace.setStatus("DEPARTURE");
                            if(outStockStatusDto.getWoType()==2204){
                                trace.setStatus("RETURN");
                            }
                            trace.setDescription("离开["+outStockStatusDto.getUnitName()+"] 发往 ["+outStockStatusDto.getReceiveUnitName()+"]");
                            trace.setTrackingNumber(outStockStatusDto.getVwocode());
                            trace.setTrackingOrderNo(outStockStatusDto.getVcustcode());
                            trace.setId(uuid);
                            trace.setOperationTime(outStockStatusDto.getOperatingTime());
                            trace.setTransferFlag(0);
                            trace.setTimeZone("+08:00");
                            trace.setSiteName(outStockStatusDto.getUnitName());
                            trace.setSiteType(util.unitType(outStockStatusDto.getUnitType()));
                            trace.setSiteNo(outStockStatusDto.getUnitCode());
                            trace.setNextSiteName(outStockStatusDto.getReceiveUnitName());
                            trace.setNextSiteType(util.unitType(outStockStatusDto.getReceiveUnitType()));
                            trace.setNextSiteNo(outStockStatusDto.getReceiveUnitCode());
                            trace.setCountry("CN");
                            trace.setProvince(outStockStatusDto.getProvAreaName());
                            trace.setCity(Parameter.citymap.get(outStockStatusDto.getCityAreaName()));
                            trace.setContact(outStockStatusDto.getUserName());
                            trace.setContactInfo(outStockStatusDto.getUserPhone());
                            list.add(trace);
                        }
                    }
                    //派送
                    List<DeliveryTopicDto> deliveryTopicDtoList = baseResp.getData().getDeliveryTopicDto();
                    if (deliveryTopicDtoList.size() > 0) {
                        for (DeliveryTopicDto deliveryTopicDto: deliveryTopicDtoList) {
                            Trace trace = new Trace();
                            trace.setStatus("SEND");
                            if(deliveryTopicDto.getWoType()==2204){
                                trace.setStatus("RETURN");
                            }
                            trace.setDescription("离开 ["+deliveryTopicDto.getUnitName()+"] 派送中，递送员["+deliveryTopicDto.getUserName()+"]，电话["+deliveryTopicDto.getUserPhone()+"]");
                            trace.setTrackingNumber(deliveryTopicDto.getVwocode());
                            trace.setTrackingOrderNo(deliveryTopicDto.getVcustcode());
                            trace.setId(uuid);
                            trace.setOperationTime(deliveryTopicDto.getOperationgTime());
                            trace.setTransferFlag(0);
                            trace.setTimeZone("+08:00");
                            trace.setSiteName(deliveryTopicDto.getUnitName());
                            trace.setSiteType(util.unitType(deliveryTopicDto.getUnitType()));
                            trace.setSiteNo(deliveryTopicDto.getUnitCode());
                            //                    trace.setNextSiteName(deliveryTopicDto.getReceiveUnitName());
                            //                    trace.setNextSiteType(util.unitType(deliveryTopicDto.getReceiveUnitType()));
                            //                    trace.setNextSiteNo(deliveryTopicDto.getReceiveUnitCode());
                            trace.setCountry("CN");
                            trace.setProvince(deliveryTopicDto.getProvAreaName());
                            trace.setCity(Parameter.citymap.get(deliveryTopicDto.getCityAreaName()));
                            trace.setContact(deliveryTopicDto.getUserName());
                            trace.setContactInfo(deliveryTopicDto.getUserPhone());
                            list.add(trace);
                        }
                        
                    }
                    //签收 拒收
                    List<SignFilterTagDto> signFilterTagDtoList = baseResp.getData().getSignFilterTagDto();
                    if (signFilterTagDtoList.size() > 0) {
                        for (SignFilterTagDto signFilterTagDto: signFilterTagDtoList) {
                            Trace trace = new Trace();
                            trace.setStatus("SIGN");
                            trace.setDescription("客户已签收 签收人："+signFilterTagDto.getSigner());
                            if(signFilterTagDto.getWoType()==2204){
                                trace.setStatus("RETURN");
                                trace.setDescription("返货已签收 签收人："+signFilterTagDto.getSigner());
                            }
                            trace.setSignerName(signFilterTagDto.getSigner());
                            trace.setTrackingNumber(signFilterTagDto.getVwocode());
                            trace.setTrackingOrderNo(signFilterTagDto.getVcustcode());
                            trace.setId(uuid);
                            trace.setOperationTime(signFilterTagDto.getTsigntime());
                            trace.setTransferFlag(0);
                            trace.setTimeZone("+08:00");
                            trace.setSiteName(signFilterTagDto.getUnitName());
                            trace.setSiteType(util.unitType(signFilterTagDto.getUnitType()));
                            trace.setSiteNo(signFilterTagDto.getUnitCode());
                            //                    trace.setNextSiteName(deliveryTopicDto.getReceiveUnitName());
                            //                    trace.setNextSiteType(util.unitType(deliveryTopicDto.getReceiveUnitType()));
                            //                    trace.setNextSiteNo(deliveryTopicDto.getReceiveUnitCode());
                            trace.setCountry("CN");
                            trace.setProvince(signFilterTagDto.getProvAreaName());
                            trace.setCity(Parameter.citymap.get(signFilterTagDto.getCityAreaName()));
                            trace.setContact(signFilterTagDto.getUserName());
                            trace.setContactInfo(signFilterTagDto.getUserPhone());
                            list.add(trace);
                        }
                        
                        }
                    //转件
                    List<TransferStatusDto> transferStatusDtoList = baseResp.getData().getTransferStatusDto();
                    if (transferStatusDtoList.size() > 0) {
                        for (TransferStatusDto transferStatusDto: transferStatusDtoList) {
                            Trace trace = new Trace();
                            trace.setStatus("OTHER");
                            if(transferStatusDto.getWoType()==2204){
                                trace.setStatus("RETURN");
                            }
                            trace.setDescription("已转件");
                            trace.setTransferNo(transferStatusDto.getChangeWbcode());
                            trace.setTransferPartnerId(util.transferPartnerId(transferStatusDto.getResourceDetailName()));

                            trace.setTrackingNumber(transferStatusDto.getVwocode());
                            trace.setTrackingOrderNo(transferStatusDto.getVcustcode());
                            trace.setId(uuid);
                            trace.setOperationTime(transferStatusDto.getOperatingTime());
                            trace.setTransferFlag(1);
                            trace.setTimeZone("+08:00");
                            trace.setSiteName(transferStatusDto.getUnitName());
                            trace.setSiteType(util.unitType(transferStatusDto.getUnitType()));
                            trace.setSiteNo(transferStatusDto.getUnitCode());
                            //                    trace.setNextSiteName(deliveryTopicDto.getReceiveUnitName());
                            //                    trace.setNextSiteType(util.unitType(deliveryTopicDto.getReceiveUnitType()));
                            //                    trace.setNextSiteNo(deliveryTopicDto.getReceiveUnitCode());
                            trace.setCountry("CN");
                            trace.setProvince(transferStatusDto.getProvAreaName());
                            trace.setCity(Parameter.citymap.get(transferStatusDto.getCityAreaName()));
                            trace.setContact(transferStatusDto.getUserName());
                            trace.setContactInfo(transferStatusDto.getUserPhone());
                            list.add(trace);
                        }
                    }
                    //按照时间排序
                    Collections.sort(list);
                    pddQueryResponse.setData(list);
                }
            }
            else if(baseResp.getCode() == -1){
                if(!trackingNumber.getTrackingNumber().contains("ZJS")){
                    pddQueryResponse.setReasonCode("1230");
                }
            }
        } catch (Exception e) {
            pddQueryResponse.setReasonCode("9990");
            log.error(uuid+" 数据异常",e);
        }
        return pddQueryResponse;
    }
}
