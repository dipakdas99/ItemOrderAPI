package com.ecommerce.ItemOrder.controller;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.ItemOrder.Bean.Product;
import com.ecommerce.ItemOrder.service.ProductService;
import com.ecommerce.ItemOrder.service.ResourceNotFoundException;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = { "", "/" })
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
	@GetMapping(value = "/{id}")
	public @NotNull Product getProduct(@PathVariable long id) {
		return productService.getProduct(id);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Object> createUser(@Valid @RequestBody Product product) {
		// Create users
		Product savedProduct = productService.save(product);
		// returning correct response status as (201) for successful creation
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedProduct.getId())
			.toUri();
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable long id) {
		//delete individual user
		Product product = productService.deleteById(id);
		if (product == null)
			throw new ResourceNotFoundException("id: "+id);
	}
}
