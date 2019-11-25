package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.models.Customer;
import com.ecommerce.ecommerceapi.models.ProductCategory;
import com.ecommerce.ecommerceapi.reposirories.CustomerRepository;
import com.ecommerce.ecommerceapi.reposirories.ProductCategoryRepository;
import com.ecommerce.ecommerceapi.reposirories.ProductRepository;
import com.ecommerce.ecommerceapi.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcommerceService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    CustomerRepository customerRepository;

    /* PRODUCT */

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProduct(long id){
        return productRepository.getOne(id);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Product product){ productRepository.delete(product); }

    /* Category */
    public ProductCategory saveProductCategory(ProductCategory productcategory){ return productCategoryRepository.save(productcategory); }

    /* Customer */
    public Customer saveCustomer(Customer customer){return customerRepository.save(customer);}

}
