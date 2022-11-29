package com.sweet.repository;

	import java.util.List;
	import java.util.Optional;
	
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.stereotype.Repository;
	
	import com.sweet.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
	public Optional<User> findByUserName(String username);
	@Query("select u from User u where (u.userFirstNames like ?1) and (?2 is -1 or u.userRol.rolId = ?2) and (?3 is -1 or u.shoop.shoopId = ?3)")
	public List<User> getAllUserFilters(String name, int role, int shoop);
}