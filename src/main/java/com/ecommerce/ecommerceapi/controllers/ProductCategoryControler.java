package com.ecommerce.ecommerceapi.controllers;

import com.ecommerce.ecommerceapi.models.Product;
import com.ecommerce.ecommerceapi.models.ProductCategory;
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
@RequestMapping("/categories")
public class ProductCategoryControler {
    @Autowired
    private EcommerceService ecommerceService;

    @PostMapping
    public ProductCategory save(@RequestBody @Valid ProductCategory productcategory){
        return ecommerceService.saveProductCategory(productcategory);
    }
}
