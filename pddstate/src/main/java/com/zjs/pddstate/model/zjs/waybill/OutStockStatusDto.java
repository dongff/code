package com.zjs.pddstate.model.zjs.waybill;

import com.zjs.pddstate.util.DateHandleUtil;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * @program: jd
 * @description: 出库
 * @author: Lillie
 * @create: 2018-07-13 10:27
 **/
@Component
public class OutStockStatusDto implements Serializable{
	// =======================数据来源 ：阿波罗=========================
	/** 运单号 */
	private String vwocode;

	/** 操作时间 */
	private String creationTime;

	/** 主键id */

	private String id;
	
	private String pkOutstockId;

	/** 任务码 */
	private String taskCode;

	/** 批次号 */
	private String batchCode;

	/** 线路码 */
	private String lineCode;

	/** 接收单位 */
	private String receiveSiteCode;

	/** 出库类型 */
	private String outType;

	/** 运单号 */
	private String waybillCode;

	/** 条码号 */
	private String barCode;

	/** 冗余保存 条码号*/
	private String vbarcode;
	
	/** 包裹类型 */
	private String packageType;

	/** 合包号 */
	private String mpackagecode;

	/** 备货码 */
	private String pregoodsCode;

	/** 操作时间 */
	private String operatingTime;

	/** 创建单位 */
	private String createSiteCode;

	/** 创建人 */
	private String createUser;

	/** 创建时间 */
	private String createTime;

	/** 修改人 */
	private String updateUser;

	/** 修改时间 */
	private String updateTime;

	/** 修改人名称*/
	private String userName;

	/** 修改人电话*/
	private String userPhone;

	/** 是否删除 */
	private String yn;

	/** 任务上传成功时间 */
	private String padUploadTime;

	/** （确认出库状态）出库状态 */
	private String outStatus;

	// =================数据来源：通用接口-单位信息===================
	/** 当前站点省 */
	private String provAreaName;

	/** 当前站点市 */
	private String cityAreaName;

	/** 当前站点县 */
	private String countryAreaName;

	/** 当前站点主键 */
	private String unitRangePk;

	/** 当前站点编号 */
	private String pkUnit;

	/** 当前站点类型*/
	private String unitType;

	/** 当前站名称*/
	private String unitName;
	/** 当前站点电话1*/
	private String phone1;
	/** 当前站点电话2*/
	private String phone2;

	// =================下一站点信息================
	/** 下一站点省 */
	private String receiveProvAreaName;

	/** 下一站点市 */
	private String receiveCityAreaName;

	/** 下一站点县 */
	private String receiveCountryAreaName;

	/** 下一站点主键 */
	private String receiveUnitRangePk;

	/** 下一站点编号 */
	private String receivePkUnit;

	/** 下一站点名称 */
	private String receiveUnitName;
	/** 下一点类型*/
	private String receiveUnitType;
	/** 下一站点电话1*/
	private String receivePhone1;
	/** 下一站点电话2*/
	private String receivePhone2;

	// =================数据来源：运单====================

	/** 数据生产时间 */
	private String aladinTs;

	/** 发送状态 */
	private Integer aladinIsSend;

	/** 发送时间 */
	private String aladinSendTime;

	/** 状态类型 */
	private String aladinStatusType;
	
	private String aladinStatusTypeID;

	/** 状态序列 */
	private Integer aladinStatusSort;

	/** 数据来源 */
	private String aladinDataSource;

	/** 删除标识 */
	private Integer aladinDr;

	/** 删除说明 */
	private String aladinDrDesc;
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
	/** 开单单位主键*/
	private String pkCorpoper;
	/** 开单单位名称*/
	private String corpoperName;
	/** 到达地*/
	private String arrival;
	/* 2018-2-9新增 */
	/** 送达时限 */
	private String arrvLimmit;
	/** 产品时限 */
	private BigDecimal prodtimelimit;
	/**
	 * 当前站点编码
	 */
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

