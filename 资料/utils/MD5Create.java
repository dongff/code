package cn.com.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2019/8/9 10:23
 * @modified By:
 */
public class MD5Create {
    @Test
    public void MD5() throws Exception {
        String clientFlag = "cebBank";
        String strData = "{\"clientFlag\":\"cebBank\",\"orders\":[{\"orderNo\":\"T20190723102850447\"}]}";
        String secretKey = "79B0E6D5B338102C4F572E646E3CD37C";
        // 进行宅急送秘钥生成
        String str = "0000" + clientFlag + strData + secretKey + "z宅J急S送g" + "0000";
        //将字符串转换成UTF-8格式进行md5加密,截取
        String strMd5 = DigestUtils.md5Hex(str.getBytes("UTF-8")).replace("-", "").toLowerCase().substring(7, 28);
        System.out.println("生成MD5数据: " + "0000" + strMd5 + "0000");
    }
}
