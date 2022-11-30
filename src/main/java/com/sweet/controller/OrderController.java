package com.sweet.controller;
	
	import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	
	import com.sweet.dto.OrderRegisterDTO;
import com.sweet.dto.UserOrderDTO;
import com.sweet.dto.UserOrderDetailsDTO;
import com.sweet.entity.Order;
	import com.sweet.service.interfaces.IOrderService;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveOrder(@RequestBody OrderRegisterDTO bean){
		HashMap<String, Object> response = new HashMap<>();
		Order order = orderService.saveOrder(bean);
		
		if(order != null) {
			response.put("order", order);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}else {
			response.put("message", "Error al registrar pedido");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getOrdersByUsers(@PathVariable int userId){
		HashMap<String, Object> response = new HashMap<>();
		
		List<UserOrderDTO> data = orderService.getOrdersByUserId(userId).stream()
				.map((order) -> {
					UserOrderDTO result = new UserOrderDTO();
					result.setId(order.getOrderId());
					result.setOrderDate(order.getOrderDate());
					result.setFinalAmount(order.getFinalAmount());
					result.setPaymentName(order.getPayment().getPaymentDescription());
					result.setDetails(order.getDetails().stream()
							.map((detail) -> new UserOrderDetailsDTO(detail.getProduct().getProductId(),
									detail.getProduct().getProductName(), detail.getPrice(), detail.getQuantity()))
							.collect(Collectors.toList()));
					return result;
				}).collect(Collectors.toList());
		
		response.put("data", data);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}