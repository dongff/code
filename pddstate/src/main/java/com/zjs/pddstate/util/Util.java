package com.zjs.pddstate.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 对象和json字符串转换
 * @Author: Lic
 * @create: 2018/8/6 16:19
 */
@Component
public class Util {


    /*object与json互转*/
    public static ObjectMapper objMapper = new ObjectMapper();

    static{
        //当类里面少属性时也不会报错
        objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //Include.NON_DEFAULT 属性为默认值不序列化
        //Include.NON_EMPTY 属性为 空（“”） 或者为 NULL 都不序列化
        //Include.NON_NULL 属性为NULL 不序列化
        //忽略null
        objMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // 允许出现特殊字符和转义符
        objMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

        // 允许出现单引号
        objMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

    }

    /**
     * 转单快递公司ID获取
     * @Author: Lic
     * @create: 2020/8/12 16:25
     */
    public String transferPartnerId (String trn){
        if(trn.contains("申通")){
            return "1000";
        }
        if(trn.contains("汇通")){
            return "1001";
        }
        if(trn.contains("百世")){
            return "1002";
        }
        if(trn.contains("顺丰")){
            return "1043";
        }
        if(trn.contains("圆通")){
            return "1084";
        }
        if(trn.contains("晟邦")){
            return "1089";
        }
        if(trn.contains("中通")){
            return "1114";
        }
        if(trn.contains("邮政")||trn.contains("EMS")){
            return "1117";
        }
        if(trn.contains("天天")){
            return "1118";
        }
        if(trn.contains("京东")){
            return "1119";
        }
        if(trn.contains("韵达")){
            return "1120";
        }
        if(trn.contains("国通")){
            return "1123";
        }
        if(trn.contains("宅急送")){
            return "1128";
        }
        if(trn.contains("如风达")){
            return "1129";
        }
        if(trn.contains("德邦")){
            return "1130";
        }
        if(trn.contains("苏宁")){
            return "1227";
        }
        return "180";
    }

    /**
     * 判断这个站点是1网点还是2中转/分拨中心
     * @Author: Lic
     * @create: 2018/5/7 10:25
     * @param  unitType  站点
     * @param  unitType  站点
     * @return unitType  1：网点 2：中转/分拨中心
     */
    public int unitType(String unitType){
        int siteType = 1;
        if(""!=unitType&&null!=unitType) {
            if ("BOSCORP00000000A0005".equals(unitType) ||
                    "BOSCORP00000000A0007".equals(unitType) ||
                    "BOSCORP00000000A0020".equals(unitType) ||
                    "BOSCORP00000000A0021".equals(unitType)) {
                siteType = 2;
            }
        }
        return siteType;
    }

    /**
     * 拒收异常
     *
     * @param fbacktype
     * @return
     */
    private static String errorFailed(String fbacktype) {
        if (!StringUtils.isEmpty(fbacktype)){
            return null;
        }else if (fbacktype.contains("收货人多次联系不上")) {
            return "FAIL_101";
        } else if (fbacktype.contains("收货人拒收")) {
            return "REJECTION_211";
        } else {
            return null;
        }
    }

    /**
     * 获取下次重试的时间
     * @Author: Lic
     * @create: 2019/4/28 10:44
     */
    public String retryTime(int esm) {
        Date pt = null;
        Calendar c = Calendar.getInstance();
        c.get(Calendar.HOUR_OF_DAY);
        c.setTime(new Date());
        if (esm <= 3) {
            pt =(new Date());
        }
        if (esm > 3 && esm <= 6) {
            c.add(Calendar.MINUTE, (esm - 3) * 10);
            pt =(c.getTime());
        }
        if (esm > 6) {
            c.add(Calendar.HOUR_OF_DAY, (esm - 6) * 1);
            pt =(c.getTime());
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pt);
    }

    /**
     * 获取当前时间的前一分钟或后一分钟
     * @Author: Lic
     * @create: 2019/4/28 10:44
     */
    public String time(int amount) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE,amount);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
    }

    /**
     * 获取当前时间的前两小时或后两小时
     * @Author: Lic
     * @create: 2019/4/28 10:44
     */
    public String hourstime(int amount) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY,amount);
        cal.add(Calendar.HOUR_OF_DAY,amount);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
    }

}
