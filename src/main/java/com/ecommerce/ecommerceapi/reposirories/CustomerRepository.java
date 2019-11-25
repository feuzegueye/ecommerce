package com.ecommerce.ecommerceapi.reposirories;

import com.ecommerce.ecommerceapi.models.Customer;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	Customer findByEmail(String email);
	
}
