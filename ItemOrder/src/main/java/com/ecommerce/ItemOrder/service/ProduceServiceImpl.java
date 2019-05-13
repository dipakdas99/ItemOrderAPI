package com.ecommerce.ItemOrder.service;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ItemOrder.Bean.Product;
import com.ecommerce.ItemOrder.dao.ProductRepository;

@Service
@Transactional
public class ProduceServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public @NotNull Iterable<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}
	
	@Override
    public Product getProduct(long id) {
        return productRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
 
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

	@Override
	public Product deleteById(long id) {
		Product product = new Product();
		try {
			productRepository.deleteProductByid(id);
		}catch(Exception e){
			return null;
		}
		return product;
	}

}
