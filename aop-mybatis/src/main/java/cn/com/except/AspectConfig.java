package cn.com.except;

import cn.com.model.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-07-18 9:54
 * @modified By:
 */

@Aspect
@Slf4j
@Component
public class AspectConfig {

    @Pointcut("execution(* cn.com.controller.MybitsController.*(..))")
    public void manage() {
    }


    @Around("manage()")
    public Object logManage(ProceedingJoinPoint pjp) {

        String uuid = UUID.randomUUID().toString().replace("-", "");
        long start = System.currentTimeMillis();
        try {

            log.info("{} {}接口传入{}", uuid, pjp.getSignature().getName(), Arrays.toString(pjp.getArgs()));

            Object proceed = pjp.proceed();
            log.info("{} {}接口返回{},总体耗时 {}", uuid, pjp.getSignature().getName(), proceed, System.currentTimeMillis() - start);
            if (proceed == null) {
                return ResultVo.successNull();
            }else if(!Object.class.isAssignableFrom(ResultVo.class)){
                return ResultVo.success(proceed);
            }

            return proceed;

        } catch (Throwable e) {
            log.error("{} 执行异常-{}", uuid, e);
            return ResultVo.failed();
        }
    }


}
