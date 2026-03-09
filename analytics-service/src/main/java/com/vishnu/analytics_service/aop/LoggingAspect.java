package com.vishnu.analytics_service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.analyticsservice.controller..*(..)) || execution(* com.example.analyticsservice.service..*(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long timeTaken = System.currentTimeMillis() - start;
            log.info("Method={} TimeTaken={}ms",
                    joinPoint.getSignature().toShortString(),
                    timeTaken);
        }
    }
}
