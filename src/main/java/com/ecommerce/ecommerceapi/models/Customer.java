package com.ecommerce.ecommerceapi.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * Entity Customer
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    @NotEmpty(message = "Email can not be blank")
    private String email;

    @NotEmpty(message = "Password can not be blank")
    private String password;

    @NotEmpty(message = "Name can not be blank")
    private String customerName;
    
    @Column(columnDefinition="DATETIME")
    private Date registerDate;

    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;
}
