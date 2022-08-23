package cn.com.utils;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2019/6/11 14:32
 * @modified By:
 */
public class Constans {
    //@ApiModelProperty(value = "电子口岸申报中")
    public final static String STATUS_APPLYING ="2";
    //@ApiModelProperty(value = "发送海关成功")
    public final static String STATUS_SUCCESS ="3";
    //@ApiModelProperty(value = "发送海关失败")
    public final static String STATUS_FAIL ="4";
    //@ApiModelProperty(value = "海关退单")
    public final static String STATUS_RETURN ="100";
    //@ApiModelProperty(value = "海关入库")
    public final static String STATUS_INPUT ="120";

    //@ApiModelProperty(value = "国检正确")
    public final static String STATUS_CIQ_SUECCESS_ ="CIQ01";
    //@ApiModelProperty(value = "国检错误")
    public final static String STATUS_CIQ_FAIL_ ="CIQ02";

    //@ApiModelProperty(value = "未推送")
    public final static String PUSH_STATUS_NOPUSH="1";
    //@ApiModelProperty(value = "已推送")
    public final static String PUSH_STATUS_PUSHED="2";
    //@ApiModelProperty(value = "回执成功")
    public final static String PUSH_STATUS_PUSHSUCCESS="3";
    //@ApiModelProperty(value = "回执失败")
    public final static String PUSH_STATUS_PUSHFAIL="4";
}
