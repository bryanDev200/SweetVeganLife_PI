package com.sweet.service.interfaces;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

	import com.sweet.dto.SaveOrder;
	import com.sweet.dto.SaveOrderDetail;
	import com.sweet.entity.Order;
	import com.sweet.repository.IOrderDAO;
	import com.sweet.repository.IOrderDetailsDAO;
	import com.sweet.service.IOrderService;

@Service
public class OrderService implements IOrderService {
	@Autowired
	private IOrderDAO orderDAO;
	@Autowired
	private IOrderDetailsDAO detailDAO;
	
	@Transactional
	@Override
	public Order saveOrder(SaveOrder bean, List<SaveOrderDetail> data) {
		
		return null;
	}
}