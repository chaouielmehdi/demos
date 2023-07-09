package com.example.batchtemplate.writer;

import com.example.batchtemplate.entities.UserEntity;
import com.example.batchtemplate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DatabaseWriter implements ItemWriter<UserEntity> {
	private final UserRepository userRepository;

	@Override
	public void write(Chunk<? extends UserEntity> chunk) {
		for(UserEntity user : chunk) {
			userRepository.saveAndFlush(user);
		}
	}
}
