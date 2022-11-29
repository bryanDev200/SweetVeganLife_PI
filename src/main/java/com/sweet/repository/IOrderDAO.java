package com.sweet.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.sweet.entity.Order;

@Repository
public interface IOrderDAO extends JpaRepository<Order, Long> {}