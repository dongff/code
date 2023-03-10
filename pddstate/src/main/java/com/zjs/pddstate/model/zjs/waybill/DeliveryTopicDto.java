package com.zjs.pddstate.model.zjs.waybill;

import com.zjs.pddstate.util.DateHandleUtil;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Description 派送
 * @author lsj
 */
@Component
public class DeliveryTopicDto implements Serializable {

	
	private String id;

	/** 运单号 */
	
	private String vwocode;

	/** 操作时间 */
	
	private String creationTime;

	/** 派送清单主键 */
	
	private String pkOutb;

	/** 小件员 */
	
	private String pkPdstaff;

	/** 批次号（交接单号） */
	
	private String batchCode;

	/** 出库类型（8,派送清单） */
	
	private String outType;

	/** 运单号 */
	
	private String waybillCode;

	/** 条码号 */
	
	private String barcode;

	/** 冗余保存 条码号*/
	
	private String vbarcode;
	
	/** 操作时间（扫描时间） */
	
	private String operationgTime;

	/** 创建单位（派送单位） */
	
	private String createSitecode;

	/** 创建人（派送人） */
	
	private String createUser;

	/** 创建时间 */
	
	private String createTime;

	/** 修改人 */
	
	private String updateUser;

	/** 修改时间 */
	
	private String updateTime;

	/** （确认出库状态）出库状态 0:未出库 1:已出库 */
	
	private String outStatus;

	/** 是否删除（'0' 删除 '1' 使用） */
	
	private String yn;

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

	/** 当前站点电话1 */

	private String phone1;

	/** 当前站点电话2 */

	private String phone2;

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

	/** 开单单位 */

	private String pkCorpoper;

	/** 开单单位名称 */

	private String corpoperName;

	/** 到达地 */
	
	private String arrival;

	
	/** 推送MQ中msgid */
	
	private String msgid;

	/**
	 *
	 * @param deliveryTopicDtos
	 * @return
	 */
	public ArrayList<DeliveryTopicDto> removeDuplicateDeliveryTopicDto(List<DeliveryTopicDto> deliveryTopicDtos) {
		Set<DeliveryTopicDto> set = new TreeSet<>(new Comparator<DeliveryTopicDto>() {
			@Override
			public int compare(DeliveryTopicDto d1, DeliveryTopicDto d2) {
				//字符串,则按照asicc码升序排列
				return d1.getBatchCode().compareTo(d1.getBatchCode());
			}
		});
		set.addAll(deliveryTopicDtos);
		return new ArrayList<>(set);
	}

	/**
	 * 按时间排序
	 * @param deliveryTopicDtos
	 * @return
	 */
	public ArrayList<DeliveryTopicDto> listSort(List<DeliveryTopicDto> deliveryTopicDtos) {
		List<DeliveryTopicDto> deliveryTopicDtoList = new ArrayList<DeliveryTopicDto>();
		Collections.sort(deliveryTopicDtos, new Comparator<DeliveryTopicDto>() {
			@Override
			public int compare(DeliveryTopicDto i1, DeliveryTopicDto i2) {
				return i1.getCreationTime().compareTo(i2.getCreationTime());
			}
		});
		deliveryTopicDtoList.addAll(deliveryTopicDtos);
		return new ArrayList<DeliveryTopicDto>(deliveryTopicDtoList);
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
		DeliveryTopicDto other = (DeliveryTopicDto) obj;
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

	public String getBts() {
		return bts;
	}

	public void setBts(String bts) {
		this.bts = bts;
	}

	public String getPkDriver() {
		return pkDriver;
	}

	public void setPkDriver(String pkDriver) {
		this.pkDriver = pkDriver;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
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
	 * 2017-06-21 新增字段bts By hgw
	 */
	private String bts;
	
	/** 条形码冗余字段 */
	
	
	/** 物流司机主键 */
	
	private String pkDriver;

	/** 物流司机名称 */
	private String driverName;

	/** 物流司机电话 */
	private String driverPhone;
	
	/** 工作单信息 */

	private String vwocodeRaw;
	
	/** 当前站点编码 */
	
	private String unitCode;
	
	/** 开单单位编码 */

	private String corpoperCode;

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
	
	
	public String getVwocode() {
		return vwocode;
	}

	public void setVwocode(String vwocode) {
		this.vwocode = vwocode;
	}

	public String getPkOutb() {
		return pkOutb;
	}

	public void setPkOutb(String pkOutb) {
		this.pkOutb = pkOutb;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPkPdstaff() {
		return pkPdstaff;
	}

	public void setPkPdstaff(String pkPdstaff) {
		this.pkPdstaff = pkPdstaff;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
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

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getOperationgTime() {
		return operationgTime;
	}

	public void setOperationgTime(String operationgTime) {
		this.operationgTime = operationgTime;
	}

	public String getCreateSitecode() {
		return createSitecode;
	}

	public void setCreateSitecode(String createSitecode) {
		this.createSitecode = createSitecode;
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

	public String getOutStatus() {
		return outStatus;
	}

	public void setOutStatus(String outStatus) {
		this.outStatus = outStatus;
	}

	public String getYn() {
		return yn;
	}

	public void setYn(String yn) {
		this.yn = yn;
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

	public String getAladinTs() {
		return aladinTs;
	}

	public void setAladinTs(Date aladinTs) {
		this.aladinTs = aladinTs == null ? null : DateHandleUtil.getDateStr(aladinTs);
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
		builder.append("DeliveryTopicDto [id=");
		builder.append(id);
		builder.append(", vwocode=");
		builder.append(vwocode);
		builder.append(", creationTime=");
		builder.append(creationTime);
		builder.append(", pkOutb=");
		builder.append(pkOutb);
		builder.append(", pkPdstaff=");
		builder.append(pkPdstaff);
		builder.append(", batchCode=");
		builder.append(batchCode);
		builder.append(", outType=");
		builder.append(outType);
		builder.append(", waybillCode=");
		builder.append(waybillCode);
		builder.append(", barcode=");
		builder.append(barcode);
		builder.append(", vbarcode=");
		builder.append(vbarcode);
		builder.append(", operationgTime=");
		builder.append(operationgTime);
		builder.append(", createSitecode=");
		builder.append(createSitecode);
		builder.append(", createUser=");
		builder.append(createUser);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", updateUser=");
		builder.append(updateUser);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append(", outStatus=");
		builder.append(outStatus);
		builder.append(", yn=");
		builder.append(yn);
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
		builder.append(", phone1=");
		builder.append(phone1);
		builder.append(", phone2=");
		builder.append(phone2);
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
		builder.append(", aladinStatusTypeID=");
		builder.append(aladinStatusTypeID);
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
