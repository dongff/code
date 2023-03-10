package com.zjs.pddstate.util;

import com.zjs.pddstate.model.pdd.PddRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

import static com.zjs.pddstate.util.Util.objMapper;

/**
 * @Author: Lic
 * @create: 2018/9/3 15:19
 */
@Slf4j
@Component
public class SignUtil {

    /**
     * MD5密匙
     */
    @Value("${pdd.client_secret}")
    private String client_secret;

    @Autowired
    SignUtil signUtil;

    /**
     * 验证秘钥
     * @Author: Lic
     * @create: 2020/8/21 11:22
     */
    public boolean sign(String uuid, PddRequest<String> signData){
        try {
            String sign = signUtil.generateSign(signData);
            if(signData.getSign().equals(sign)){
                return true;
            }
            log.error(uuid+" MD5验证失败，正确sign为"+sign);
        } catch (Exception e) {
            log.error(uuid+" MD5验证数据异常！",e);
            return false;
        }
        return false;
    }

    /**
      * 生成密钥
      * @Author: Lic
      * @create: 2018/9/3 15:33
      * @param signData
      * @return
      */
    public String generateSign(Object signData) throws Exception{
        //log.info("密钥生成请求参数 sign_data="+signData+",app_key="+client_secret);
        Map<String, Object> signDataMap = signDataTransferToTreeMap(signData);
        StringBuilder sb = new StringBuilder();
        sb.append(client_secret);
        for (Map.Entry<String, Object> entry : signDataMap.entrySet()) {
            if (entry.getValue() instanceof Integer || entry.getValue() instanceof Long
                    || entry.getValue() instanceof String) {
                //sb.append(String.format("%s=%s&", entry.getKey(), entry.getValue()));
                sb.append(entry.getKey()+entry.getValue());
            }
        }
        sb.append(client_secret);
        String sign = DigestUtils.md5DigestAsHex(sb.toString().getBytes("UTF-8")).toUpperCase();
        //log.info("生成密钥结果值 sign="+sign);
        return sign;
    }

    /**
      *
      * 参数名称以自然顺序排序
      * @Author: Lic
      * @create: 2018/9/3 15:32
      * @param  postDate
      * @return
      */
    public static Map<String, Object> signDataTransferToTreeMap(Object postDate) {
        if(postDate == null){
            return null;
        }
        Map<String, Object> dataMap = new TreeMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(postDate.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String key = propertyDescriptor.getName();
                if (!"class".equals(key) && !"sign".equals(key)) {
                    Method getter = propertyDescriptor.getReadMethod();
                    Object value = getter.invoke(postDate);
                    if (value != null) {
                        dataMap.put(key, value);
                    }
                }
            }
        } catch (Exception ex) {
            log.error("signDataTransferToTreeMap failed. ex="+ex);
        }
        return dataMap;
    }


    public static void main(String[] args) throws IOException {
        String client_secret = "09d8f9ec433b4bdba77db7439ccbe7afdf09efbd";
        String aa = "{\"sign\":\"9D26C7054617D32CB2906D7567DDBAEB\",\"type\":\"pdd.logistics.co.track.sub\",\"client_id\":\"ae0f5205404643b3aea31027cd65865e\",\"timestamp\":\"1598001847\"}";
                //log.info("密钥生成请求参数 sign_data="+signData+",app_key="+client_secret);
        PddRequest<String> pddRequest = objMapper.readValue(aa,PddRequest.class);
        Map<String, Object> signDataMap = signDataTransferToTreeMap(pddRequest);
        StringBuilder sb = new StringBuilder();
        sb.append(client_secret);
        for (Map.Entry<String, Object> entry : signDataMap.entrySet()) {
            if (entry.getValue() instanceof Integer || entry.getValue() instanceof Long
                    || entry.getValue() instanceof String) {
                sb.append(String.format("%s=%s&", entry.getKey(), entry.getValue()));
                //sb.append(entry.getKey()+entry.getValue());
            }
        }
        sb.append(client_secret);
        System.out.println(sb);
        String sign = DigestUtils.md5DigestAsHex(sb.toString().getBytes("UTF-8")).toUpperCase();

        log.info("生成密钥结果值 sign="+sign);

    }
}
