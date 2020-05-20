package com.diode.mvc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author unlikeha@163.com
 * @date 2020/5/20
 */

@Aspect
@Component
public class TimeRecord {

    private static final Logger logger = LoggerFactory.getLogger("request");

    @Around("within(com.diode.mvc.service.*) && execution(public * *(..))")
    public Object monitor(ProceedingJoinPoint pjp) throws Throwable {//ProceedingJoinPoint：用于环绕通知
        String targetClassName = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();
        String methodFullName = targetClassName + "." + methodName;

        Object[] args = pjp.getArgs();// 方法参数

        Object result = null;
        try {
            logger.info("methodFullName=" + methodFullName);
            long begin = System.currentTimeMillis();
            result = pjp.proceed();

            long delay = System.currentTimeMillis() - begin;
            logger.info("delay=" + delay);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            logger.info("methodFullName=" + methodFullName + ",result=" + result);
        }

        return result;
    }

}
