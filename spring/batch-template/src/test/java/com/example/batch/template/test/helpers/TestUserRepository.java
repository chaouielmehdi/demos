package com.example.batch.template.test.helpers;

import com.example.batch.template.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserRepository extends JpaRepository<UserEntity, String> {
}
