package com.ecommerce.ecommerceapi;

import com.ecommerce.ecommerceapi.controllers.ProductController;
import com.ecommerce.ecommerceapi.hateoas.ProductResource;
import com.ecommerce.ecommerceapi.models.Product;
import com.ecommerce.ecommerceapi.models.ProductCategory;
import com.ecommerce.ecommerceapi.reposirories.ProductCategoryRepository;
import com.ecommerce.ecommerceapi.reposirories.ProductRepository;
import com.ecommerce.ecommerceapi.services.EcommerceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private EcommerceService ecommerceService;
    @MockBean
    private ProductCategoryRepository productcategoryrepository;
    @MockBean
    private ProductRepository productrepository;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public  void index() throws Exception{
        Long cat =Long.valueOf(1);
        ProductCategory pc =productcategoryrepository.getOne(cat);
        List<Product> listproduct = new ArrayList<>();
        Product prod =new Product();
        prod.setName("stylo");
        prod.setCategorie(pc);
       // productrepository.save(prod);
        listproduct.add(prod);
        given(ecommerceService.getProducts()).willReturn(listproduct);
        this.mockMvc.perform(get("/product"))
                .andExpect(status().isOk());


    }

}
