package com.john.name.aspect;

import com.alibaba.fastjson.JSON;
import com.john.name.exception.BusinessException;
import com.john.name.vo.RespData;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author john
 * @version 1.0
 * @date 2020/5/22 15:18
 */
@Slf4j
@Aspect
public class ControllerLogAop {
    @Pointcut("(execution(* com.john..controller..*(..)))")
    public void point() {}

    /**
     * 控制器拦截，将请求日志进行记录操作
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Optional.ofNullable(attributes.getRequest()).ifPresent(request -> {
            log.info("请求url: " + request.getRequestURL());
            log.info("请求ip: " + request.getRemoteAddr());
            if (joinPoint.getArgs().length > 0) {
                String collect = Stream.of(joinPoint.getArgs())
                                       .filter(o -> !(o instanceof HttpServletRequest ||
                                               o instanceof HttpServletResponse || o instanceof MultipartFile))
                                       .map(JSON::toJSONString)
                                       .collect(Collectors.joining(","));
                log.info("请求参数: " + collect);
            }
        });

        Object result;
        long start = System.currentTimeMillis();

        // 捕获请求异常信息
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            result = handlerException(e);
        }

        long end = System.currentTimeMillis();
        log.info("请求耗时: {}ms", (end - start));

        return result;
    }

    /**
     * 处理异常
     *
     * @param ex
     * @return
     */
    private Object handlerException(Exception ex) {
        //已知异常
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            return new RespData(500, businessException.getMessage());
        }

        //未知异常
        ex.printStackTrace();
        log.error("ControllerLogAop_handlerException_error:{}",ex.getMessage());
        return new RespData<>(500, "系统开小差了，请稍后再试！");
    }
}
