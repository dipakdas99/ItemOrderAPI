package com.ecommerce.ItemOrder.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.ItemOrder.Bean.Order;

/**
 * @author dipak.das
 *
 */
@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	@Modifying
    @Transactional
    @Query("SELECT id, dateCreated, quantity, userEmail FROM Order")
	Iterable<Order> findAllOrders();

}
