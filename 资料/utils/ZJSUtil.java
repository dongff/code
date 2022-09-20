package cn.com.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2019/4/18 13:46
 * @modified By:
 */
@Component
public class ZJSUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZJSUtil.class);
    @Autowired
    private MD5Util md5Util;


    public String getRetStr(String url, String clientFlag,String secretKey, String strData, String uuid) throws Exception {
        String verifyData = md5Util.getVerifyData(clientFlag, strData, secretKey, uuid);
        return sendPost(url, strData, verifyData, clientFlag, uuid);
    }

    public String sendPost(String url, String data, String verifyData, String clientFlag, String uuid) throws Exception {
        String respStr = "";
        try {
            /*post请求需要设置请求头*/
            MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
            postParameters.add("clientFlag", clientFlag);
            postParameters.add("verifyData", verifyData);
            postParameters.add("data", data);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/x-www-form-urlencoded");
            HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(postParameters, headers);
            RestTemplate restTemplate = new RestTemplate();
            LOGGER.info("{}传入地址url为：{}", uuid, url);
            LOGGER.info("{}传入参数为：{}", uuid, request);
            respStr = restTemplate.postForObject(url, request, String.class);
            LOGGER.info("{}返回结果为：{}", uuid, respStr);
        } catch (Exception e) {
            LOGGER.error("{} 发送 POST 请求出现异常！{}", uuid, e);
            throw new Exception("为宅急送发送POST请求异常");
        }
        return respStr;
    }

}
