package com.sweet.repository;

	import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;
	
	import com.sweet.entity.User;

@Repository
public interface IUserDAO extends JpaRepository<User, Long> {
	public Optional<User> findByUserName(String username);
}