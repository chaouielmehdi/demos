package com.example.demo.parse.parsers.factory;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserFactoryConfig {
    @Bean
    public ServiceLocatorFactoryBean getParserBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(IParserFactory.class);
        return factoryBean;
    }
}
