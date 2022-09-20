package cn.com.utils;

import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;

public class Testdanhaochi2
{
    private static String strConst = "z宅J急S送g";
//获取单号池
    public static void main(String[] args) {

        String url = "http://businesstest.zjs.com.cn:9200/interface/iwc/ctdanhaochitest";

        String jsonData = "{\"clientFlag\":\"test\",\"key\":\"DH100580\",\"applynum\":1}";
        //获取秘钥
        String verifySeed = GetVerifyDataByrdm(jsonData, "7869", "6685", "test", "aafc04a1bacb487fa8d03f2a7bfdb555");
        System.out.println(verifySeed);
        System.out.println("data=" + jsonData + "&clientFlag=test&verifyData=" + verifySeed);
        String str = sendPost(url, "data=" + jsonData + "&clientFlag=test&verifyData=" + verifySeed);
        System.out.println(str);
    }

    //下单
    @Test
    public void testOrder() throws UnsupportedEncodingException {

        String jsonData = "{\"clientFlag\":\"test\",\"mailNo\":\"A602917184045\",\"orderNo\":\"T123589977\",\"busType\":\"1\",\"goodsName\":\"货品\",\"goodsNum\":\"1\",\"goodsWeight\":\"1.0\",\"goodsVolume\":\"1*1*1\",\"sendPro\":\"河北省\",\"sendCity\":\"廊坊市\",\"sendDistrict\":\"三河市\",\"sendAddress\":\"河北省廊坊市三河市燕灵路与燕新大街交叉口荣庆物流\",\"sendMobile\":\"1\",\"receiveName\":\"余璐\",\"receivePro\":\"北京市\",\"receiveCity\":\"北京市\",\"receiveDistrict\":\"昌平区\",\"receiveAddress\":\"龙泽园街道云趣园一区21号楼（放在丰巢！不要送到家来！）\",\"receiveMobile\":\"18701369119\",\"goodsValue\":\"\",\"extendedInfo\":{},\"orderPackages\":[{\"packageWeight\":\"1.0\",\"packageVolume\":\"1*1*1\",\"packageAmount\":\"1\",\"item\":[{\"itemName\":\"卓韵霜染发霜3.16号 12ml 48g 48g 40ml\",\"itemNumber\":\"1\",\"itemValue\":\"79.0\"}]}]}";
        String url = "http://businesstest.zjs.com.cn:9200/edi/order/v1/orderTest";

        String verifySeed = GetVerifyDataByrdm(jsonData, "7869", "6685", "test", "aafc04a1bacb487fa8d03f2a7bfdb555");

        String str = sendPost(url, "data=" + jsonData+ "&clientFlag=test&verifyData=" + verifySeed);
        System.out.println(str);

    }
    //取消下单
    @Test
    public void testCancel() {
        String jsonData = "[{\"clientFlag\":\"test\",\"dataFlag\":\"湖北省\",\"openType\":1,\"orderNo\":\"TMXM06660\"}]";
        String url = "http://businesstest.zjs.com.cn:9200/edi/cancelorder/cancelOrder";

        String verifySeed = GetVerifyDataByrdm(jsonData, "6584", "8281", "test", "aafc04a1bacb487fa8d03f2a7bfdb555");
        System.out.println(verifySeed);
        String str = sendPost(url, "data=" + jsonData + "&clientFlag=test&verifyData=" + verifySeed);
        System.out.println(str);

    }

    //大头笔
    @Test
    public void testFenDan() {
        String jsonData = "[{\"orderNo\":\"test20190621000006\",\"address\":\"上海上海市长宁区娄山关路88号\"}]";
        String url = " http://businesstest.zjs.com.cn:9200/interface/iwc/nctfendantest";

        String verifySeed = GetVerifyDataByrdm(jsonData, "7869", "6685", "test", "aafc04a1bacb487fa8d03f2a7bfdb555");
        System.out.println(verifySeed);
        String str = sendPost(url, "data=" + jsonData + "&clientFlag=test&verifyData=" + verifySeed);
        System.out.println(str);

    }

    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);

            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    public static String GetVerifyDataByrdm(String datajson, String rmd1, String rmd2, String clientFlag, String strSeed) {

        String str = rmd1 + clientFlag + datajson + strSeed + strConst + rmd2;
        System.out.println(str);
        String strMd5 = toMD5(str, "UTF-8");
        strMd5 = strMd5.replace("-", " ");
        strMd5 = strMd5.toLowerCase();
        return rmd1 + strMd5.substring(7, 28) + rmd2;
    }


    public static String toMD5(String plainText, String charset) {
        String md5Str = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes(charset));
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            md5Str = buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5Str;
    }
}
