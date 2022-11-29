package com.sweet.service;

	import java.util.Date;
	import java.util.List;
	import java.util.stream.Collectors;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;
	
	import com.sweet.dto.OrderRegisterDTO;
	import com.sweet.entity.Order;
	import com.sweet.entity.OrderDetail;
	import com.sweet.entity.Payment;
	import com.sweet.entity.Product;
	import com.sweet.entity.Shoop;
	import com.sweet.entity.User;
	import com.sweet.repository.OrderDAO;
	import com.sweet.repository.OrderDetailDAO;
	import com.sweet.service.interfaces.IOrderService;
	
@Service
public class OrderService implements IOrderService {
	@Autowired
	private OrderDAO orderRepo;
	@Autowired
	private OrderDetailDAO detailDAO;
	
	@Transactional
	@Override
	public Order saveOrder(OrderRegisterDTO bean) {
		Order order = new Order();
		
		order.setFinalAmount(bean.getFinalAmount());
		order.setPayment(new Payment(bean.getPaymentId()));
		order.setShoop(new Shoop(bean.getShoopId()));
		order.setUser(new User(bean.getUserId()));
		order.setOrderState("A");
		order.setOrderDate(new Date());
		
		Order orderSaved = orderRepo.save(order);
		
		List<OrderDetail> data = bean.getDetails().stream()
				.map((detail) -> new OrderDetail(new Order(orderSaved.getOrderId()),
						new Product(detail.getProductId()), detail.getQuantity(), detail.getPrice()))
				.collect(Collectors.toList());
		
		List<OrderDetail> response = detailDAO.saveAll(data);
		
		Order lastOrder = orderRepo.findById(orderSaved.getOrderId()).orElse(null);
		
		return lastOrder;
	}

}