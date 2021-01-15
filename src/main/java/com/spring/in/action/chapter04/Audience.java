package com.spring.in.action.chapter04;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/12/26 14:38
 * @since 1.0
 **/
@Aspect
public class Audience {
    @Before("execution(* com.spring.in.action.chapter04.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("execution(* com.spring.in.action.chapter04.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("execution(* com.spring.in.action.chapter04.Performance.perform(..))")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("execution(* com.spring.in.action.chapter04.Performance.perform(..)")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

}
