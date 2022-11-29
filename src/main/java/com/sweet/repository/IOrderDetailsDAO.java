package com.sweet.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;
	
	import com.sweet.entity.OrderDetail;

@Repository
public interface IOrderDetailsDAO extends JpaRepository<OrderDetail, Long>{}