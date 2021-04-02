package com.springsecret.chapter9;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * ITester
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/22 20:00
 **/
@Component
public class ITester implements ITest {
    private boolean busy;

    @Override
    public boolean isBusy() {
        return busy;
    }

    @Override
    public void test() {
        System.out.println("I will ensure the quality.");
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ITester.class);
        ITest bean = (ITester) applicationContext.getBean("ITester");
        bean.test();
        System.out.println(bean.isBusy());

        ITester iTester = new ITester();
        System.out.println(iTester.isBusy());
    }
}
