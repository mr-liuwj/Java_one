package com.lcy.controller;

import com.lcy.model.WebLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author liuweijin
 * @date 2024-11-08
 * @desc
 */
@Aspect//切面
@Component
@Order(1)
public class WebLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    //切点
    @Pointcut("execution(public * com.lcy.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")//通知
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        System.out.println("??"+method.getName());
    }

    @After("webLog()")//通知
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        System.out.println("LLLLLLLLLLLLL");
    }

    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) throws Throwable {
        System.out.println(ret.toString());
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("!!"+startTime);
        //获取当前请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //记录请求信息(通过Logstash传入Elasticsearch)
        WebLog webLog = new WebLog();
        Object result = joinPoint.proceed();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
//        if (method.isAnnotationPresent(ApiOperation.class)) {
//            ApiOperation log = method.getAnnotation(ApiOperation.class);
//            webLog.setDescription(log.value());
//        }
        long endTime = System.currentTimeMillis();
        String urlStr = request.getRequestURL().toString();
        webLog.setBasePath(">>");
        webLog.setIp(request.getRemoteUser());
        Map<String,Object> logMap = new HashMap<>();
        logMap.put("spendTime",webLog.getSpendTime());
        logMap.put("description",webLog.getDescription());
        logger.info("{}", webLog.toString());
        return result;
    }
}
