package com.ecommerce.ecommerceapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;


/**
 * Entity Cart
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart{

    @Id
    @GeneratedValue
    private Long cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;

}
