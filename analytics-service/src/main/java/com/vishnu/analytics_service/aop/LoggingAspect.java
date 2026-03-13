package com.vishnu.analytics_service.aop;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.stereotype.Component;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.analyticsservice.controller..*(..)) || execution(* com.example.analyticsservice.service..*(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes != null ? attributes.getRequest() : null;

        try {
            return joinPoint.proceed();
        } finally {
            long timeTaken = System.currentTimeMillis() - start;
            String requestInfo = request != null
                    ? request.getMethod() + " " + request.getRequestURI()
                    : "NON_HTTP_CALL";

            log.info("Request={} Method={} TimeTaken={}ms",
                    requestInfo,
                    joinPoint.getSignature().toShortString(),
                    timeTaken);
        }
    }
}

