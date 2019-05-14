package com.ecommerce.ItemOrder.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.ItemOrder.Bean.Order;
import com.ecommerce.ItemOrder.dao.OrderRepository;

public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }
     
    @Override
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());
        return this.orderRepository.save(order);
    }
 
    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }
}
