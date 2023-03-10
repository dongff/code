package com.zjs.pddstate.model.zjs.waybill;

import com.zjs.pddstate.util.DateHandleUtil;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description 异常
 * @author lsj
 */

@Component
public class ExcpInfoTopicDto implements Serializable {


	private String id;

	/** 操作时间 */

	private String creationTime;

	/** 异常主键 */
	
	private String pkWoexcp;

	/** 条码号 */
		private String vwobarcode;

	/** 冗余保存 条码号*/
	
	private String vbarcode;
	
	/** 异常原因编码 */

	private String vexcpcode;

	/** 异常类型 */
	
	private String vexcptype;

	/** 异常项目 */
	
	private String vexcpitem;

	/** 接受单位 */
	
	private String crecvcorp;

	/** 是否需要处理 “Y”和‘N’ */
	
	private String bsneeddeal;

	/** 意见备注 */

	private String vremark;

	/** 录入人 */

	private String creator;

	/** 录入单位 */

	private String pkCorp;

	/** 处理人 */
	
	private String cdealer;

	/** 处理时间 */

	private String tdealtime;

	/** 处理单位 */

	private String cdealcorp;

	/** 处理结果 */

	private String vdealresult;

	/** 处理结果备注 */
	private String cnfmresult;

	/** 运单号 */
	private String vwocode;

	/** 运单主键 */

	private String pkWo;

	/** 异常项目编码 */
	private String vexcpitemCode;

	/** 异常原因 */
	private String vexcpwhy;

	/** 附加名称 多个附件以“,”分割 */
	private String vannexname;

	/** 附加编码 多个附件以“,”分割 */
	private String vannexcode;

	/** 处理状态 5601=未处理 5603=已处理 */
	private String dealerStu;

	/** 异常原因类型 */
	private String vexcpwhyStu;

	/** 异常批次号 同一批录入的数据会生成一个批次号 */
	private String excpbatch;

	/** 当前数据操作人 */

	private String modifier;

	/** 当前数据操作时间 */

	private String modifiedtime;

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

	/** 处理人 */

	private String cdealerName;

	/** 处理单位 */

	private String cdealcorpName;

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
	
	/** 推送MQ中msgid */

	private String msgid;
	
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
	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public String getbTs() {
		return bTs;
	}

	public void setbTs(String bTs) {
		this.bTs = bTs;
	}

	public String getVwocodeRaw() {
		return vwocodeRaw;
	}

	public void setVwocodeRaw(String vwocodeRaw) {
		this.vwocodeRaw = vwocodeRaw;
	}

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

	public void setAladinSendTime(String aladinSendTime) {
		this.aladinSendTime = aladinSendTime;
	}

	/**
	 * 2017-06-20 新加时间戳
	 * by hgw
	 */

	private String bTs;
	
	/** 条形码冗余字段 */
	
	
	/** 工作单信息 */

	private String vwocodeRaw;
	
	/** 当前站点编码 */

	private String unitCode;
	
	/** 开单单位编码 */

	private String corpoperCode;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPkWoexcp() {
		return pkWoexcp;
	}

	public void setPkWoexcp(String pkWoexcp) {
		this.pkWoexcp = pkWoexcp;
	}

	public String getVwobarcode() {
		return vwobarcode;
	}

	public void setVwobarcode(String vwobarcode) {
		this.vwobarcode = vwobarcode;
	}

	public String getVexcpcode() {
		return vexcpcode;
	}

	public void setVexcpcode(String vexcpcode) {
		this.vexcpcode = vexcpcode;
	}

	public String getVexcptype() {
		return vexcptype;
	}

	public void setVexcptype(String vexcptype) {
		this.vexcptype = vexcptype;
	}

	public String getVexcpitem() {
		return vexcpitem;
	}

	public void setVexcpitem(String vexcpitem) {
		this.vexcpitem = vexcpitem;
	}

	public String getCrecvcorp() {
		return crecvcorp;
	}

	public void setCrecvcorp(String crecvcorp) {
		this.crecvcorp = crecvcorp;
	}

	public String getBsneeddeal() {
		return bsneeddeal;
	}

	public void setBsneeddeal(String bsneeddeal) {
		this.bsneeddeal = bsneeddeal;
	}

	public String getVremark() {
		return vremark;
	}

