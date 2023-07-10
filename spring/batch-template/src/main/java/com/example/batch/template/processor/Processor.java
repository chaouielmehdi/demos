package com.example.batch.template.processor;

import com.example.batch.template.entities.UserEntity;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<UserEntity, UserEntity> {
	@Override
	public UserEntity process(UserEntity user) {
		return user;
	}
}
