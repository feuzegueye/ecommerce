package com.ecommerce.ecommerceapi.controllers;

import com.ecommerce.ecommerceapi.models.Cart;
import com.ecommerce.ecommerceapi.models.CartItem;
import com.ecommerce.ecommerceapi.reposirories.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@AllArgsConstructor
@RestController
@RequestMapping("/panier")
public class PanierController extends CoreController{

    @Autowired
    private CartRepository cartRepository;


    @Autowired
    Validator orderValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(orderValidator);
    }

    @PostMapping
    public String save(Cart cart){
        cartRepository.save(cart);
        return "OK";
    }

    @GetMapping("/{cartId}")
    public List<CartItem> getPanierItems(@PathVariable("cartId")  Cart cart){
        return cart.getCartItems();
    }

}
