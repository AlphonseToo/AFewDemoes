package com.spring.in.action.chapter04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/12/26 14:38
 * @since 1.0
 **/
@Aspect
public class Audience_2 {

    // 定义命名的切点
    @Pointcut("execution(** com.spring.in.action.chapter04.Performance.perform(..))")
    public void performance(){}

    @Around("performance()")
    public int watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
        return 1;
    }

}
