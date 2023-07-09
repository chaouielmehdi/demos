package com.example.batchtemplate.processor;

import com.example.batchtemplate.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Processor implements ItemProcessor<UserEntity, UserEntity> {
	@Override
	public UserEntity process(UserEntity user) {
		user.username = "username_changed_by_batch";
		return user;
	}
}
