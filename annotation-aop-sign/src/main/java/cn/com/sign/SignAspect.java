package cn.com.sign;

import cn.hutool.core.text.CharSequenceUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-07-18 15:29
 * @modified By:
 */
@Aspect
@Component
@Slf4j
public class SignAspect {
    /**
     * SIGN_HEADER.
     */
    private static final String SIGN_HEADER = "X-SIGN";

    /**
     * pointcut.
     */
    @Pointcut("execution(* cn.com.sign.Signature.*(..))")
    private void verifySignPointCut() {
        // nothing
    }

    /**
     * verify sign.
     */
    @Before("verifySignPointCut()")
    public void verify() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String sign = request.getHeader(SIGN_HEADER);

       //  must have sign in header
        if (CharSequenceUtil.isBlank(sign)) {
          //  throw new BusinessException("no signature in header: " + SIGN_HEADER);
        }

        // check signature
        try {
            String generatedSign = generatedSignature(request);
            if (!sign.equals(generatedSign)) {
               // throw new BusinessException("invalid signature");
            }
        } catch (Throwable throwable) {
            //throw new BusinessException("invalid signature");
        }
    }

    private String generatedSignature(HttpServletRequest request) throws IOException {
        // @RequestBody
        String bodyParam = null;
        if (request instanceof ContentCachingRequestWrapper) {
            bodyParam = new String(((ContentCachingRequestWrapper) request).getContentAsByteArray(), StandardCharsets.UTF_8);
        }

        // @RequestParam
        Map<String, String[]> requestParameterMap = request.getParameterMap();

        // @PathVariable
        String[] paths = null;
        ServletWebRequest webRequest = new ServletWebRequest(request, null);
        Map<String, String> uriTemplateVars = (Map<String, String>) webRequest.getAttribute(
                HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
        if (!CollectionUtils.isEmpty(uriTemplateVars)) {
            paths = uriTemplateVars.values().toArray(new String[0]);
        }
        return SignUtil.sign(bodyParam, requestParameterMap, paths);
    }


    //@Before("verifySignPointCut()")
    //public void doBeforeAdvice(JoinPoint joinPoint) {
    //    log.info("==> json??????????????????...");
    //    //?????????????????????????????????
    //    Object[] obj = joinPoint.getArgs();
    //    //AOP??????????????????
    //    joinPoint.getThis();
    //    //?????????????????????
    //    joinPoint.getTarget();
    //    //???????????? ???????????????
    //    org.aspectj.lang.Signature signature = joinPoint.getSignature();
    //    //???????????????????????????
    //    log.info("==> ??????????????????????????? :"+signature.getName());
    //    //AOP??????????????????
    //    log.info("==> AOP??????????????????:"+signature.getDeclaringTypeName());
    //    //AOP??????????????????class?????????
    //    signature.getDeclaringType();
    //    //??????RequestAttributes
    //    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    //    //?????????RequestAttributes?????????HttpServletRequest?????????
    //    HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
    //    log.info("==> ????????????IP???"+request.getRemoteAddr());
    //    //???????????????Session?????????????????????????????????
    //    //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
    //    Enumeration<String> enumeration = request.getParameterNames();
    //    Map<String,String> parameterMap = new HashMap<String,String>();
    //    while (enumeration.hasMoreElements()){
    //        String parameter = enumeration.nextElement();
    //        parameterMap.put(parameter,request.getParameter(parameter));
    //    }
    //    String str = JSON.toJSONString(parameterMap);
    //    if(obj.length > 0) {
    //        log.info("==> ???????????????????????????"+str);
    //    }
    //}
}
