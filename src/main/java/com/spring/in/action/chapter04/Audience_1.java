package com.spring.in.action.chapter04;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/26 14:38
 * @since 1.0
 **/
@Aspect
public class Audience_1 {

    // 定义命名的切点
    @Pointcut("execution(** com.spring.in.action.chapter04.Performance.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("performance())")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("performance())")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

}
