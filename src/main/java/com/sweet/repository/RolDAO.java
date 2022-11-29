package com.sweet.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.sweet.entity.Rol;

@Repository
public interface RolDAO extends JpaRepository<Rol, Long> {}