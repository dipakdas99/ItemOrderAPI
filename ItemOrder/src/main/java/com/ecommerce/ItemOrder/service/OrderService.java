package com.ecommerce.ItemOrder.service;

import com.ecommerce.ItemOrder.Bean.Order;

/**
 * @author dipak.das
 *
 */
public interface OrderService {

	Iterable<Order> getAllOrders();

	Order create(Order order);

	void update(Order order);

}
