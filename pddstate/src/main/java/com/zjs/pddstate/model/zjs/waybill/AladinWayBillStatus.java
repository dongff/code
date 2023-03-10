package com.zjs.pddstate.model.zjs.waybill;


import com.zjs.pddstate.util.DateHandleUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: jd
 * @description: 揽收开单实体类
 * @author: Lillie
 * @create: 2018-07-13 10:27
 **/
public class AladinWayBillStatus implements Serializable{


	private String id;
	
	/** 运单主键 */
	private String pkWo;

	/** 运单号 */
	private String vwocode;
	
	/** 最后修改的时间 */
	private String ts;

	/** 操作时间 */
	private String creationTime;
	
	/** 数据状态/操作类型 */
	private String operType;

	/** 开单单位编号 */
	private String pkCorpoper;

	/** 取件人主键 */
	private String pkPicker;

	/** 取件单位 */
	private String pkPickCorp;

	/** 取件人工号 */
	private String pickerUserCode;

	/** 取件人名称 */
	private String pickerUserName;

	/** 取件人电话*/
	private String pickerMobile;

	/** 操作人工号 */
	private String userCode;

	/** 操作人名称 */
	private String userName;
	
	/** 操作人电话*/
	private String userPhone;
	
	//================取件站点信息===================
	/** 取件站点省*/
	private String fetchProvAreaName;
	
	/** 取件站点市*/
	private String fetchCityAreaName;
	
	/** 取件站点县*/
	private String fetchCountryAreaName;
	
	/** 取件站点主键*/
	private String fetchUnitRangePk;
	
	/** 取件站点编号*/
	private String fetchPkUnit;
	
	/** 取件站点类型*/
	private String fetchUnitType;
	
	/** 取件站点名称*/
	private String fetchUnitName;
	
	/** 取件站点电话1*/
	private String fetchPhone1;
	
	/** 取件站点电话2*/
	private String fetchPhone2;

	/** 取件站点编码*/
	private String fetchUnitCode;
	
	/** 拒收原因*/
	private String fbacktype;
	
	/** 拒收原因备注说明*/
	private String vapplremark;
	
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

	// =================数据来源：运单====================

	/** 数据生产时间 */
	private String aladinTs;


	/** 发送状态 */
	private Integer aladinIsSend;

	/** 发送时间 */
	private String aladinSendTime;

	/** 状态类型 */
	private String aladinStatusType;
	
	/** 状态类型ID */
	private String aladinStatusTypeID;

	/** 状态序列 */
	private Integer aladinStatusSort;

	/** 数据来源 */
	private String aladinDataSource;

	/** 删除标识 */
	private Integer aladinDr;
	
	/** 删除说明*/
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

	public String getFetchUnitCode() {
		return fetchUnitCode;
	}

	public void setFetchUnitCode(String fetchUnitCode) {
		this.fetchUnitCode = fetchUnitCode;
	}

