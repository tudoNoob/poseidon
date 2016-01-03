package com.poseidon.advices;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
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
