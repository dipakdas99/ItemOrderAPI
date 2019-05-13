package com.ecommerce.ItemOrder.service;

import javax.validation.constraints.NotNull;

import com.ecommerce.ItemOrder.Bean.Product;

public interface ProductService {

	@NotNull
	Iterable<Product> getAllProducts();

	Product getProduct(long id);

	Product save(Product product);

	Product deleteById(long id);
	
}