	public void setAladinSendTime(String aladinSendTime) {
		this.aladinSendTime = aladinSendTime;
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


	public String getOperType() {
		return operType;
	}


	public void setOperType(String operType) {
		this.operType = operType;
	}


	public String getPkCorpoper() {
		return pkCorpoper;
	}


	public void setPkCorpoper(String pkCorpoper) {
		this.pkCorpoper = pkCorpoper;
	}


	public String getPkPicker() {
		return pkPicker;
	}


	public void setPkPicker(String pkPicker) {
		this.pkPicker = pkPicker;
	}


	public String getPkPickCorp() {
		return pkPickCorp;
	}


	public void setPkPickCorp(String pkPickCorp) {
		this.pkPickCorp = pkPickCorp;
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


	public String getFetchProvAreaName() {
		return fetchProvAreaName;
	}


	public void setFetchProvAreaName(String fetchProvAreaName) {
		this.fetchProvAreaName = fetchProvAreaName;
	}


	public String getFetchCityAreaName() {
		return fetchCityAreaName;
	}


	public void setFetchCityAreaName(String fetchCityAreaName) {
		this.fetchCityAreaName = fetchCityAreaName;
	}


	public String getFetchCountryAreaName() {
		return fetchCountryAreaName;
	}


	public void setFetchCountryAreaName(String fetchCountryAreaName) {
		this.fetchCountryAreaName = fetchCountryAreaName;
	}


	public String getFetchUnitRangePk() {
		return fetchUnitRangePk;
	}


	public void setFetchUnitRangePk(String fetchUnitRangePk) {
		this.fetchUnitRangePk = fetchUnitRangePk;
	}


	public String getFetchPkUnit() {
		return fetchPkUnit;
	}


	public void setFetchPkUnit(String fetchPkUnit) {
		this.fetchPkUnit = fetchPkUnit;
	}



	public String getFbacktype() {
		return fbacktype;
	}


	public void setFbacktype(String fbacktype) {
		this.fbacktype = fbacktype;
	}


	public String getVapplremark() {
		return vapplremark;
	}


	public void setVapplremark(String vapplremark) {
		this.vapplremark = vapplremark;
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

	public String getFetchUnitType() {
		return fetchUnitType;
	}


	public void setFetchUnitType(String fetchUnitType) {
		this.fetchUnitType = fetchUnitType;
	}


	public String getFetchUnitName() {
		return fetchUnitName;
	}


	public void setFetchUnitName(String fetchUnitName) {
		this.fetchUnitName = fetchUnitName;
	}


	public String getFetchPhone1() {
		return fetchPhone1;
	}


	public void setFetchPhone1(String fetchPhone1) {
		this.fetchPhone1 = fetchPhone1;
	}


	public String getFetchPhone2() {
		return fetchPhone2;
	}


	public void setFetchPhone2(String fetchPhone2) {
		this.fetchPhone2 = fetchPhone2;
	}


	public void setTs(String ts) {
		this.ts = ts;
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


	public String getPickerUserCode() {
		return pickerUserCode;
	}


	public void setPickerUserCode(String pickerUserCode) {
		this.pickerUserCode = pickerUserCode;
	}


	public String getPickerUserName() {
		return pickerUserName;
	}


	public void setPickerUserName(String pickerUserName) {
		this.pickerUserName = pickerUserName;
	}


	public String getPickerMobile() {
		return pickerMobile;
	}


	public void setPickerMobile(String pickerMobile) {
		this.pickerMobile = pickerMobile;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AladinWayBillStatus [id=");
		builder.append(id);
		builder.append(", pkWo=");
		builder.append(pkWo);
		builder.append(", vwocode=");
		builder.append(vwocode);
		builder.append(", ts=");
		builder.append(ts);
		builder.append(", creationTime=");
		builder.append(creationTime);
		builder.append(", operType=");
		builder.append(operType);
		builder.append(", pkCorpoper=");
		builder.append(pkCorpoper);
		builder.append(", pkPicker=");
		builder.append(pkPicker);
		builder.append(", pkPickCorp=");
		builder.append(pkPickCorp);
		builder.append(", pickerUserCode=");
		builder.append(pickerUserCode);
		builder.append(", pickerUserName=");
		builder.append(pickerUserName);
		builder.append(", pickerMobile=");
		builder.append(pickerMobile);
		builder.append(", userCode=");
		builder.append(userCode);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userPhone=");
		builder.append(userPhone);
		builder.append(", fetchProvAreaName=");
		builder.append(fetchProvAreaName);
		builder.append(", fetchCityAreaName=");
		builder.append(fetchCityAreaName);
		builder.append(", fetchCountryAreaName=");
		builder.append(fetchCountryAreaName);
		builder.append(", fetchUnitRangePk=");
		builder.append(fetchUnitRangePk);
		builder.append(", fetchPkUnit=");
		builder.append(fetchPkUnit);
		builder.append(", fetchUnitType=");
		builder.append(fetchUnitType);
		builder.append(", fetchUnitName=");
		builder.append(fetchUnitName);
		builder.append(", fetchPhone1=");
		builder.append(fetchPhone1);
		builder.append(", fetchPhone2=");
		builder.append(fetchPhone2);
		builder.append(", fbacktype=");
		builder.append(fbacktype);
		builder.append(", vapplremark=");
		builder.append(vapplremark);
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
		builder.append(", corpoperName=");
		builder.append(corpoperName);
		builder.append(", arrival=");
		builder.append(arrival);
		builder.append(", unitCode=");
		builder.append(unitCode);
		builder.append(", fetchUnitCode=");
		builder.append(fetchUnitCode);
		builder.append(", aladinSendTime=");
		builder.append(aladinSendTime);
		builder.append("]");
		return builder.toString();
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
	
	
}
