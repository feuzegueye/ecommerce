package com.ecommerce.ecommerceapi.reposirories;

import com.ecommerce.ecommerceapi.models.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productCategoryRepository")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}