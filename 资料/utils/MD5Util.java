package cn.com.utils;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * @program: sinopec-api
 * @description: 生成VerifyData签名
 * @author: Lillie
 * @create: 2018-05-18 10:03
 **/
@Component
public class MD5Util {
    private static final Logger LOGGER = LoggerFactory.getLogger(MD5Util.class);

    @ApiModelProperty("宅急送常量")
    @Value("${zjs.constant}")
    private String constant;

    @ApiModelProperty(value = "获取VerifyData签名")
    public String getVerifyData(String clientFlag, String strData, String secretKey, String uuid) {
        //生成两个随机数
        String randomOne = getRandom(4);
        String randomTwo = getRandom(4);
        // 进行宅急送秘钥生成
        String str = randomOne + clientFlag + strData + secretKey + constant + randomTwo;
        String strMd5;
        try {
            //将字符串转换成UTF-8格式进行md5加密,截取
            strMd5 = DigestUtils.md5Hex(str.getBytes("UTF-8")).replace("-", "").toLowerCase().substring(7, 28);
            LOGGER.info("{}生成MD5数据：{}", uuid, strMd5);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(uuid + " 字符串转换成UTF-8格式异常:" + e);
            throw new RuntimeException(e);
        }
        return randomOne + strMd5 + randomTwo;

    }

    @ApiModelProperty(value = "获取VerifyData签名")
    public String getVerifyData(String randomOne, String randomTwo, String clientFlag, String strData, String secretKey, String uuid) {

        // 进行宅急送秘钥生成
        String str = randomOne + clientFlag + strData + secretKey + constant + randomTwo;
        String strMd5;
        try {
            //将字符串转换成UTF-8格式进行md5加密,截取
            strMd5 = DigestUtils.md5Hex(str.getBytes("UTF-8")).replace("-", "").toLowerCase().substring(7, 28);

        } catch (UnsupportedEncodingException e) {
            LOGGER.error(uuid + " 字符串转换成UTF-8格式异常:" + e);
            throw new RuntimeException(e);
        }
        strMd5 = randomOne + strMd5 + randomTwo;
        LOGGER.info("{}生成MD5数据：{}", uuid, strMd5);
        return strMd5;

    }

    /**
     * @param digit 位数
     * @return
     */
    @ApiModelProperty(value = "获取指定位数的随机数")
    private String getRandom(int digit) {
        StringBuffer sb = new StringBuffer();
        String str = "0123456789";
        Random r = new Random();
        for (int i = 0; i < digit; i++) {
            int num = r.nextInt(str.length());
            sb.append(str.charAt(num));
            str = str.replace((str.charAt(num) + ""), "");
        }
        return sb.toString();
    }
}
