package com.ale.minichat.util.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Aspect
public class LoggingAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.ale.sneakerstoreapi.controller..*)")
    public void springBeanPointcut(){
    }

    @Around("springBeanPointcut()")
    public Object logAllMethodCallsAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Instant instant = Instant.ofEpochMilli(startTime);
        log.info("From {} is {}", joinPoint.getSignature(), instant);
        var object = joinPoint.proceed();

        Long timeTaken = System.currentTimeMillis() - startTime;
        log.info("- To {} is {}", joinPoint.getSignature(), timeTaken);
        return object;
    }
}
