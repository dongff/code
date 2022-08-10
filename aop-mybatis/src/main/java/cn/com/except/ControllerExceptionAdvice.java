package cn.com.except;

import cn.com.model.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-08-05 13:55
 * @modified By:
 */
@RestControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {

    @ExceptionHandler({BindException.class})
    public ResultVo MethodArgumentNotValidExceptionHandler(BindException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return ResultVo.validateError(objectError.getDefaultMessage());
    }

    @ExceptionHandler(APIException.class)
    public ResultVo APIExceptionHandler(APIException e) {
        log.error(e.getMessage(), e);
        return new ResultVo(e.getCode(), e.getMsg(), e.getMessage());
    }

}
