package com.zjs.pddstate.model.zjs.waybill;

import com.zjs.pddstate.util.DateHandleUtil;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description 签收 - 签收标签（AthenaSignFilterTag）
 * @author lsj
 */
@Component
public class SignFilterTagDto implements Serializable {


	private String id;

	/** 运单号 */
	
	private String vwocode;

	/** 操作时间 */
	
	private String creationTime;

	/** 签收主键 */
	
	private String pkSign;

	/** 工作单号 */
	
	private String wbCode;

	/**
	 * 签收类型 2231未签收 2232 正常签收 2233 返货签收 2234 异常签收
	 */
	
	private String fsigntype;

	/**
	 * 签收方式 2154 PDA签收 2152 短信签收 2153 厅点签收 2154 tms签收
	 */
	
	private String fsignclass;

	/** 派送员工 -- 员工主键 */
	private String deliverier;

	/** 派送单位 -- 单位pk */

	private String pkCorpdelr;

	/** 签收人 */
	private String signer;

	/** 签收时间 */
	private String tsigntime;

	/** 修改人 -- 员工主键 */
	private String modifier;

	/** 修改时间 */
	private String modifiedtime;

	/** 客户编码 */
	private String custCode;

	/** 推送时间 */
	private String bts;

	/** 是否删除 */
	private String dr;

	/** 操作人员工号 */
	private String userCode;

	/** 操作人员名称 */
	private String userName;

	/** 操作人员电话 */
	private String userPhone;

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

	/** 当前站点类型 */
	private String unitType;

	/** 当前站点名称 */
	private String unitName;

	/** 数据生产时间 */
	private String aladinTs;

	/** 删除标识 */
	private Integer aladinDr;

	/** 删除说明 */
	private String aladinDrDesc;

	/** 发送状态 */
	private Integer aladinIsSend;

	/** 发送时间 */
	private String aladinSendTime;

	/** 状态类型 */
	
	private String aladinStatusType;

	/** 状态序列 */

	private Integer aladinStatusSort;

	/** 数据来源 */
	
	private String aladinDataSource;

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

	/** 状态类型ID */
	
	private String aladinStatusTypeID;

	/** 运单开单时间 */
	
	private String waybillCreationTime;

	/** phone1 */
	private String phone1;

	/** phone2 */

	private String phone2;

	/** 开单单位 */
	
	private String pkCorpoper;

	/** 开单单位名称 */
	
	private String corpoperName;

	/** 到达地 */
	
	private String arrival;
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

	/* 2018-2-9新增 */
	/** 送达时限 */
	private String arrvLimmit;
	/** 产品时限 */
	private BigDecimal prodtimelimit;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVwocode() {
		return vwocode;
	}

	public void setVwocode(String vwocode) {
		this.vwocode = vwocode;
	}

	public String getPkSign() {
		return pkSign;
	}

	public void setPkSign(String pkSign) {
		this.pkSign = pkSign;
	}

	public String getWbCode() {
		return wbCode;
	}

	public void setWbCode(String wbCode) {
		this.wbCode = wbCode;
	}

	public String getFsigntype() {
		return fsigntype;
	}

	public void setFsigntype(String fsigntype) {
		this.fsigntype = fsigntype;
	}

	public String getFsignclass() {
		return fsignclass;
	}

	public void setFsignclass(String fsignclass) {
		this.fsignclass = fsignclass;
	}

	public String getDeliverier() {
		return deliverier;
	}

	public void setDeliverier(String deliverier) {
		this.deliverier = deliverier;
	}

	public String getPkCorpdelr() {
		return pkCorpdelr;
	}

	public void setPkCorpdelr(String pkCorpdelr) {
		this.pkCorpdelr = pkCorpdelr;
	}

	public String getSigner() {
		return signer;
	}

	public void setSigner(String signer) {
		this.signer = signer;
	}

	public String getTsigntime() {
		return tsigntime;
	}

	public void setTsigntime(String tsigntime) {
		this.tsigntime = tsigntime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getBts() {
		return bts;
	}

	public void setBts(String bts) {
		this.bts = bts;
	}

	public String getDr() {
		return dr;
	}

	public void setDr(String dr) {
		this.dr = dr;
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

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
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

	public String getAladinStatusTypeID() {
		return aladinStatusTypeID;
	}

	public void setAladinStatusTypeID(String aladinStatusTypeID) {
		this.aladinStatusTypeID = aladinStatusTypeID;
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

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public void setAladinTs(String aladinTs) {
		this.aladinTs = aladinTs;
	}

	public void setWaybillCreationTime(String waybillCreationTime) {
		this.waybillCreationTime = waybillCreationTime;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SignFilterTagDto [id=");
		builder.append(id);
		builder.append(", vwocode=");
		builder.append(vwocode);
		builder.append(", creationTime=");
		builder.append(creationTime);
		builder.append(", pkSign=");
		builder.append(pkSign);
		builder.append(", wbCode=");
		builder.append(wbCode);
		builder.append(", fsigntype=");
		builder.append(fsigntype);
		builder.append(", fsignclass=");
		builder.append(fsignclass);
		builder.append(", deliverier=");
		builder.append(deliverier);
		builder.append(", pkCorpdelr=");
		builder.append(pkCorpdelr);
		builder.append(", signer=");
		builder.append(signer);
		builder.append(", tsigntime=");
		builder.append(tsigntime);
		builder.append(", modifier=");
		builder.append(modifier);
		builder.append(", modifiedtime=");
		builder.append(modifiedtime);
		builder.append(", custCode=");
		builder.append(custCode);
		builder.append(", bts=");
		builder.append(bts);
		builder.append(", dr=");
		builder.append(dr);
		builder.append(", userCode=");
		builder.append(userCode);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userPhone=");
		builder.append(userPhone);
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
		builder.append(", aladinTs=");
		builder.append(aladinTs);
		builder.append(", aladinDr=");
		builder.append(aladinDr);
		builder.append(", aladinDrDesc=");
		builder.append(aladinDrDesc);
		builder.append(", aladinIsSend=");
		builder.append(aladinIsSend);
		builder.append(", aladinSendTime=");
		builder.append(aladinSendTime);
		builder.append(", aladinStatusType=");
		builder.append(aladinStatusType);
		builder.append(", aladinStatusSort=");
		builder.append(aladinStatusSort);
		builder.append(", aladinDataSource=");
		builder.append(aladinDataSource);
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
		builder.append(", aladinStatusTypeID=");
		builder.append(aladinStatusTypeID);
		builder.append(", waybillCreationTime=");
		builder.append(waybillCreationTime);
		builder.append(", phone1=");
		builder.append(phone1);
		builder.append(", phone2=");
		builder.append(phone2);
		builder.append(", pkCorpoper=");
		builder.append(pkCorpoper);
		builder.append(", corpoperName=");
		builder.append(corpoperName);
		builder.append(", arrival=");
		builder.append(arrival);
		builder.append("]");
		return builder.toString();
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}




	
}
