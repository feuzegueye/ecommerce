package com.ecommerce.ecommerceapi.reposirories;

import com.ecommerce.ecommerceapi.models.Cart;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CartRepository extends CrudRepository<Cart, Long> {
	
}
