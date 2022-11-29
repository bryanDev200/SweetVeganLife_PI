package com.sweet.service;

	import java.util.List;
	
	import com.sweet.dto.SaveOrder;
	import com.sweet.dto.SaveOrderDetail;
	import com.sweet.entity.Order;

public interface IOrderService {
	public Order saveOrder(SaveOrder bean, List<SaveOrderDetail> data);
}