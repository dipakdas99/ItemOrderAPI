package com.ecommerce.ItemOrder.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.ItemOrder.Bean.Product;

/**
 * @author dipak.das
 *
 */
@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Modifying
    @Transactional
    @Query("delete from Product p where p.productId = ?1")
    void deleteProductByid(long id);

	@Modifying
    @Transactional
    @Query("select count(*) from Product p where p.productId = ?1 and p.quantity >= ?2")
	List<Integer> getOrderDetails(Long productId, Integer quantity);

	@Modifying
    @Transactional
    @Query("update Product p set p.quantity=p.quantity-?2 where p.productId = ?1")
	void updateQuantityOfProduct(Long productId, Integer quantity);
}
