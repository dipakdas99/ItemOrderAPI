package com.ecommerce.ItemOrder.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.ItemOrder.Bean.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Modifying
    @Transactional
    @Query("delete from Product p where p.id = ?1")
    void deleteProductByid(long id);
}
