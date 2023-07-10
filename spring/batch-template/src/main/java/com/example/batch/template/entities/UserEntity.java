package com.example.batch.template.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "USERS")
@Entity
public class UserEntity extends AbstractEntity {
	public String username;
}