	public void setVremark(String vremark) {
		this.vremark = vremark;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getPkCorp() {
		return pkCorp;
	}

	public void setPkCorp(String pkCorp) {
		this.pkCorp = pkCorp;
	}

	public String getCdealer() {
		return cdealer;
	}

	public void setCdealer(String cdealer) {
		this.cdealer = cdealer;
	}

	public String getTdealtime() {
		return tdealtime;
	}

	public void setTdealtime(String tdealtime) {
		this.tdealtime = tdealtime;
	}

	public String getCdealcorp() {
		return cdealcorp;
	}

	public void setCdealcorp(String cdealcorp) {
		this.cdealcorp = cdealcorp;
	}

	public String getVdealresult() {
		return vdealresult;
	}

	public void setVdealresult(String vdealresult) {
		this.vdealresult = vdealresult;
	}

	public String getCnfmresult() {
		return cnfmresult;
	}

	public void setCnfmresult(String cnfmresult) {
		this.cnfmresult = cnfmresult;
	}

	public String getVwocode() {
		return vwocode;
	}

	public void setVwocode(String vwocode) {
		this.vwocode = vwocode;
	}

	public String getPkWo() {
		return pkWo;
	}

	public void setPkWo(String pkWo) {
		this.pkWo = pkWo;
	}

	public String getVexcpitemCode() {
		return vexcpitemCode;
	}

	public void setVexcpitemCode(String vexcpitemCode) {
		this.vexcpitemCode = vexcpitemCode;
	}

	public String getVexcpwhy() {
		return vexcpwhy;
	}

	public void setVexcpwhy(String vexcpwhy) {
		this.vexcpwhy = vexcpwhy;
	}

	public String getVannexname() {
		return vannexname;
	}

	public void setVannexname(String vannexname) {
		this.vannexname = vannexname;
	}

	public String getVannexcode() {
		return vannexcode;
	}

	public void setVannexcode(String vannexcode) {
		this.vannexcode = vannexcode;
	}

	public String getDealerStu() {
		return dealerStu;
	}

	public void setDealerStu(String dealerStu) {
		this.dealerStu = dealerStu;
	}

	public String getVexcpwhyStu() {
		return vexcpwhyStu;
	}

	public void setVexcpwhyStu(String vexcpwhyStu) {
		this.vexcpwhyStu = vexcpwhyStu;
	}

	public String getExcpbatch() {
		return excpbatch;
	}

	public void setExcpbatch(String excpbatch) {
		this.excpbatch = excpbatch;
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

	public String getCdealerName() {
		return cdealerName;
	}

	public void setCdealerName(String cdealerName) {
		this.cdealerName = cdealerName;
	}

	public String getCdealcorpName() {
		return cdealcorpName;
	}

	public void setCdealcorpName(String cdealcorpName) {
		this.cdealcorpName = cdealcorpName;
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
		builder.append("ExcpInfoTopicDto [id=");
		builder.append(id);
		builder.append(", creationTime=");
		builder.append(creationTime);
		builder.append(", pkWoexcp=");
		builder.append(pkWoexcp);
		builder.append(", vwobarcode=");
		builder.append(vwobarcode);
		builder.append(", vbarcode=");
		builder.append(vbarcode);
		builder.append(", vexcpcode=");
		builder.append(vexcpcode);
		builder.append(", vexcptype=");
		builder.append(vexcptype);
		builder.append(", vexcpitem=");
		builder.append(vexcpitem);
		builder.append(", crecvcorp=");
		builder.append(crecvcorp);
		builder.append(", bsneeddeal=");
		builder.append(bsneeddeal);
		builder.append(", vremark=");
		builder.append(vremark);
		builder.append(", creator=");
		builder.append(creator);
		builder.append(", pkCorp=");
		builder.append(pkCorp);
		builder.append(", cdealer=");
		builder.append(cdealer);
		builder.append(", tdealtime=");
		builder.append(tdealtime);
		builder.append(", cdealcorp=");
		builder.append(cdealcorp);
		builder.append(", vdealresult=");
		builder.append(vdealresult);
		builder.append(", cnfmresult=");
		builder.append(cnfmresult);
		builder.append(", vwocode=");
		builder.append(vwocode);
		builder.append(", pkWo=");
		builder.append(pkWo);
		builder.append(", vexcpitemCode=");
		builder.append(vexcpitemCode);
		builder.append(", vexcpwhy=");
		builder.append(vexcpwhy);
		builder.append(", vannexname=");
		builder.append(vannexname);
		builder.append(", vannexcode=");
		builder.append(vannexcode);
		builder.append(", dealerStu=");
		builder.append(dealerStu);
		builder.append(", vexcpwhyStu=");
		builder.append(vexcpwhyStu);
		builder.append(", excpbatch=");
		builder.append(excpbatch);
		builder.append(", modifier=");
		builder.append(modifier);
		builder.append(", modifiedtime=");
		builder.append(modifiedtime);
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
		builder.append(", cdealerName=");
		builder.append(cdealerName);
		builder.append(", cdealcorpName=");
		builder.append(cdealcorpName);
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
