package com.zjs.pddstate.model.zjs.waybill;

import com.zjs.pddstate.util.DateHandleUtil;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * @program: jd
 * @description: 入库
 * @author: Lillie
 * @create: 2018-07-13 10:27
 **/
@Component
public class InStockStatusDto implements Serializable {

    //=======================数据来源 ：阿波罗=========================
    /**
     * 运单号
     */
    private String vwocode;

    /**
     * 操作时间
     */
    private String creationTime;

    /**
     * 主键id
     */

    private String id;

    private String pkInstockId;

    /**
     * 任务码
     */
    private String taskCode;

    /**
     * 批次号
     */
    private String batchCode;

    /**
     * 入库类型
     */
    private String inType;

    /**
     * 工作单号
     */
    private String waybillCode;

    /**
     * 条码号/客户单号
     */
    private String barcode;

    /**
     * 冗余保存 条码号
     */
    private String vbarcode;

    /**
     * 合包号
     */
    private String mergerPackageCode;

    /**
     * 包裹类型
     */
    private String packageType;

    /**
     * 操作时间
     */
    private String operatingTime;

    /**
     * 创建单位
     */
    private String createSiteCode;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改人名称
     */
    private String userName;

    /**
     * 修改人电话
     */
    private String userPhone;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 是否删除
     */
    private String yn;

    /**
     * 任务上传成功时间
     */
    private String PDAUploadTime;

    //=================数据来源：通用接口-单位信息===================
    /**
     * 当前站点省
     */
    private String provAreaName;
    /**
     * 当前站点市
     */
    private String cityAreaName;
    /**
     * 当前站点县
     */
    private String countryAreaName;
    /**
     * 当前站点主键
     */
    private String unitRangePk;
    /**
     * 当前站点编号
     */
    private String pkUnit;
    /**
     * 当前站点类型
     */
    private String unitType;
    /**
     * 当前站名称
     */
    private String unitName;
    /**
     * 当前站点编码
     */
    private String unitCode;
    /**
     * 当前站点电话1
     */
    private String phone1;
    /**
     * 当前站点电话2
     */
    private String phone2;

    //=================数据来源：运单====================

    /**
     * 数据生产时间
     */
    private String aladinTs;

    /**
     * 发送状态
     */
    private Integer aladinIsSend;

    /**
     * 发送时间
     */
    private String aladinSendTime;

    /**
     * 状态类型
     */
    private String aladinStatusType;

    private String aladinStatusTypeID;

    /**
     * 状态序列
     */
    private Integer aladinStatusSort;

    /**
     * 数据来源
     */
    private String aladinDataSource;

    /**
     * 删除标识
     */
    private Integer aladinDr;

    /**
     * 删除说明
     */
    private String aladinDrDesc;

    //===============数据来源 ：工作单信息==================

    /**
     * 客户单号
     */
    private String vcustcode;

    /**
     * 客户编码
     */
    private String customerCode;

    /**
     * 寄件客户编码（已作废，冗余推送，以后删除）2017-07-19
     */
    private String sendCustCode;

    /**
     * 业务通知单号
     */
    private String busiNoticeCode;

    /**
     * 工作单类型
     */
    private Integer woType;

    /**
     * 发件省
     */
    private String provinceSend;

    /**
     * 收件省
     */
    private String provinceRecv;

    /**
     * 运单开单时间,工作单信息的creationTime字段
     */
    private String waybillCreationTime;

    /**
     * 开单单位主键
     */
    private String pkCorpoper;
    /**
     * 开单单位名称
     */
    private String corpoperName;
    /**
     * 到达地
     */
    private String arrival;
    /* 2018-2-9新增 */
    /**
     * 送达时限
     */
    private String arrvLimmit;

    /**
     * 去重
     *
     * @param inStockStatusDtos
     * @return
     */
    public ArrayList<InStockStatusDto> removeDuplicateInStockStatusDto(List<InStockStatusDto> inStockStatusDtos) {
        Set<InStockStatusDto> set = new TreeSet<>(new Comparator<InStockStatusDto>() {
            @Override
            public int compare(InStockStatusDto i1, InStockStatusDto i2) {
                //字符串,则按照asicc码升序排列
                return i1.getBatchCode().compareTo(i2.getBatchCode());
            }
        });
        set.addAll(inStockStatusDtos);
        return new ArrayList<>(set);
    }

