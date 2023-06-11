package com.example.designpatternfactorystrategy.formats.factories;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReadBehaviorConfig {
	@Bean
	public ServiceLocatorFactoryBean getReadBehaviorBean() {
		ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
		factoryBean.setServiceLocatorInterface(IReadBehaviorFactory.class);
		return factoryBean;
	}
}