package com.ecommerce.ecommerceapi.controllers;

import com.ecommerce.ecommerceapi.models.Cart;
import com.ecommerce.ecommerceapi.models.CartItem;
import com.ecommerce.ecommerceapi.models.Product;
import com.ecommerce.ecommerceapi.reposirories.CartItemRepository;
import com.ecommerce.ecommerceapi.reposirories.CartRepository;
import com.ecommerce.ecommerceapi.reposirories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/rest/cart")
public class PanierItemController {

    @Autowired
    private CartRepository cartRepository;


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @RequestMapping(value = "/{productId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String saveItem(@RequestParam(value = "q", required = false) String quantity,
                         @RequestParam(value = "productId") Long productId, @RequestParam(value = "cartId") Long cartId){
    		if (quantity == null){throw new IllegalArgumentException("Quantity = null");}
            int q = Integer.parseInt(quantity);
            Cart cart = cartRepository.findById(cartId).get();
            Product product = productRepository.getOne(productId);
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(q);
            cartItem.setCart(cart);
            cartItemRepository.save(cartItem);
            return "ok";
    }

    @RequestMapping(value = "/{cartItemId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "cartItemId") Long cartItemId){
        CartItem cartitem =cartItemRepository.findById(cartItemId).get();
        cartItemRepository.delete(cartitem);
    }
    

}