    /**
     * 按时间排序
     * @param inStockStatusDtos
     * @return
     */
    public  ArrayList<InStockStatusDto> listSort(List<InStockStatusDto> inStockStatusDtos) {
        List<InStockStatusDto> inStockStatusDtoList = new ArrayList<InStockStatusDto>();
        Collections.sort(inStockStatusDtos, new Comparator<InStockStatusDto>() {
            @Override
            public int compare(InStockStatusDto i1, InStockStatusDto i2) {
                return i1.getCreationTime().compareTo(i2.getCreationTime());
            }
        });
        inStockStatusDtoList.addAll(inStockStatusDtos);
        return new ArrayList<InStockStatusDto>(inStockStatusDtoList);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((batchCode == null) ? 0 : batchCode.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        InStockStatusDto other = (InStockStatusDto) obj;
        if (batchCode == null) {
            if (other.batchCode != null){
                return false;
            }
        } else if (!batchCode.equals(other.batchCode)){
            return false;
        }
        return true;
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

    /**
     * 产品时限
     */
    private BigDecimal prodtimelimit;

    public String getVwocode() {
        return vwocode;
    }

    public void setVwocode(String vwocode) {
        this.vwocode = vwocode;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime == null ? null : DateHandleUtil.getDateStr(creationTime);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getInType() {
        return inType;
    }

    public void setInType(String inType) {
        this.inType = inType;
    }

    public String getWaybillCode() {
        return waybillCode;
    }

    public void setWaybillCode(String waybillCode) {
        this.waybillCode = waybillCode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getMergerPackageCode() {
        return mergerPackageCode;
    }

    public void setMergerPackageCode(String mergerPackageCode) {
        this.mergerPackageCode = mergerPackageCode;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(String operatingTime) {
        this.operatingTime = operatingTime;
    }

    public String getCreateSiteCode() {
        return createSiteCode;
    }

    public void setCreateSiteCode(String createSiteCode) {
        this.createSiteCode = createSiteCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getYn() {
        return yn;
    }

    public void setYn(String yn) {
        this.yn = yn;
    }

    public String getPDAUploadTime() {
        return PDAUploadTime;
    }

    public void setPDAUploadTime(String pDAUploadTime) {
        PDAUploadTime = pDAUploadTime;
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getAladinTs() {
        return aladinTs;
    }

    public void setAladinTs(Date aladinTs) {
        this.aladinTs = aladinTs == null ? null : DateHandleUtil.getDateStr(aladinTs);
    }

    public Integer getAladinIsSend() {
        return aladinIsSend;
    }

    public void setAladinIsSend(Integer aladinIsSend) {
        this.aladinIsSend = aladinIsSend;
    }

    public String getAladinSendTime() {
        return aladinSendTime;
    }

    public void setAladinSendTime(Date aladinSendTime) {
        this.aladinSendTime = aladinSendTime == null ? null : DateHandleUtil.getDateStr(aladinSendTime);
    }

    public String getAladinStatusType() {
        return aladinStatusType;
    }

    public void setAladinStatusType(String aladinStatusType) {
        this.aladinStatusType = aladinStatusType;
    }

    public String getAladinStatusTypeID() {
        return aladinStatusTypeID;
    }

    public void setAladinStatusTypeID(String aladinStatusTypeID) {
        this.aladinStatusTypeID = aladinStatusTypeID;
    }

    public Integer getAladinStatusSort() {
        return aladinStatusSort;
    }

    public void setAladinStatusSort(Integer aladinStatusSort) {
        this.aladinStatusSort = aladinStatusSort;
    }

    public String getAladinDataSource() {
        return aladinDataSource;
    }

    public void setAladinDataSource(String aladinDataSource) {
        this.aladinDataSource = aladinDataSource;
    }

    public Integer getAladinDr() {
        return aladinDr;
    }

    public void setAladinDr(Integer aladinDr) {
        this.aladinDr = aladinDr;
    }

    public String getAladinDrDesc() {
        return aladinDrDesc;
    }

    public void setAladinDrDesc(String aladinDrDesc) {
        this.aladinDrDesc = aladinDrDesc;
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

    public String getPkInstockId() {
        return pkInstockId;
    }

    public void setPkInstockId(String pkInstockId) {
        this.pkInstockId = pkInstockId;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public void setAladinTs(String aladinTs) {
        this.aladinTs = aladinTs;
    }

    public void setWaybillCreationTime(String waybillCreationTime) {
        this.waybillCreationTime = waybillCreationTime;
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

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
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

    public String getPkCorpoper() {
        return pkCorpoper;
    }

    public void setPkCorpoper(String pkCorpoper) {
        this.pkCorpoper = pkCorpoper;
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

    public void setAladinSendTime(String aladinSendTime) {
        this.aladinSendTime = aladinSendTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("InStockStatusDto [vwocode=");
        builder.append(vwocode);
        builder.append(", creationTime=");
        builder.append(creationTime);
        builder.append(", id=");
        builder.append(id);
        builder.append(", pkInstockId=");
        builder.append(pkInstockId);
        builder.append(", taskCode=");
        builder.append(taskCode);
        builder.append(", batchCode=");
        builder.append(batchCode);
        builder.append(", inType=");
        builder.append(inType);
        builder.append(", waybillCode=");
        builder.append(waybillCode);
        builder.append(", barcode=");
        builder.append(barcode);
        builder.append(", vbarcode=");
        builder.append(vbarcode);
        builder.append(", mergerPackageCode=");
        builder.append(mergerPackageCode);
        builder.append(", packageType=");
        builder.append(packageType);
        builder.append(", operatingTime=");
        builder.append(operatingTime);
        builder.append(", createSiteCode=");
        builder.append(createSiteCode);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", updateUser=");
        builder.append(updateUser);
        builder.append(", userName=");
        builder.append(userName);
        builder.append(", userPhone=");
        builder.append(userPhone);
        builder.append(", updateTime=");
        builder.append(updateTime);
        builder.append(", yn=");
        builder.append(yn);
        builder.append(", PDAUploadTime=");
        builder.append(PDAUploadTime);
        builder.append(", provAreaName=");
        builder.append(provAreaName);
        builder.append(", cityAreaName=");
        builder.append(cityAreaName);
        builder.append(", countryAreaName=");
        builder.append(countryAreaName);
        builder.append(", unitRangePk=");
        builder.append(unitRangePk);
        builder.append(", pkUnit=");
        builder.append(pkUnit);
        builder.append(", unitType=");
        builder.append(unitType);
        builder.append(", unitName=");
        builder.append(unitName);
        builder.append(", unitCode=");
        builder.append(unitCode);
        builder.append(", phone1=");
        builder.append(phone1);
        builder.append(", phone2=");
        builder.append(phone2);
        builder.append(", aladinTs=");
        builder.append(aladinTs);
        builder.append(", aladinIsSend=");
        builder.append(aladinIsSend);
        builder.append(", aladinSendTime=");
        builder.append(aladinSendTime);
        builder.append(", aladinStatusType=");
        builder.append(aladinStatusType);
        builder.append(", aladinStatusTypeID=");
        builder.append(aladinStatusTypeID);
        builder.append(", aladinStatusSort=");
        builder.append(aladinStatusSort);
        builder.append(", aladinDataSource=");
        builder.append(aladinDataSource);
        builder.append(", aladinDr=");
        builder.append(aladinDr);
        builder.append(", aladinDrDesc=");
        builder.append(aladinDrDesc);
        builder.append(", vcustcode=");
        builder.append(vcustcode);
        builder.append(", customerCode=");
        builder.append(customerCode);
        builder.append(", sendCustCode=");
        builder.append(sendCustCode);
        builder.append(", busiNoticeCode=");
        builder.append(busiNoticeCode);
        builder.append(", woType=");
        builder.append(woType);
        builder.append(", provinceSend=");
        builder.append(provinceSend);
        builder.append(", provinceRecv=");
        builder.append(provinceRecv);
        builder.append(", waybillCreationTime=");
        builder.append(waybillCreationTime);
        builder.append(", pkCorpoper=");
        builder.append(pkCorpoper);
        builder.append(", corpoperName=");
        builder.append(corpoperName);
        builder.append(", arrival=");
        builder.append(arrival);
        builder.append("]");
        return builder.toString();
    }

    public String getVbarcode() {
        return vbarcode;
    }

    public void setVbarcode(String vbarcode) {
        this.vbarcode = vbarcode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

}
