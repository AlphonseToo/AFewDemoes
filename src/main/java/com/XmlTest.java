package com;

import cn.hutool.core.util.StrUtil;
import com.sourcecode.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aa.xml");
        User user = (User)context.getBean("testbean");
        System.out.println(user.getName() + "," + user.getAge() + "," + user.getId());
        StrUtil.split("sssss", "s");
    }
}
