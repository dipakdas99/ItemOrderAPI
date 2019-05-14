package com.ecommerce.ItemOrder.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ItemOrder.Bean.Order;
import com.ecommerce.ItemOrder.dao.OrderRepository;
import com.ecommerce.ItemOrder.dao.ProductRepository;

/**
 * @author dipak.das
 *
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<Order> getAllOrders() {
		return this.orderRepository.findAllOrders();
	}

	@Override
	public Order create(Order order) {
		List<Integer> count = productRepository.getOrderDetails(order.getProduct().getProductId(), order.getQuantity());
		if (count.get(0) == 1) {
			order.setDateCreated(LocalDate.now());
			Order orderResponse = this.orderRepository.save(order);
			productRepository.updateQuantityOfProduct(order.getProduct().getProductId(), order.getQuantity());
			return orderResponse;
		}
		throw new ResourceNotFoundException("Item or quantity is invalid");
	}

	@Override
	public void update(Order order) {
		this.orderRepository.save(order);
	}

}
