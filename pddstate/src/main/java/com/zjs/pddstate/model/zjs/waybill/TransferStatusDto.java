package com.zjs.pddstate.model.zjs.waybill;

import com.zjs.pddstate.util.DateHandleUtil;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 转件开单实体
 * @Author: Lic
 * @create: 2020/8/13 17:01
 */
public class TransferStatusDto {


    private String id;

    /** 运单主键 */
    private String pkWo;

    /** 运单号 */
    private String vwocode;

    /** 最后修改的时间 */
    private String ts;

    /** 创建时间 */
    private String creationTime;


    /** 操作时间 */
    private String operatingTime;

    /** 数据状态/操作类型 */
    private String operType;

    /** 操作人工号 */
    private String userCode;

    /** 操作人名称 */
    private String userName;

    /** 操作人电话*/
    private String userPhone;

    //================转件信息===================
    /** 转件资源代码*/
    private String resourceCode;
    /** 转件资源名称*/
    private String resourceDetailName;
    /** 转件资源单号*/
    private String changeWbcode;
    /** 物流信息来源*/
    private String resourceFrom;
    /** 转件类型名称*/
    private String wbchangeTypeName;
    /** 转件资源类型名称*/
    private String resourceTypeName;
    //================转件信息===================


    //================当前站点信息===================
    /** 当前站点省*/
    private String provAreaName;

    /** 当前站点市*/
    private String cityAreaName;

    /** 当前站点县*/
    private String countryAreaName;

    /** 当前站点主键*/
    private String unitRangePk;

    /** 当前站点编号*/
    private String pkUnit;

    /** 当前站点类型*/
    private String unitType;

    /** 当前站点名称*/
    private String unitName;

    /** 当前站点电话1*/
    private String phone1;

    /** 当前站点电话1*/
    private String phone2;



    // ===============数据来源 ：工作单信息==================

    /** 客户单号 */
    private String vcustcode;

    /** 客户编码 */
    private String customerCode;

    /** 寄件客户编码（已作废，冗余推送，以后删除）2017-07-19 */
    private String sendCustCode;

    /** 业务通知单号 */
    private String busiNoticeCode;

    /** 工作单类型 */
    private Integer woType;

    /** 发件省 */
    private String provinceSend;

    /** 收件省 */
    private String provinceRecv;


    /** 运单开单时间 */
    private String waybillCreationTime;

    /** 开单单位名称 */
    private String corpoperName;

    /** 到达地 */
    private String arrival;
    /* 2018-2-9新增 */
    /** 送达时限 */
    private String arrvLimmit;
    /** 站点编码 */
    private String unitCode;


    /**
     * 接收单位编码
     */
    private String receiveUnitCode;

    public String getReceiveUnitCode() {
        return receiveUnitCode;
    }

    public void setReceiveUnitCode(String receiveUnitCode) {
        this.receiveUnitCode = receiveUnitCode;
    }


    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getArrvLimmit() {
        return arrvLimmit;
    }


    public void setArrvLimmit(String arrvLimmit) {
        this.arrvLimmit = arrvLimmit;
    }


    public BigDecimal getProdtimelimit() {
        return prodtimelimit;
    }


    public void setProdtimelimit(BigDecimal prodtimelimit) {
        this.prodtimelimit = prodtimelimit;
    }


    /** 产品时限 */
    private BigDecimal prodtimelimit;

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getPkWo() {
        return pkWo;
    }


    public void setPkWo(String pkWo) {
        this.pkWo = pkWo;
    }


    public String getVwocode() {
        return vwocode;
    }


    public void setVwocode(String vwocode) {
        this.vwocode = vwocode;
    }


    public String getTs() {
        return ts;
    }


    public void setTs(Date ts) {
        this.ts = ts == null ? null : DateHandleUtil.getDateStr(ts);
    }


