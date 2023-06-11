package com.example.designpatternfactorystrategy.formats.factories;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateBehaviorConfig {
    @Bean
    public ServiceLocatorFactoryBean getValidateBehaviorBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(IValidateBehaviorFactory.class);
        return factoryBean;
    }
}