package com.zjs.pddstate.model.pdd.state;

import lombok.Data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 状态回传实体
 * @Author: Lic
 * @create: 2020/8/12 15:21
 */
@Data
public class Trace implements Comparable<Trace>{

    /**
     * 运单号
     */
    private String trackingNumber;
    /**
     * 客户单号
     */
    private String trackingOrderNo;
    /**
     * uuid
     */
    private String id;

//    物流状态	            描述          备注	            对应宅急送字段
//    GOT	                揽件		                        揽收
//    SEND	            派件			                    派件
//    SIGN	            签收		                        签收
//    ARRIVAL	            到件		                        入库
//    DEPARTURE	        发件		                        出库
//    FAIL	            问题件	有二级状态，详见二级状态对照表	无
//    REJECTION	        拒签	    有二级状态，详见二级状态对照表	拒收
//    STAY_IN_WAREHOUSE   留仓		                                   无
//    SIGN_ON_BEHALF	    代收点代签	有二级状态，详见二级状态对照表	无
//    OTHER	            其他		                                        无
//    RETURN	            退件		返货入库、返货出库、返货派件、返货签收
//    IN_CABINET	        入柜/入代收点	有二级状态，详见二级状态对照表	无
//    OUT_CABINET	        出柜/出代收点	有二级状态，详见二级状态对照表	无
//    CLEARANCE_START	    清关开始		                                    无
//    CLEARANCE_FINISH	清关结束	有二级状态，详见二级状态对照表	        无

    /**
     * 对照表
     */
    private String status;
    /**
     * 轨迹详情描述
     * 如：上海青浦区白鹤镇公司 已收件
     */
    private String description;
    /**
     * 格式：yyyy-MM-dd HH:mm:ss
     */
    private String operationTime;
    /**
     * 是否转单
     * 0：否；1：是 
     */
    private Integer transferFlag;
    /**
     * 转单单号
     * 条件必填
     * transferFlag=1 必填
     */
    private String transferNo;
    /**
     * 转单快递公司ID
     * 根据公司名称匹配
     * transferFlag=1 必填,转单快递公司对照表详见附录3.2，映射不到的编码使用：180
     */
    private String transferPartnerId;
    /**
     * 时区
     * 默认：+08:00
     */
    private String timeZone;
    /**
     * 扫描站点名称
     * status字段值为IN_CABINET，OUT_CABINET、SIGN_ON_BEHALF时siteName为自提点名称或自提柜名。
     自提点名称示例：
     南丰城1楼105室XX驿站；
     自提柜名称示例：
     大金更小区北门1号丰巢智能柜。
     */
    private String siteName;
    /**
     * 1:网点；2:中转中心
     */
    private Integer siteType;
    /**
     * 扫描站点编码
     * 站点编码
     */
    private String siteNo;
    /**
     * 下一站点名称
     * 条件必填
     * status字段值为ARRIVAL、DEPARTURE状态时必填
     */
    private String nextSiteName;
    /**
     * 下一站类型
     * 1:网点,2:中转中心/分拨中心
     */
    private Integer nextSiteType;
    /**
     * 下一站点编号
     * 下一站点编码
     * 条件必填
     * status字段值为ARRIVAL、DEPARTURE状态时必填
     */
    private String nextSiteNo;
    /**
     * 问题原因code
     * 轨迹状态status为：FAIL, REJECTION, IN_CABINET,OUT_CABINET ,SIGN_ON_BEHALF, CLEARANCE_FINISH的时候必填，详见3.2的二级状态对照表编码
     * 仅拒签 有值，见对照表
     */
    private String failReason;

    /**
     * 单位：克(g)
     */
    private Double weight;
    /**
     * 默认值：CN
     */
    private String country;
    /**
     * 省份名称
     * 当前站点省
     */
    private String province;
    /**
     * 扫描城市编码
     * 根据当前站点城市（获取）
     * 编码可从2.4接口获取并缓存下来
     */
    private String city;
    /**
     * 三级地址，区/县
     * 空
     */
    private String district;
    /**
     * 操作人员名称
     *1.status为SEND、IN_CABINET、OUT_CABINET（二级状态failReason为OUT_CABINET_502、OUT_CABINET_503）、SIGN_ON_BEHALF状态必填， 为操作员名称；
     2.其他状态选填
     */
    private String contact;
    /**
     * 1. status为SEND、OUT_CABINET（二级状态failReason为OUT_CABINET_502、OUT_CABINET_503）状态必填， 为操作员手机号；
     2. status为 IN_CABINET、OUT_CABINET（二级状态failReason为OUT_CABINET_501）状态必填，为代收点电话；
     3. status为SIGN_ON_BEHALF时，必填，若有代收点电话传代收点电话，若无则传操作员手机号
     4. 其他状态选填
     */
    private String contactInfo;
    /**
     * 签收人姓名
     */
    private String signerName;
    /**
     * 代收点地址
     * SIGN、SIGN_ON_BEHALF状态必填，如：本人签收、XXX代收点
     */
    private String address;
    /**
     * 备注信息
     */
    private String remark;

    /**
     *  Collections.sort(list); 根据时间排序
     * @Author: Lic
     * @create: 2019/5/23 14:47
     */
    @Override
    public int compareTo(Trace trace) {           //重写Comparable接口的compareTo方法，
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int aa = 0;
        try {
            aa = Integer.parseInt(String.valueOf(df.parse(this.operationTime).getTime() - df.parse(trace.getOperationTime()).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return aa;    // 根据时间降序排列，升序修改相减顺序即可
    }
}

