package com.zjs.pddstate.model.zjs.waybill;


import java.util.List;

/**
 * @program: jd
 * @description:
 * @author: Lillie
 * @create: 2018-07-12 08:43
 **/
@lombok.Data
public class Data {
    /**
     * 开单实体类
     */
    private List<AladinWayBillStatus> aladinWayBillStatus;
    /**
     * 作废实体类不做
     */
    //private List<CancelTopicDto> cancelTagDto;
    /**
     * 派送实体类
     */
    private List<DeliveryTopicDto> deliveryTopicDto;
    /**
     * 异常实体类不做
     */
    //private List<ExcpInfoTopicDto> excpInfoTopicDto;
    /**
     * 入库实体类
     */
    private List<InStockStatusDto> inStockStatusDto;
    /**
     *出库实体类
     */
    private List<OutStockStatusDto> outStockStatusDto;
    /**
     * 签收实体类 类别
     */
    private List<SignFilterTagDto> signFilterTagDto;

    /**
     * 转件实体类 类别
     */
    private List<TransferStatusDto> transferStatusDto;

}
