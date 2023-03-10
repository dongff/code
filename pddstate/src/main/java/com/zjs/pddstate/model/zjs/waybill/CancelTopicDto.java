package com.zjs.pddstate.model.zjs.waybill;

import com.zjs.pddstate.util.DateHandleUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: jd
 * @description: 取消实体类
 * @author: Lillie
 * @create: 2018-07-13 10:27
 **/
public class CancelTopicDto implements Serializable {

	private String id;

	/** 运单主键 */
	private String pkWo;

	/** 运单号 */
	private String vwocode;

	/** 对应异调单号 */
	private String vwocodeRaw;

	/** 操作时间 */
	private String creationTime;

	/** 最后修改的时间 */
	private String ts;

	/** 数据状态/操作类型 */
	private String operType;

	/** 开单单位编号 */
	private String pkCorpoper;

	/** 作废人工号 */
	private String userCode;

	/** 作废人名称 */
	private String userName;

	/** 作废人电话 */
	private String userPhone;

	// ================作废当前站点信息===================

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

	/** 当前站点电话1 */
	private String phone1;

	/** 当前站点电话1 */
	private String phone2;

	/** 拒收原因 */
	private String fbacktype;

	/** 拒收原因备注说明 */
	private String vapplremark;

	// =================数据来源：运单====================

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

	/** 状态类型ID */
	private String aladinStatusTypeID;

	/** 状态序列 */
	private Integer aladinStatusSort;

	/** 数据来源 */
	private String aladinDataSource;

	// ===============数据来源 ：工作单信息==================

	/** 客户单号 */
	private String vcustcode;

	/** 寄件客户编码 */
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

	/** 开单单位名称 17-03-27 By hanguowei */
	private String corpoperName;

	/** 到达地名称 17-03-27 By hanguowei */
	private String arrival;

	/** 推送MQ中msgid */
	private String msgid;
	/** 当前站点编码 */
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
	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getCorpoperCode() {
		return corpoperCode;
	}

	public void setCorpoperCode(String corpoperCode) {
		this.corpoperCode = corpoperCode;
	}

	/** 开单单位编码 */
	private String corpoperCode;

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

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getAladinStatusTypeID() {
		return aladinStatusTypeID;
	}

	public void setAladinStatusTypeID(String aladinStatusTypeID) {
		this.aladinStatusTypeID = aladinStatusTypeID;
	}


	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
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



	public String getPkCorpoper() {
		return pkCorpoper;
	}

	public void setPkCorpoper(String pkCorpoper) {
		this.pkCorpoper = pkCorpoper;
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

	

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getVwocodeRaw() {
		return vwocodeRaw;
	}

	public void setVwocodeRaw(String vwocodeRaw) {
		this.vwocodeRaw = vwocodeRaw;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	//=================
	

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime == null ? null : DateHandleUtil.getDateStr(creationTime);
	}

	public String getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts == null ? null : DateHandleUtil.getDateStr(ts);
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

	public String getSendCustCode() {
		return sendCustCode;
	}

	public void setSendCustCode(String sendCustCode) {
		this.sendCustCode = sendCustCode;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public void setAladinTs(String aladinTs) {
		this.aladinTs = aladinTs;
	}

	public void setAladinSendTime(String aladinSendTime) {
		this.aladinSendTime = aladinSendTime;
	}

	public void setWaybillCreationTime(String waybillCreationTime) {
		this.waybillCreationTime = waybillCreationTime;
	}
	
	
	

}
