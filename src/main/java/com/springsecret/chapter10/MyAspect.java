package com.springsecret.chapter10;

import com.springsecret.chapter345.DoublePrinter;
import com.springsecret.chapter345.IntegerPrinter;
import com.springsecret.chapter345.Printer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * MyAspect
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/31 19:22
 **/
@EnableAspectJAutoProxy
@Component
public class MyAspect {

    @Pointcut("execution(public * *(*)))")
    void pointCut0(){}

    @Pointcut("execution(public * print(*)))")
    void pointCut1(){}

    @Pointcut("within(com.springsecret..*)")
    void pointCut2(){}

    @Pointcut("@annotation(MyAnnotation)")
    void pointCut3(){}

    void pointCut4(){}

    @Around("pointCut0()")
    Object here0(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("切面0");
        return pjp.proceed();
    }

    @Around("pointCut1()")
    Object here1(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("切面1");
        return pjp.proceed();
    }

    @Before("pointCut2()")
    Object here2(JoinPoint pjp) throws Throwable {
        System.out.println("切面1");
        return null;
    }

    @Around("pointCut3()")
    Object here3(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("切面3");
        return pjp.proceed();
    }

    Object here4(ProceedingJoinPoint pjp, Object retValue) throws Throwable {
        System.out.println("切面4");
        return pjp.proceed();
    }

    Object here5(JoinPoint pjp, Object retValue) throws Throwable {
        System.out.println("切面5");
        return null;
    }
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("classpath:application.xml");
//        DoublePrinter bean = (DoublePrinter)applicationContext1.getBean("doublePrinter");
//        bean.print(2.0);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyAspect.class, IntegerPrinter.class);
        Printer bean = (Printer) applicationContext.getBean("integerPrinter");
        DoublePrinter dp = new DoublePrinter();
        dp.print(2.0);
        bean.print(1);
    }
}
