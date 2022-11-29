package com.sweet.repository;
	
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.sweet.entity.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {

}