package cn.com.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @program: jd
 * @description: jackson Json转对象，对象转Json方法
 * @author: Lillie
 * @create: 2018-07-27 15:12
 **/
public class JsonUtil {

    private final static ObjectMapper OBJMAPPER = new ObjectMapper();

    private JsonUtil() {
    }

    /**
     * 对象转换成json
     *
     * @param obj
     * @return
     */
    public static String obj2json(Object obj) {
        // ObjectMapper objMapper = new ObjectMapper();
        OBJMAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        // 允许出现特殊字符和转义符
        OBJMAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

        // 允许出现单引号
        OBJMAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        String rtn;
        try {
            rtn = OBJMAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("该对象无法转换成json格式");
        }
        return rtn;
    }

    /**
     * json 转对象
     */
    public static <T> T json2obj(String jsonStr, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        OBJMAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        // 允许出现特殊字符和转义符
        OBJMAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        // 允许出现单引号
        OBJMAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        //如果类里面少字段，json里面多余字段不报错
        OBJMAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        T rtn = null;
        try {
            rtn = OBJMAPPER.readValue(jsonStr, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("该json无法转化为对象:{}", e);
        }
        return rtn;
    }
}
