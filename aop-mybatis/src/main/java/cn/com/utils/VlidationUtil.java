package cn.com.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.xml.bind.ValidationException;
import java.util.Set;


/**
 * 校验工具类
 *
 * @author 李文
 * @create 2017-07-05 14:07
 **/
public class VlidationUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(VlidationUtil.class);

    private static Validator validator;

    static {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }


    /**
     * @param t 将要校验的对象
     */
    public static <T> void validate(T t) throws ValidationException {
        Set<ConstraintViolation<T>> set = validator.validate(t);
        if (set.size() > 0) {
            StringBuilder validateError = new StringBuilder();
            for (ConstraintViolation<T> val : set) {
                validateError.append(val.getMessage() + " ;");
            }
            throw new ValidationException(validateError.toString());
        }
    }


    /**
     * 字符串 为空  与长度验证
     */
    public static void verifyTheField(String id, String k, String v, Integer l) throws Exception {
        if (StringUtils.isEmpty(v) || v.length() > l) {
            LOGGER.error(id + " 数据验证错误 字段为空 或者长度超出  字段名称 " + k + "  值 " + v);
            throw new Exception(id + " 数据验证错误 字段为空 或者长度超出  " + k);
        }
    }


}
