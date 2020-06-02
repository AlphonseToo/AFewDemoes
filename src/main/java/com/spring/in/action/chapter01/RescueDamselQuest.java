package com.spring.in.action.chapter01;

import org.springframework.context.annotation.Configuration;

/**
 *
 *
 * @author Alphonse
 * @date 2020/6/1 11:18
 * @since 1.0
 **/
@Configuration
public class RescueDamselQuest implements Quest {
    public RescueDamselQuest(String s) {
        System.out.println("开始构造：s");
    }
    @Override
    public void embark() {
        System.out.println("RescueDamselQuest: embark");
    }
}
