package com.sweet.service.interfaces;

	import com.sweet.dto.OrderRegisterDTO;
	import com.sweet.entity.Order;

public interface IOrderService {
	public Order saveOrder(OrderRegisterDTO bean);
}