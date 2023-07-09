package com.example.integrationtests.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
	public int userId;
	public int id;
	public String title;
	public boolean completed;
}
