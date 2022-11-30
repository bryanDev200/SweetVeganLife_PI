package com.sweet.service.interfaces;

	import java.util.List;

import com.sweet.dto.OrderRegisterDTO;
	import com.sweet.entity.Order;

public interface IOrderService {
	public Order saveOrder(OrderRegisterDTO bean);
	public List<Order> getOrdersByUserId(int userId);
}