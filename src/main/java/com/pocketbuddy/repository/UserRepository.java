package com.pocketbuddy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pocketbuddy.entity.UserEntity;
import java.util.List;


@Repository

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	
	Optional<UserEntity> findByEmail(String email);
}
