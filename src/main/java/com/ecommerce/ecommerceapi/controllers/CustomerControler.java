package com.ecommerce.ecommerceapi.controllers;

import com.ecommerce.ecommerceapi.models.Customer;
import com.ecommerce.ecommerceapi.services.EcommerceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class CustomerControler {
    @Autowired
    private EcommerceService ecomerceService;

    @PostMapping
    public Customer save(@RequestBody @Valid Customer customer){
        return ecomerceService.saveCustomer(customer);
    }
}
