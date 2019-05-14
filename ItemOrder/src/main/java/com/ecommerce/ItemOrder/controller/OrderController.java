package com.ecommerce.ItemOrder.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ItemOrder.Bean.Order;
import com.ecommerce.ItemOrder.service.OrderService;
import com.ecommerce.ItemOrder.service.ResourceNotFoundException;

/**
 * @author dipak.das
 *
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	/**
	 * Get all odered details
	 * @return {code} getAllOrders{code}
	 */
	@GetMapping(value = { "", "/" })
    public @NotNull Iterable<Order> getOrders() {
        return orderService.getAllOrders();
    }
	/**
	 * Entry of order in the table
	 * @param orders
	 * @return HttpStatus
	 */
	@PostMapping("/create")
	public ResponseEntity<Object> createUser(@Valid @RequestBody List<Order> orders) {
		List<String> listOfOrderIds = new ArrayList<>();
		// Create users
		for (Order order : orders) {	
			try {
				orderService.create(order);
			} catch(ResourceNotFoundException e) {
				listOfOrderIds.add(e.getMessage());
				return new ResponseEntity<Object>(listOfOrderIds, HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<Object>(listOfOrderIds, HttpStatus.OK);
	}
}
