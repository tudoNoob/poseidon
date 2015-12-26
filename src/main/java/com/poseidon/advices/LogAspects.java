package com.poseidon.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspects {



    @Before("execution(* com.poseidon.*..*(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
        Logger LOGGER = LoggerFactory.getLogger(joinPoint.getSignature().getName());
        LOGGER.info("Accessing {}", joinPoint.getSignature().toShortString());
    }

}