	/**
	 * 批次号去重
	 * @param outStockStatusDtos
	 * @return
	 */
	public ArrayList<OutStockStatusDto> removeDuplicateOutStockStatusDto(List<OutStockStatusDto> outStockStatusDtos) {
		Set<OutStockStatusDto> set = new TreeSet<>(new Comparator<OutStockStatusDto>() {
			@Override
			public int compare(OutStockStatusDto o1, OutStockStatusDto o2) {
				//字符串,则按照asicc码升序排列
				return o1.getBatchCode().compareTo(o2.getBatchCode());
			}
		});
		set.addAll(outStockStatusDtos);
		return new ArrayList<>(set);
	}

	/**
	 * 按时间排序
	 * @param outStockStatusDtos
	 * @return
	 */
	public ArrayList<OutStockStatusDto> listSort(List<OutStockStatusDto> outStockStatusDtos) {
		List<OutStockStatusDto> outStockStatusDtoList = new ArrayList<OutStockStatusDto>();
		Collections.sort(outStockStatusDtos, new Comparator<OutStockStatusDto>() {
			@Override
			public int compare(OutStockStatusDto i1, OutStockStatusDto i2) {
				return i1.getCreationTime().compareTo(i2.getCreationTime());
			}
		});
		outStockStatusDtoList.addAll(outStockStatusDtos);
		return new ArrayList<OutStockStatusDto>(outStockStatusDtoList);
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
		OutStockStatusDto other = (OutStockStatusDto) obj;
		if (batchCode == null) {
			if (other.batchCode != null){
				return false;
			}
		} else if (!batchCode.equals(other.batchCode)){
			return false;
		}
		return true;
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

	
	public String getVwocode() {
		return vwocode;
	}

	public void setVwocode(String vwocode) {
		this.vwocode = vwocode;
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

	public String getLineCode() {
		return lineCode;
	}

	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}

	public String getReceiveSiteCode() {
		return receiveSiteCode;
	}

	public void setReceiveSiteCode(String receiveSiteCode) {
		this.receiveSiteCode = receiveSiteCode;
	}

	public String getOutType() {
		return outType;
	}

	public void setOutType(String outType) {
		this.outType = outType;
	}

	public String getWaybillCode() {
		return waybillCode;
	}

	public void setWaybillCode(String waybillCode) {
		this.waybillCode = waybillCode;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public String getMpackagecode() {
		return mpackagecode;
	}

	public void setMpackagecode(String mpackagecode) {
		this.mpackagecode = mpackagecode;
	}

	public String getPregoodsCode() {
		return pregoodsCode;
	}

	public void setPregoodsCode(String pregoodsCode) {
		this.pregoodsCode = pregoodsCode;
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

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
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

	public String getPadUploadTime() {
		return padUploadTime;
	}

	public void setPadUploadTime(String padUploadTime) {
		this.padUploadTime = padUploadTime;
	}

	public String getOutStatus() {
		return outStatus;
	}

	public void setOutStatus(String outStatus) {
		this.outStatus = outStatus;
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

	public String getReceiveProvAreaName() {
		return receiveProvAreaName;
	}

	public void setReceiveProvAreaName(String receiveProvAreaName) {
		this.receiveProvAreaName = receiveProvAreaName;
	}

	public String getReceiveCityAreaName() {
		return receiveCityAreaName;
	}

	public void setReceiveCityAreaName(String receiveCityAreaName) {
		this.receiveCityAreaName = receiveCityAreaName;
	}

	public String getReceiveCountryAreaName() {
		return receiveCountryAreaName;
	}

	public void setReceiveCountryAreaName(String receiveCountryAreaName) {
		this.receiveCountryAreaName = receiveCountryAreaName;
	}

	public String getReceiveUnitRangePk() {
		return receiveUnitRangePk;
	}

	public void setReceiveUnitRangePk(String receiveUnitRangePk) {
		this.receiveUnitRangePk = receiveUnitRangePk;
	}

	public String getReceivePkUnit() {
		return receivePkUnit;
	}

	public void setReceivePkUnit(String receivePkUnit) {
		this.receivePkUnit = receivePkUnit;
	}

	public String getReceiveUnitName() {
		return receiveUnitName;
	}

	public void setReceiveUnitName(String receiveUnitName) {
		this.receiveUnitName = receiveUnitName;
	}

	 

	public Integer getAladinIsSend() {
		return aladinIsSend;
	}

	public void setAladinIsSend(Integer aladinIsSend) {
		this.aladinIsSend = aladinIsSend;
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

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime == null ? null : DateHandleUtil.getDateStr(creationTime);
	}

	public String getAladinTs() {
		return aladinTs;
	}

	public void setAladinTs(Date aladinTs) {
		this.aladinTs = aladinTs == null ? null : DateHandleUtil.getDateStr(aladinTs);
	}

	public String getAladinSendTime() {
		return aladinSendTime;
	}

	public void setAladinSendTime(Date aladinSendTime) {
		this.aladinSendTime = aladinSendTime == null ? null : DateHandleUtil.getDateStr(aladinSendTime);
	}

	public String getWaybillCreationTime() {
		return waybillCreationTime;
	}

	public void setWaybillCreationTime(Date waybillCreationTime) {
		this.waybillCreationTime = waybillCreationTime == null ? null : DateHandleUtil.getDateStr(waybillCreationTime);
	}

	public String getPkOutstockId() {
		return pkOutstockId;
	}

	public void setPkOutstockId(String pkOutstockId) {
		this.pkOutstockId = pkOutstockId;
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

	public String getReceiveUnitType() {
		return receiveUnitType;
	}

	public void setReceiveUnitType(String receiveUnitType) {
		this.receiveUnitType = receiveUnitType;
	}

	public String getReceivePhone1() {
		return receivePhone1;
	}

	public void setReceivePhone1(String receivePhone1) {
		this.receivePhone1 = receivePhone1;
	}

	public String getReceivePhone2() {
		return receivePhone2;
	}

	public void setReceivePhone2(String receivePhone2) {
		this.receivePhone2 = receivePhone2;
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
		builder.append("OutStockStatusDto [vwocode=");
		builder.append(vwocode);
		builder.append(", creationTime=");
		builder.append(creationTime);
		builder.append(", id=");
		builder.append(id);
		builder.append(", pkOutstockId=");
		builder.append(pkOutstockId);
		builder.append(", taskCode=");
		builder.append(taskCode);
		builder.append(", batchCode=");
		builder.append(batchCode);
		builder.append(", lineCode=");
		builder.append(lineCode);
		builder.append(", receiveSiteCode=");
		builder.append(receiveSiteCode);
		builder.append(", outType=");
		builder.append(outType);
		builder.append(", waybillCode=");
		builder.append(waybillCode);
		builder.append(", barCode=");
		builder.append(barCode);
		builder.append(", vbarcode=");
		builder.append(vbarcode);
		builder.append(", packageType=");
		builder.append(packageType);
		builder.append(", mpackagecode=");
		builder.append(mpackagecode);
		builder.append(", pregoodsCode=");
		builder.append(pregoodsCode);
		builder.append(", operatingTime=");
		builder.append(operatingTime);
		builder.append(", createSiteCode=");
		builder.append(createSiteCode);
		builder.append(", createUser=");
		builder.append(createUser);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", updateUser=");
		builder.append(updateUser);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userPhone=");
		builder.append(userPhone);
		builder.append(", yn=");
		builder.append(yn);
		builder.append(", padUploadTime=");
		builder.append(padUploadTime);
		builder.append(", outStatus=");
		builder.append(outStatus);
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
		builder.append(", receiveProvAreaName=");
		builder.append(receiveProvAreaName);
		builder.append(", receiveCityAreaName=");
		builder.append(receiveCityAreaName);
		builder.append(", receiveCountryAreaName=");
		builder.append(receiveCountryAreaName);
		builder.append(", receiveUnitRangePk=");
		builder.append(receiveUnitRangePk);
		builder.append(", receivePkUnit=");
		builder.append(receivePkUnit);
		builder.append(", receiveUnitName=");
		builder.append(receiveUnitName);
		builder.append(", receiveUnitType=");
		builder.append(receiveUnitType);
		builder.append(", receivePhone1=");
		builder.append(receivePhone1);
		builder.append(", receivePhone2=");
		builder.append(receivePhone2);
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
