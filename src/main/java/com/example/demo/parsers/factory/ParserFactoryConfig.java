package com.example.demo.parsers.factory;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserFactoryConfig {
    @Bean
    public ServiceLocatorFactoryBean getParserFactoryBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(IParserFactory.class);
        return factoryBean;
    }
}
