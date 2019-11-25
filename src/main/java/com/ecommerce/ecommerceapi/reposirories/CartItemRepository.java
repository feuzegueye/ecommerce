package com.ecommerce.ecommerceapi.reposirories;

import com.ecommerce.ecommerceapi.models.CartItem;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CartItemRepository extends CrudRepository<CartItem, Long> {

}