    public String getCreationTime() {
        return creationTime;
    }


    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime == null ? null : DateHandleUtil.getDateStr(creationTime);
    }

    public String getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(String operatingTime) {
        this.operatingTime = operatingTime;
    }

    public String getOperType() {
        return operType;
    }


    public void setOperType(String operType) {
        this.operType = operType;
    }


    public String getUserCode() {
        return userCode;
    }


    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserPhone() {
        return userPhone;
    }


    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }


    public String getProvAreaName() {
        return provAreaName;
    }


    public void setProvAreaName(String provAreaName) {
        this.provAreaName = provAreaName;
    }


    public String getCityAreaName() {
        return cityAreaName;
    }


    public void setCityAreaName(String cityAreaName) {
        this.cityAreaName = cityAreaName;
    }


    public String getCountryAreaName() {
        return countryAreaName;
    }


    public void setCountryAreaName(String countryAreaName) {
        this.countryAreaName = countryAreaName;
    }


    public String getUnitRangePk() {
        return unitRangePk;
    }


    public void setUnitRangePk(String unitRangePk) {
        this.unitRangePk = unitRangePk;
    }


    public String getPkUnit() {
        return pkUnit;
    }


    public void setPkUnit(String pkUnit) {
        this.pkUnit = pkUnit;
    }


    public String getUnitType() {
        return unitType;
    }


    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }


    public String getUnitName() {
        return unitName;
    }


    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }


    public String getPhone1() {
        return phone1;
    }


    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }


    public String getPhone2() {
        return phone2;
    }


    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }


    public String getVcustcode() {
        return vcustcode;
    }


    public void setVcustcode(String vcustcode) {
        this.vcustcode = vcustcode;
    }


    public String getSendCustCode() {
        return sendCustCode;
    }


    public void setSendCustCode(String sendCustCode) {
        this.sendCustCode = sendCustCode;
    }


    public String getBusiNoticeCode() {
        return busiNoticeCode;
    }


    public void setBusiNoticeCode(String busiNoticeCode) {
        this.busiNoticeCode = busiNoticeCode;
    }


    public Integer getWoType() {
        return woType;
    }

    public void setWoType(Integer woType) {
        this.woType = woType;
    }


    public String getProvinceSend() {
        return provinceSend;
    }


    public void setProvinceSend(String provinceSend) {
        this.provinceSend = provinceSend;
    }


    public String getProvinceRecv() {
        return provinceRecv;
    }


    public void setProvinceRecv(String provinceRecv) {
        this.provinceRecv = provinceRecv;
    }


    public String getWaybillCreationTime() {
        return waybillCreationTime;
    }


    public void setWaybillCreationTime(Date waybillCreationTime) {
        this.waybillCreationTime = waybillCreationTime == null ? null : DateHandleUtil.getDateStr(waybillCreationTime);
    }

    public void setTs(String ts) {
        this.ts = ts;
    }


    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getCustomerCode() {
        return customerCode;
    }


    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }


    public String getCorpoperName() {
        return corpoperName;
    }


    public void setCorpoperName(String corpoperName) {
        this.corpoperName = corpoperName;
    }


    public String getArrival() {
        return arrival;
    }


    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceDetailName() {
        return resourceDetailName;
    }

    public void setResourceDetailName(String resourceDetailName) {
        this.resourceDetailName = resourceDetailName;
    }

    public String getChangeWbcode() {
        return changeWbcode;
    }

    public void setChangeWbcode(String changeWbcode) {
        this.changeWbcode = changeWbcode;
    }

    public String getResourceFrom() {
        return resourceFrom;
    }

    public void setResourceFrom(String resourceFrom) {
        this.resourceFrom = resourceFrom;
    }

    public String getWbchangeTypeName() {
        return wbchangeTypeName;
    }

    public void setWbchangeTypeName(String wbchangeTypeName) {
        this.wbchangeTypeName = wbchangeTypeName;
    }

    public String getResourceTypeName() {
        return resourceTypeName;
    }

    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    @Override
    public String toString() {
        return "TransferStatusDto{" +
                "id='" + id + '\'' +
                ", pkWo='" + pkWo + '\'' +
                ", vwocode='" + vwocode + '\'' +
                ", ts='" + ts + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", operatingTime='" + operatingTime + '\'' +
                ", operType='" + operType + '\'' +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", resourceCode='" + resourceCode + '\'' +
                ", resourceDetailName='" + resourceDetailName + '\'' +
                ", changeWbcode='" + changeWbcode + '\'' +
                ", resourceFrom='" + resourceFrom + '\'' +
                ", wbchangeTypeName='" + wbchangeTypeName + '\'' +
                ", resourceTypeName='" + resourceTypeName + '\'' +
                ", provAreaName='" + provAreaName + '\'' +
                ", cityAreaName='" + cityAreaName + '\'' +
                ", countryAreaName='" + countryAreaName + '\'' +
                ", unitRangePk='" + unitRangePk + '\'' +
                ", pkUnit='" + pkUnit + '\'' +
                ", unitType='" + unitType + '\'' +
                ", unitName='" + unitName + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", vcustcode='" + vcustcode + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", sendCustCode='" + sendCustCode + '\'' +
                ", busiNoticeCode='" + busiNoticeCode + '\'' +
                ", woType=" + woType +
                ", provinceSend='" + provinceSend + '\'' +
                ", provinceRecv='" + provinceRecv + '\'' +
                ", waybillCreationTime='" + waybillCreationTime + '\'' +
                ", corpoperName='" + corpoperName + '\'' +
                ", arrival='" + arrival + '\'' +
                ", arrvLimmit='" + arrvLimmit + '\'' +
                ", unitCode='" + unitCode + '\'' +
                ", receiveUnitCode='" + receiveUnitCode + '\'' +
                ", prodtimelimit=" + prodtimelimit +
                '}';
    }
}
