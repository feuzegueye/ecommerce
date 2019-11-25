package com.ecommerce.ecommerceapi.controllers;


import com.ecommerce.ecommerceapi.hateoas.ProductResource;
import com.ecommerce.ecommerceapi.models.Product;
import com.ecommerce.ecommerceapi.services.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController extends CoreController{

    @Autowired
    private EcommerceService ecommerceService;

    @Autowired
    Validator productValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(productValidator);
    }

    @GetMapping
    public List<ProductResource> index() {
        List<Product> res = ecommerceService.getProducts();
        List<ProductResource> output = new ArrayList<ProductResource>();
        res.forEach((p)->{
            ProductResource pr = new ProductResource(p);
            pr.add(createHateoasLink(p.getId()));
            output.add(pr);
        });
        return output;
    }

    @PostMapping
    public Product save(@RequestBody @Valid Product product){
        return ecommerceService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public ResourceSupport view(@PathVariable("id") long id) {
        Product p = ecommerceService.getProduct(id);
        ProductResource pr = new ProductResource(p);
        pr.add(createHateoasLink(p.getId()));
        return pr;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("id") long id){
        Product p = ecommerceService.getProduct(id);
        ecommerceService.deleteProduct(p);
        return "ok";
    }



}