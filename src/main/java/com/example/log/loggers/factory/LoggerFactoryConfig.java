package com.example.log.loggers.factory;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerFactoryConfig {
    @Bean
    public ServiceLocatorFactoryBean getLoggerBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(ILoggerFactory.class);
        return factoryBean;
    }
}
