package cn.com.model;

import lombok.Getter;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-08-05 10:46
 * @modified By:
 */
@Getter
public enum ResultCode implements StatusCode {

    SUCCESS(200, "请求成功"),
    FAILED(1001, "请求失败"),
    VALIDATE_ERROR(1002, "参数校验失败"),
    RESPONSE_PACK_ERROR(1003, "response返回包装失败"),
    SUCCESS_NULL(1004, "请求数据为空");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
