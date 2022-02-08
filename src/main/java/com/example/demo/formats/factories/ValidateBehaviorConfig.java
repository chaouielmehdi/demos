package com.example.demo.formats.factories;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateBehaviorConfig {
    @Bean
    public ServiceLocatorFactoryBean getBehaviorBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(IValidateBehaviorFactory.class);
        return factoryBean;
    }
}