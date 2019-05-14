package com.ecommerce.ItemOrder.service;

/**
 * @author dipak.das
 *
 */
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
