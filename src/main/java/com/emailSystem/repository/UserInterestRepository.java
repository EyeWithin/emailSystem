package com.emailSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emailSystem.entity.UserInterestEntity;

public interface UserInterestRepository extends JpaRepository<UserInterestEntity, Long> {
	// This interface will automatically provide CRUD operations for UserInterestEntity
	// Additional custom query methods can be defined here if needed

}
