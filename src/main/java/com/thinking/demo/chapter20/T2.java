package com.thinking.demo.chapter20;


import com.example.demo.conditionDemo.test.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;

/**
 * 每个测试都会生成一个新的对象
 * 四个元注解（meta annotation）：
 * @Target 该注解可以用于什么地方
 * @Retention 表示需要在什么级别保存该注解信息
 * @Documented 将此注解包含在Javadoc中
 * @Inherited 允许子类继承父类中的注解
 *
 * @author Alphonse
 * @date 2019/11/29 14:30
 * @since 1.0
 **/
public class T2{
    HashSet<String> testObject = new HashSet<>();

    protected void func(){
        System.out.println("Ikl");
    }
    public static void command(String className) {
        if(className.isEmpty()) {
            System.out.println("输入的字符串为空！");
         return;
        }
        try {
            Class clazz = Class.forName(className);
            Method[] methods = clazz.getDeclaredMethods();
            for(Method m : methods) {
                int modify = m.getModifiers();
                StringBuilder sb = new StringBuilder();
                sb.append((modify&1) == 1 ? "public " : "");
                sb.append(((modify>>>1)&1) == 1 ? "private " : "");
                sb.append(((modify>>>2)&1) == 1 ? "protected " : "");
                sb.append(((modify>>>3)&1) == 1 ? "static " : "");
                sb.append(((modify>>>4)&1) == 1 ? "final " : "");
                sb.append(((modify>>>5)&1) == 1 ? "synchronized " : "");
                sb.append(((modify>>>6)&1) == 1 ? "volatile " : "");
                sb.append(((modify>>>7)&1) == 1 ? "transient " : "");
                sb.append(((modify>>>8)&1) == 1 ? "native " : "");
                sb.append(((modify>>>9)&1) == 1 ? "interface " : "");
                sb.append(((modify>>>10)&1) == 1 ? "abstract " : "");
                sb.append(((modify>>>11)&1) == 1 ? "strict " : "");
                System.out.println(m.getName() + ": " + sb);
                Annotation[] annotations = m.getDeclaredAnnotations();
                if(annotations.length < 1)
                    continue;
                else
                    m.invoke(clazz.newInstance());
                for(Annotation annotation : annotations) {
                    if(annotation instanceof Test) {
                        m.invoke(clazz.newInstance());
                        break;
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("找不到该类: " + e);
        }
    }

    public static void main(String[] args) {
        command("com.thinking.demo.chapter20.T2");

        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
        System.out.println();
    }
}
