- 技术栈
   mybatis-plus 实现读取mysql数据库
 - 统一异常 ControllerExceptionAdvice实现 @NotNull(message = "商品名称不允许为空")字段的异常返回。
    @Valid @RequestBody实现多层验证，抛出异常MethodArgumentNotValidException.class
    @Validated 抛出异常{BindException.class} 可用在类和方法上
    @RestControllerAdvice+ @ExceptionHandler捕捉抛出的异常类
     ControllerResponseAdvice类判断返回值类型，可用AspectConfig代替。

 - spring-retry重试机制
    有2种形式，第一种是@Retryable注解，第二种是定义RetryTemplate
     @Retryable(value = RestClientException.class,maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 2))
     定义RetryTemplate方法 ，TestBeanProviper类定义， @Qualifier("simpleRetryTemplate")调用方法
  
 - 计时工具类 Time   
 - 统一返回 使用 ResultVo<T>泛型 ResultCode枚举统一定义返回格式

 

    
 
 
