package com.example.demo.conditionDemo.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName: MyConditon
 * @Description: MyConditon
 * @Author: Alphonse
 * @Version: 1.0
 * @Date: 2019/10/12 11:45
 **/
public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        String system = env.getProperty("os.name");
        System.out.println("系统环境为 === " + system);
        if(system.contains("Windows")) {
            return true;
        }
        return false;
    }

}
