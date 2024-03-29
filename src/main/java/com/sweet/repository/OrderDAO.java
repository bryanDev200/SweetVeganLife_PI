package com.sweet.repository;
	
	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.stereotype.Repository;

	import com.sweet.entity.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {
	@Query("select o from Order o where o.user.userId = ?1")
	public List<Order> getAllOrdersByUserId(long userId);
}