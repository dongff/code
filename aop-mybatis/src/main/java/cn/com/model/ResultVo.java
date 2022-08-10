package cn.com.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-08-05 10:51
 * @modified By:
 */
@Data
@Builder
@AllArgsConstructor
public class ResultVo<T> {
    // 状态码
    private int code;

    // 状态信息
    private String msg;

    // 返回对象
    private T data;

    // 手动设置返回vo
    public  static <T> ResultVo<T> failed () {
        return ResultVo.<T>builder()
                .code(ResultCode.FAILED.getCode())
                .msg(ResultCode.FAILED.getMsg())
                .build();
    }

    // 手动设置返回vo
    public  static <T> ResultVo<T> success ( T data) {
        return ResultVo.<T>builder()
                .code(ResultCode.SUCCESS.getCode())
                .msg(ResultCode.SUCCESS.getMsg())
                .data(data)
                .build();
    }

    // 默认返回成功状态码，数据对象
    public static <T> ResultVo<T> validateError(String msg) {
       return ResultVo.<T>builder()
               .code(ResultCode.VALIDATE_ERROR.getCode())
               .msg(msg)
               .build();
    }


    // 默认返回成功状态码，数据对象
    public static <T> ResultVo<T> responsePackError(T data) {
        return ResultVo.<T>builder()
                .code(ResultCode.RESPONSE_PACK_ERROR.getCode())
                .msg(ResultCode.RESPONSE_PACK_ERROR.getMsg())
                .data(data)
                .build();
    }

    public static ResultVo successNull(){
        return ResultVo.builder()
                .code(ResultCode.SUCCESS_NULL.getCode())
                .msg(ResultCode.SUCCESS_NULL.getMsg())
                .build();
    }


}
