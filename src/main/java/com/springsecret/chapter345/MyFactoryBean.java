package com.springsecret.chapter345;

import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * MyFactoryBean
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/12 15:37
 **/

@Component
public class MyFactoryBean implements FactoryBean<Date> {
    @Override
    public Date getObject() throws Exception {
        return DateUtil.offsetDay(new Date(), 2);
    }

    @Override
    public Class<?> getObjectType() {
        return Date.class;
    }
}
