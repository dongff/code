package com.zjs.pddstate.model.pdd;

import com.zjs.pddstate.model.pdd.city.CityInfo;
import com.zjs.pddstate.model.pdd.city.Response;
import com.zjs.pddstate.model.pdd.state.ResponseItem;
import com.zjs.pddstate.model.pdd.state.Trace;
import lombok.Data;

import java.util.List;

/**
 * @Author: Lic
 * @create: 2020/8/12 14:48
 */
@Data
public class PddResponse {

/*错误码	    错误信息		  描述
0	    成功	            接口调用成功，无业务、系统异常
9999	失败	            业务失败，重复调用接口也不会成功的异常码。
9990	系统异常	        ISV系统内部发生异常
1001	非法的渠道编号	ship_id有误，需要联系PDD确认
1100	签名为空
1101	验签信息错误
1202	缺少必填字段
1204	推送消息解析失败
1205	时间戳格式有误
1206	物流轨迹数超过阈值
1208	超过调用频率限制
1209	用户没有授权此接口
1210	当前接口系统维护，暂时下线，请稍后再试
1211	重复订阅
1230	不存在的运单
1250	不支持推送
1251	消息体过大
1302	此运单号尚未订阅*/
    /**
     * 物流公司ID
     */
    private String ship_id;
    /**
     * 物流公司ID
     */
    private Boolean success;
    /**
     * 返回码 见上方（订阅接口用）
     */
    private String reason_code;

    /**
     * 状态查询返回实体
     */
    private List<Trace> data;

    /**
     * 状态回传返回实体
     */
    private List<ResponseItem> response_items;

    /**
     * 城市查询返回实体
     */
    private Response response;

    /**
     *
     */
    private String request_id;

}

