package tn.esprit.piDev.config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class CnfigAOP {

    @Before("execution(* tn.esprit.piDev.services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }


    @After("execution(* tn.esprit.piDev.services.*.*(..))")
    public void logMethodOut(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method " + name + " : ");
    }

    @Around("execution(* tn.esprit.piDev.services.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable
    {
        long start= System.currentTimeMillis();

        Object obj= pjp.proceed();

        long elapsedTime= System.currentTimeMillis() -start;

        log.info("Methodexecutiontime: " + elapsedTime+ " milliseconds.");
        return obj;
    }


}
