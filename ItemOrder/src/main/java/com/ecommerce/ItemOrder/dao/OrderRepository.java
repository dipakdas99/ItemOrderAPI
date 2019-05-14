package com.ecommerce.ItemOrder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ItemOrder.Bean.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
