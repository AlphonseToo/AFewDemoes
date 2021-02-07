package com.springsecret;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * HardCoding
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/2/7 16:21
 **/
public class HardCoding {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegister = new DefaultListableBeanFactory();
        BeanFactory beanFactory = bindViaCode(beanRegister);
        FXNewsProvider newsProvider = (FXNewsProvider)beanFactory.getBean("newProvider");
        newsProvider.getAndPersistNews();
    }

    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry) {
        AbstractBeanDefinition newProvider = new RootBeanDefinition(FXNewsProvider.class);
        AbstractBeanDefinition newListener = new RootBeanDefinition(DowJonesNewsListener.class);
        AbstractBeanDefinition newPersister = new RootBeanDefinition(DowJonesNewsPersister.class);
        registry.registerBeanDefinition("newProvider", newProvider);
        registry.registerBeanDefinition("newListener", newListener);
        registry.registerBeanDefinition("newPersister", newPersister);

        // 构造器注入
        ConstructorArgumentValues argumentValues = new ConstructorArgumentValues();
        argumentValues.addIndexedArgumentValue(0, newListener);
        argumentValues.addIndexedArgumentValue(1, newPersister);
        newProvider.setConstructorArgumentValues(argumentValues);

        // set注入
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("listener", newListener));
        propertyValues.addPropertyValue(new PropertyValue("persister", newPersister));
        newProvider.setPropertyValues(propertyValues);

        return (BeanFactory)registry;
    }
}
